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




}
