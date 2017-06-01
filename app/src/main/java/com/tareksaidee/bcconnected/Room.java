package com.tareksaidee.bcconnected;

import java.io.Serializable;

/**
 * Created by tarek on 5/31/2017.
 */

public class Room implements Serializable{

    private String name;

    Room(){}

    Room(String name){
        this.name = name;
    }

    String getName(){
        return name;
    }

    void setName(String name){
        this.name = name;
    }
}
