//package com.alibaba.coin.demo.spring;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.BeanFactory;
//import org.springframework.beans.factory.BeanFactoryAware;
//import org.springframework.beans.factory.DisposableBean;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
//import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
//import org.springframework.beans.factory.support.RootBeanDefinition;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.context.EnvironmentAware;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.PreDestroy;
//
//@Slf4j
//@Configuration
//public class BeanLifeCycleManager {
//
//    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanLifeCycleManager.class);
//        context.getBean("beanLifeCycle");
//        context.close();
//    }
//
//    @Bean(initMethod = "init", destroyMethod = "destroyMethod")
//    public BeanLifeCycle beanLifeCycle() {
//        return new BeanLifeCycle();
//    }
//
//    interface MyAware extends ApplicationContextAware, EnvironmentAware, BeanFactoryAware {
//
//    }
//
//    @Component
//    static class MyMergedBeanDefinitionPostProcessor implements MergedBeanDefinitionPostProcessor {
//
//        @Override
//        public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {
//            if ("beanLifeCycle".equals(beanName)) {
//                log.info(">>>>>>>>>>元信息收集 ，MergedBeanDefinitionPostProcessor#postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) \nbeanDefinition = [{}]\n,beanType = [{}],beanName = [{}]\n", beanDefinition, beanType, beanName);
//            }
//        }
//    }
//
//    @Component
//    static class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
//        @Override
//        public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
//            if ("beanLifeCycle".equals(beanName)) {
//                log.info(">>>>>>>>>>实例化前，InstantiationAwareBeanPostProcessor#postProcessBeforeInstantiation(Class<?> beanClass,String beanName) \nbeanClass = [{}],beanName = [{}]\n", beanClass, beanName);
//            }
//            return null;
//        }
//
//        @Override
//        public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
//            if ("beanLifeCycle".equals(beanName)) {
//                log.info(">>>>>>>>>>实例化后，InstantiationAwareBeanPostProcessor#postProcessAfterInstantiation(Object bean, String beanName)\nbean = [{}],beanName = [{}]\n", bean, beanName);
//            }
//            return false;
//        }
//
//        @Override
//        public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//            if ("beanLifeCycle".equals(beanName)) {
//                log.info(">>>>>>>>>>初始化前，InstantiationAwareBeanPostProcessor#postProcessBeforeInitialization(Object bean, String beanName)\nbean= [{}],beanName = [{}]\n", bean, beanName);
//            }
//            return bean;
//        }
//
//        @Override
//        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//            if ("beanLifeCycle".equals(beanName)) {
//                log.info(">>>>>>>>>>初始化后，InstantiationAwareBeanPostProcessor#postProcessAfterInitialization(Object bean, String beanName)\nbean= [{}],beanName = [{}]\n", bean, beanName);
//            }
//            return bean;
//        }
//    }
//
//    public static class BeanLifeCycle implements InitializingBean, MyAware, DisposableBean {
//        public void init() {
//            log.info(">>>>>>>>>>init-method\n");
//        }
//
//        @PostConstruct
//        public void postConstruct() {
//            log.info(">>>>>>>>>>postConstruct\n");
//        }
//
//        @Override
//        public void afterPropertiesSet() throws Exception {
//            log.info(">>>>>>>>>>afterPropertiesSet\n");
//        }
//
//        public void destroyMethod() {
//            log.info(">>>>>>>>>>destroy-method\n");
//        }
//
//        @Override
//        public void destroy() {
//            log.info(">>>>>>>>>>DisposableBean-destroy\n");
//        }
//
//        @PreDestroy
//        public void preDestroy() {
//            log.info(">>>>>>>>>>preDestroy\n");
//        }
//
//
//        @Override
//        public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
//            log.info(">>>>>>>>>>BeanFactoryAware#setBeanFactory\n");
//        }
//
//        @Override
//        public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//            log.info(">>>>>>>>>>ApplicationContextAware#setApplicationContext\n");
//        }
//
//        @Override
//        public void setEnvironment(Environment environment) {
//            log.info(">>>>>>>>>>EnvironmentAware#setEnvironment\n");
//        }
//    }
//}