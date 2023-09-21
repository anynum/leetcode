package com.anynum.demo.annotation;


public class InternalClassTest {


}


class ExternalClass {
    private String name;
    private static Integer age;

    public static void say(){
        System.out.println();
    }


    static class InternalClass {
        public void print() {
            // 不能访问外部类非静态成员
            // System.out.println("name:" + name);

            // 访问外部类静态成员
            System.out.println("age" + age);

        }
    }
}