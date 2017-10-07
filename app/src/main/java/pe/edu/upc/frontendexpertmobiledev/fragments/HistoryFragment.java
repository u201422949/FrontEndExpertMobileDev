package pe.edu.upc.frontendexpertmobiledev.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.frontendexpertmobiledev.R;
import pe.edu.upc.frontendexpertmobiledev.activities.MainActivity;
import pe.edu.upc.frontendexpertmobiledev.adapters.HistoryAdapter;
import pe.edu.upc.frontendexpertmobiledev.models.Client;
import pe.edu.upc.frontendexpertmobiledev.models.Expert;
import pe.edu.upc.frontendexpertmobiledev.models.Request;
import pe.edu.upc.frontendexpertmobiledev.models.Skill;
import pe.edu.upc.frontendexpertmobiledev.network.AssistantApiService;

/**
 * Created by paul.cabrera on 07/10/2017.
 */

public class HistoryFragment extends Fragment {
    private RecyclerView recyclerRequest;
    private HistoryAdapter historyAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Request> lsRequest;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_history, container, false);

        recyclerRequest = (RecyclerView) view.findViewById(R.id.recyclerRequest);

        //TODO: Set original list of requests

        Client client = new Client("1","Name 1","Address 1","Email 1","Phone 1",0,0,"123456","");
        List<Expert> lsExpert = new ArrayList<>();
        List<Skill> skills = new ArrayList<>();
        skills.add(new Skill(1,"Skill 1"));
        lsExpert.add(new Expert("Name 1","Mail 1"));
        List<Request> lsRequest = new ArrayList<>();
        Skill skill = new Skill(2, "Skill 2");
//        lsRequest.add(new Request(client, skill,  "Description 1", "Subject 1"));

        historyAdapter = new HistoryAdapter(lsRequest);
        layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerRequest.setItemAnimator(new DefaultItemAnimator());
        recyclerRequest.setAdapter(historyAdapter);
        recyclerRequest.setLayoutManager(layoutManager);

        //callExpertHistoryService("");

        return view;
    }

    private void listHistory(List<Request> lsRequest) {
        historyAdapter = new HistoryAdapter(lsRequest);
        layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerRequest.setItemAnimator(new DefaultItemAnimator());
        recyclerRequest.setAdapter(historyAdapter);
        recyclerRequest.setLayoutManager(layoutManager);
    }

    private void callExpertHistoryService(String code){

        //TODO: Validar la funcionalidad del servicio
        AndroidNetworking.post(AssistantApiService.EXPERT_HISTORY_URL)
                .addBodyParameter("code", code)
                //.addBodyParameter("password", password)
                //.addBodyParameter("type", "1")
                .setPriority(Priority.MEDIUM)
                .setTag(getString(R.string.app_name))
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            if("error".equalsIgnoreCase(response.getString("status"))){
                                Log.e(getString(R.string.app_name), response.getString("message"));
                                return;
                            }
                            Boolean status = response.getBoolean("status");

                            if(status == true){

                                Toast toast = Toast.makeText(getContext(), "Ok", Toast.LENGTH_LONG);
                                toast.show();

                                //Client client = Client.from(response.getJSONArray("object").getJSONObject(0));
                                //saveDataUser(client);

                                //startActivity(new Intent(context, MainActivity.class));
                                //finish();

//                                lsRequest =  Request.from(response.getJSONArray("requests"));
//                                listHistory(lsRequest);

                            }else{
                                Toast toast = Toast.makeText(getContext(), "Incorrecto", Toast.LENGTH_LONG);
                                toast.show();

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.e(getString(R.string.app_name), anError.getLocalizedMessage());
                    }
                });
    }


}
