package com.benbenxiang.test.jvm;

public class User {
    private int id;
    private String uuid;

    public User(int id, String uuid) {
        super();
        this.id = id;
        this.uuid = uuid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
