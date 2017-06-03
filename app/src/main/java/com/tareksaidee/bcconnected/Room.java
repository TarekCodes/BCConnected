package com.tareksaidee.bcconnected;

import java.io.Serializable;

/**
 * Created by tarek on 5/31/2017.
 */

public class Room implements Serializable {

    private String name;
    private String password;
    private boolean locked;

    Room() {
    }

    Room(String name) {
        this.name = name;
        password = null;
        locked = false;
    }

    Room(String name, String pw) {
        this.name = name;
        password = pw;
        locked = true;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getPassword() {
        return password;
    }

    void setPassword(String pw) {
        password = pw;
    }

    boolean isLocked() {
        return locked;
    }
}
