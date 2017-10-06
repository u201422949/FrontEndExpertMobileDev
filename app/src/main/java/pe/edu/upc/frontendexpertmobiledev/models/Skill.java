package pe.edu.upc.frontendexpertmobiledev.models;

import java.io.Serializable;

/**
 * Created by paul.cabrera on 06/10/2017.
 */

public class Skill implements Serializable {
    private int code;
    private String name;

    public int getCode() {
        return code;
    }

    public Skill setCode(int code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public Skill setName(String name) {
        this.name = name;
        return this;
    }

    public Skill(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public Skill() {
    }

    public String toString(){
        return name;
    }
}
