package pe.edu.upc.frontendexpertmobiledev.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.frontendexpertmobiledev.R;
import pe.edu.upc.frontendexpertmobiledev.adapters.PendingJobsAdapter;
import pe.edu.upc.frontendexpertmobiledev.models.Request;

public class PendingJobsFragment extends Fragment {
    RecyclerView pendingJobsRecyclerView;
    RecyclerView.LayoutManager pendingJobsLayoutManager;
    PendingJobsAdapter pendingJobsAdapter;
    List<Request> requests;

    public PendingJobsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pending_jobs,container,false);
        pendingJobsRecyclerView = (RecyclerView) view.findViewById(R.id.pendingJobsRecyclerView);
        requests = new ArrayList<>();
        pendingJobsAdapter = new PendingJobsAdapter(requests);
        pendingJobsLayoutManager = new GridLayoutManager(view.getContext(),2);
        pendingJobsRecyclerView.setAdapter(pendingJobsAdapter);
        pendingJobsRecyclerView.setLayoutManager(pendingJobsLayoutManager);
        updatePendingJobs();

        return view;
    }

    private void updatePendingJobs(){
        //TODO: integracion con REST
    }
}
