package pe.edu.upc.frontendexpertmobiledev.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.frontendexpertmobiledev.R;
import pe.edu.upc.frontendexpertmobiledev.adapters.HistoryAdapter;
import pe.edu.upc.frontendexpertmobiledev.models.Request;


/**
 * Created by paul.cabrera on 07/10/2017.
 */

public class HistoryFragment extends Fragment {
    private RecyclerView recyclerRequest;
    private HistoryAdapter historyAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_history, container, false);

        recyclerRequest = (RecyclerView) view.findViewById(R.id.recyclerRequest);

        //TODO: Set original list of requests

        List<Request> lsRequest = new ArrayList<>();
<<<<<<< HEAD
        Skill skill = new Skill(2, "Skill 2");
//        lsRequest.add(new Request(client, skill,  "Description 1", "Subject 1"));
=======
>>>>>>> 550792be254a124d8970201925557835f088c802

        historyAdapter = new HistoryAdapter(lsRequest);
        layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerRequest.setItemAnimator(new DefaultItemAnimator());
        recyclerRequest.setAdapter(historyAdapter);
        recyclerRequest.setLayoutManager(layoutManager);

        return view;
    }

    private void listHistory(List<Request> lsRequest) {
        historyAdapter = new HistoryAdapter(lsRequest);
        layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerRequest.setItemAnimator(new DefaultItemAnimator());
        recyclerRequest.setAdapter(historyAdapter);
        recyclerRequest.setLayoutManager(layoutManager);
    }

<<<<<<< HEAD
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
=======

>>>>>>> 550792be254a124d8970201925557835f088c802


}
