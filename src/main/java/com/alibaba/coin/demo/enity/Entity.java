package com.alibaba.coin.demo.enity;

/**
 * @author guopeng.Zgp 2022.09.15
 */
public class Entity {

    private Boolean success;

    private String name;

    public Entity(Boolean success, String name) {
        this.success = success;
        this.name = name;
    }

    public Entity() {

    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
