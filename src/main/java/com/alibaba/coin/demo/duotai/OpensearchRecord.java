package com.alibaba.coin.demo.duotai;

import java.io.Serializable;

public abstract class OpensearchRecord implements Serializable {

    /**
     * @Fields id:主键id
     */
    protected String id;
    
    public OpensearchRecord(Long id) {
        this.id = String.valueOf(id);
    }

    public OpensearchRecord(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}