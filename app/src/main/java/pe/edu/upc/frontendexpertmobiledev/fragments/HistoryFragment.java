package pe.edu.upc.frontendexpertmobiledev.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.frontendexpertmobiledev.R;
import pe.edu.upc.frontendexpertmobiledev.activities.LoginActivity;
import pe.edu.upc.frontendexpertmobiledev.activities.MainActivity;
import pe.edu.upc.frontendexpertmobiledev.adapters.HistoryAdapter;
import pe.edu.upc.frontendexpertmobiledev.models.Client;
import pe.edu.upc.frontendexpertmobiledev.models.Request;
import pe.edu.upc.frontendexpertmobiledev.models.Specialty;
import pe.edu.upc.frontendexpertmobiledev.models.User;
import pe.edu.upc.frontendexpertmobiledev.network.AssistantApiService;


/**
 * Created by paul.cabrera on 07/10/2017.
 */

public class HistoryFragment extends Fragment {
    private RecyclerView recyclerRequest;
    private HistoryAdapter historyAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Context context;
    ProgressDialog progressDialog;
    List<Request> lsRequest;

    private LinearLayout lnLogin;
    public RequestQueue requestQueue;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_history, container, false);

        progressDialog = new ProgressDialog(getContext());

        recyclerRequest = (RecyclerView) view.findViewById(R.id.recyclerRequest);

        lsRequest = new ArrayList<>();
        User user = new User(1, "account1", "123465", "c", "user1");
        Specialty specialt = new Specialty(1, "");
        lsRequest.add(new Request(1, user, specialt, "topic1", "desc1", "a"));
=======
>>>>>>> 550792be254a124d8970201925557835f088c802

        historyAdapter = new HistoryAdapter(lsRequest);
        layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerRequest.setItemAnimator(new DefaultItemAnimator());
        recyclerRequest.setAdapter(historyAdapter);
        recyclerRequest.setLayoutManager(layoutManager);

        return view;
    }

    private void callLoginService(final String mail, String password) {

        progressDialog.setMessage(getString(R.string.login_dialog_progress));
        progressDialog.setCancelable(false);
        progressDialog.show();

        JSONObject client = new JSONObject();
        try {
            client.put("usuario", mail);
            client.put("password", password);
            client.put("tipo", "e");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest postRequest = new JsonObjectRequest(com.android.volley.Request.Method.POST, AssistantApiService.LOGIN_CLIENT_URL,
                client,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            /*
                            Client mClient = new Client();
                            mClient.setName(response.getString("nombre"))
                                    .setMail(mail)
                                    .setTipo("c")
                                    .setId(response.getString("idusuario"));
                                    */

                            //Toast.makeText(context, "Bienvenido "+ mClient.getName(), Toast.LENGTH_LONG).show();
                            //saveDataUser(mClient);
                            progressDialog.dismiss();

                            JSONArray jsonArray = response.getJSONArray("requests");
                            lsRequest = new ArrayList<>();
                            for (int i = 0; i < jsonArray.length(); i++)
                                try {
                                    lsRequest.add(Request.from(jsonArray.getJSONObject(i)));
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            listHistory(lsRequest);
                            //startActivity(new Intent(context, MainActivity.class));

                        } catch (JSONException e) {
                            e.printStackTrace();
                            progressDialog.dismiss();
                            Snackbar snackbar = Snackbar
                                    .make(lnLogin, "Hubo un error al autenticarse", Snackbar.LENGTH_LONG);

                            snackbar.show();
                        }
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Log.d("Error.Response", "error");
                        progressDialog.dismiss();
                        Snackbar snackbar = Snackbar
                                .make(lnLogin, "Hubo un error al autenticarse", Snackbar.LENGTH_LONG);

                        snackbar.show();
                    }
                }
        );

        requestQueue.add(postRequest);
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
