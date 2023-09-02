package com.alibaba.coin.demo.duotai;

class ExternalClass {
    private String name;


    class InternalClass {
        public void print() {
            // 访问外部类私有属性
            System.out.println("name:" + name);
        }
    }
}