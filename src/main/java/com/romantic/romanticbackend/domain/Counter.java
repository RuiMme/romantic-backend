package com.romantic.romanticbackend.domain;

import java.io.Serializable;

public class Counter implements Serializable {

    private int id;
    private int count;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
