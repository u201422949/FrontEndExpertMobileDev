package pe.edu.upc.frontendexpertmobiledev.models;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Request {
    private Integer id;
    private User user;
    private Specialty specialty;
    private String topic;
    private String description;
    private String state;

    public Request(Skill skill, String s, String toString) {
    }

    public Request(Integer id, User user, Specialty specialty, String topic, String description, String state) {
        this.id = id;
        this.user = user;
        this.specialty = specialty;
        this.topic = topic;
        this.description = description;
        this.state = state;
    }


    public Integer getId() {
        return id;
    }

    public Request setId(Integer id) {
        this.id = id;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Request setUser(User user) {
        this.user = user;
        return this;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public Request setSpecialty(Specialty specialty) {
        this.specialty = specialty;
        return this;
    }

    public String getTopic() {
        return topic;
    }

    public Request setTopic(String topic) {
        this.topic = topic;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Request setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getState() {
        return state;
    }

    public Request setState(String state) {
        this.state = state;
        return this;
    }

    public Bundle toBundle(){
        Bundle bundle = new Bundle();

        bundle.putInt("id",id);
        bundle.putBundle("user", user.toBundle());
        bundle.putBundle("specialty", specialty.toBundle());
        bundle.putString("topic", topic);
        bundle.putString("description", description);
        bundle.putString("state", state);

        return bundle;
    }
}
