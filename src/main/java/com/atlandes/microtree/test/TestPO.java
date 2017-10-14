package com.atlandes.microtree.test;

import com.atlandes.microtree.data.BusinessData;

/**
 * Created by XD.Wang on 2017/10/12.
 * test
 */
public class TestPO implements BusinessData {

    private Integer id;
    private Integer level;
    private String name;
    private Object data;
    private Integer parent;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Object getData() {
        return data;
    }

    @Override
    public Integer getParent() {
        return parent;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
