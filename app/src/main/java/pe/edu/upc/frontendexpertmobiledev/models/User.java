package pe.edu.upc.frontendexpertmobiledev.models;

import android.os.Bundle;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by jlosorio on 10/7/17.
 */

public class User {
    private Integer id;
    private String account;
    private String password;
    private String type;
    private String name;

    public User(Integer id, String account, String password, String type, String name) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.type = type;
        this.name = name;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getAccount() {
        return account;
    }

    public User setAccount(String account) {
        this.account = account;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getType() {
        return type;
    }

    public User setType(String type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public Bundle toBundle(){
        Bundle bundle = new Bundle();

        bundle.putInt("id",id);
        bundle.putString("account", account);
        bundle.putString("password", password);
        bundle.putString("type",type);
        bundle.putString("name",name);

        return bundle;
    }

    public static User from(JSONObject jsonSource){
        User user = new User();
        try {
            user.setId(jsonSource.getInt("id"))
                    .setAccount(jsonSource.getString("account"))
                    .setPassword(jsonSource.getString("password"))
                    .setType(jsonSource.getString("type"))
                    .setName(jsonSource.getString("name"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return user;
    }
}
