package pe.edu.upc.frontendexpertmobiledev.models;

import android.os.Bundle;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by jlosorio on 10/7/17.
 */

public class Specialty {
    private Integer id;
    private String description;

    public Specialty() {
    }

    public Specialty(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public Specialty setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Specialty setDescription(String description) {
        this.description = description;
        return this;
    }

    public Bundle toBundle(){
        Bundle bundle = new Bundle();

        bundle.putInt("id",id);
        bundle.putString("description", description);

        return bundle;
    }

    public static Specialty from(JSONObject jsonSource){
        Specialty specialty = new Specialty();
        try {
            specialty.setId(jsonSource.getInt("id"))
                    .setDescription(jsonSource.getString("description"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return specialty;
    }
}
