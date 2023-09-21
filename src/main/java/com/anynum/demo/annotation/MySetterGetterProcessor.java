package com.anynum.demo.annotation;


import com.sun.source.tree.Tree;
import com.sun.tools.javac.api.JavacTrees;
import com.sun.tools.javac.code.Flags;
import com.sun.tools.javac.code.Type;
import com.sun.tools.javac.processing.JavacProcessingEnvironment;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.TreeMaker;
import com.sun.tools.javac.tree.TreeTranslator;
import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.util.List;
import com.sun.tools.javac.util.ListBuffer;
import com.sun.tools.javac.util.Name;
import com.sun.tools.javac.util.Names;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;

/**
 * AbstractProcessor是本次的核心类，编译器在编译的时候会扫描此类的子类,其中有一个子类必须实现的核心方法 process()，
 * 此方法如果是返回为true就说明编译的那个类抽象树的结构又变化，需要重新进行词法分析和语法分析。
 * 如果返回的是false就说明没有变化。
 */
@SupportedAnnotationTypes("com.study.practice.nameChecker.MySetterGetter")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class MySetterGetterProcessor extends AbstractProcessor {

    // 主要是输出信息
    private Messager messager;

    private JavacTrees javacTrees;

    private TreeMaker treeMaker;

    private Names names;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        javax.annotation.processing.Messager messager = processingEnv.getMessager();
        this.javacTrees = JavacTrees.instance(processingEnv);
        Context context = ((JavacProcessingEnvironment)processingEnv).getContext();
        this.treeMaker = TreeMaker.instance(context);
        this.names = Names.instance(context);
    }

    /**
     * 主要的操作逻辑是：
     *
     * 1、拿到所有被我们MySetterGetter标注的类。
     * 2、遍历所有的类，生成类的抽象树结构。
     * 3、对类进行操作：
     * 4、找到类中所有的变量。
     * 5、对变量进行生成Set和Get方法。
     * 6、返回 true，说明类结构变了，需要重新解析。如果是false说明没有变，不用重新解析，这个会在我们的规范检测器里面用到。
     */
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        // 拿到被注解标注的所有的类
        Set<? extends Element> elementsAnnotatedWith = roundEnv.getElementsAnnotatedWith(MySetterGetter.class);
        elementsAnnotatedWith.forEach(element -> {
            // 得到类的抽象树结构
            JCTree tree = javacTrees.getTree(element);
            // 遍历类，对类进行修改
            tree.accept(new TreeTranslator(){
                @Override
                public void visitClassDef(JCTree.JCClassDecl jcClassDecl) {
                    List<JCTree.JCVariableDecl> jcVariableDeclList = List.nil();

                    String str = "";
                    str.length();
                    // 在抽象树中找出所有的变量
                    for(JCTree jcTree: jcClassDecl.defs){
                        if (jcTree.getKind().equals(Tree.Kind.VARIABLE)){
                            JCTree.JCVariableDecl jcVariableDecl = (JCTree.JCVariableDecl)jcTree;
                            jcVariableDeclList = jcVariableDeclList.append(jcVariableDecl);
                        }
                    }

                    // 对于变量进行生成方法的操作
                    for (JCTree.JCVariableDecl jcVariableDecl : jcVariableDeclList) {
                        messager.printMessage(Diagnostic.Kind.NOTE, jcVariableDecl.getName() + " has been processed");

                        jcClassDecl.defs = jcClassDecl.defs.prepend(makeSetterMethodDecl(jcVariableDecl));
                        jcClassDecl.defs = jcClassDecl.defs.prepend(makeGetterMethodDecl(jcVariableDecl));
                    }

                    super.visitClassDef(jcClassDecl);
                }

            });

        });

        return true;
    }

    /**
     * 添加一个setter方法
     * @param jcVariableDecl
     * @return
     */
    private JCTree.JCMethodDecl makeSetterMethodDecl(JCTree.JCVariableDecl jcVariableDecl) {
        ListBuffer<JCTree.JCStatement> statements = new ListBuffer<>();
        // 生成表达式 例如 this.a = a;

        JCTree.JCExpressionStatement aThis = makeAssignment(treeMaker.Select(treeMaker.Ident(names.fromString("this")), jcVariableDecl.getName()), treeMaker.Ident(jcVariableDecl.getName()));
        statements.append(aThis);
        JCTree.JCBlock block = treeMaker.Block(0, statements.toList());

        // 生成入参
        JCTree.JCVariableDecl param = treeMaker.VarDef(treeMaker.Modifiers(Flags.PARAMETER), jcVariableDecl.getName(), jcVariableDecl.vartype, null);
        List<JCTree.JCVariableDecl> parameters = List.of(param);

        // 生成返回对象
        JCTree.JCExpression methodType = treeMaker.Type(new Type.JCVoidType());

        Name name = jcVariableDecl.getName();
        return treeMaker.MethodDef(treeMaker.Modifiers(Flags.PUBLIC), getNewSetterMethodName(name), methodType, List.nil(), parameters, List.nil(), block, null);
    }

    /**
     * 生成 getter 方法
     * @param jcVariableDecl
     * @return
     */
    private JCTree.JCMethodDecl makeGetterMethodDecl(JCTree.JCVariableDecl jcVariableDecl){
        ListBuffer<JCTree.JCStatement> statements = new ListBuffer<>();
        // 生成表达式
        JCTree.JCReturn aReturn = treeMaker.Return(treeMaker.Ident(jcVariableDecl.getName()));
        statements.append(aReturn);
        JCTree.JCBlock block = treeMaker.Block(0, statements.toList());

        // 无入参
        // 生成返回对象
        JCTree.JCExpression returnType = treeMaker.Type(jcVariableDecl.getType().type);

        return treeMaker.MethodDef(treeMaker.Modifiers(Flags.PUBLIC), getNewGetterMethodName(jcVariableDecl.getName()), returnType, List.nil(), List.nil(), List.nil(), block, null);
    }

    /**
     * 拼装Setter方法名称字符串
     * @param name
     * @return
     */
    private Name getNewSetterMethodName(Name name) {
        String s = name.toString();
        return names.fromString("set" + s.substring(0,1).toUpperCase() + s.substring(1, name.length()));
    }

    /**
     * 拼装 Getter 方法名称的字符串
     * @param name
     * @return
     */
    private Name getNewGetterMethodName(Name name) {
        String s = name.toString();
        return names.fromString("get" + s.substring(0,1).toUpperCase() + s.substring(1, name.length()));
    }

    /**
     * 生成表达式
     * @param lhs
     * @param rhs
     * @return
     */
    private JCTree.JCExpressionStatement makeAssignment(JCTree.JCExpression lhs, JCTree.JCExpression rhs) {
        return treeMaker.Exec(
                treeMaker.Assign(lhs, rhs)
        );
    }
}