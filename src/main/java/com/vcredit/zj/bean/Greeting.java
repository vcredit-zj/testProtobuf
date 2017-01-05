package com.vcredit.zj.bean;

/**
 * Created by shibenli on 2017/1/5.
 */

public class Greeting {

    private final long id;
    private final String name;
    private final String desc;


    public Greeting(long id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}