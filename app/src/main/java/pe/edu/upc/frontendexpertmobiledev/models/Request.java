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

    public Request() {
    }
    
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

    public static Request from(Bundle bundle, User user, Specialty specialty) {
        Request request = new Request();

        request.setId(bundle.getInt("id"))
                .setUser(user)
                .setSpecialty(specialty)
                .setDescription(bundle.getString("description"))
                .setTopic(bundle.getString("topic"))
                .setState(bundle.getString("state"));

        return request;
    }

    public static Request from(JSONObject jsonRequest, User user, Specialty specialty){
        Request request = new Request();

        try {
            request.setId(jsonRequest.getInt("id"))
                    .setUser(user)
                    .setSpecialty(specialty)
                    .setTopic(jsonRequest.getString("topic"))
                    .setDescription(jsonRequest.getString("description"))
                    .setState(jsonRequest.getString("state"));

            return  request;
        } catch (JSONException e){
            e.printStackTrace();
        }
        return null;
    }

    public static List<Request> from(JSONArray jsonRequests, User user, Specialty specialty){
        List<Request> requests = new ArrayList<>();
        for (int i = 0; i < jsonRequests.length(); i++)
            try {
                requests.add(Request.from(jsonRequests.getJSONObject(i), user, specialty));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return requests;
    }

    public static Request from(JSONObject jsonSource){
        Request request = new Request();
        try {
            User user = User.from(jsonSource.getJSONObject("user"));
            Specialty specialty = Specialty.from(jsonSource.getJSONObject("specialty"));

            request.setId(jsonSource.getInt("id"))
                    .setUser(user)
                    .setSpecialty(specialty)
                    .setTopic(jsonSource.getString("topic"))
                    .setDescription(jsonSource.getString("description"))
                    .setState(jsonSource.getString("state"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return request;
    }
}

