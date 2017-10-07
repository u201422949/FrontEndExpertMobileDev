package pe.edu.upc.frontendexpertmobiledev.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pe.edu.upc.frontendexpertmobiledev.R;
import pe.edu.upc.frontendexpertmobiledev.models.Request;


/**
 * Created by jlosorio on 10/7/17.
 */

public class PendingJobsAdapter extends RecyclerView.Adapter<PendingJobsAdapter.ViewHolder>{
    private List<Request> requests;

    public PendingJobsAdapter(List<Request> requests) {
        this.requests = requests;
    }

    public PendingJobsAdapter() {
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.card_pending_jobs,parent,false));
    }

    @Override
    public void onBindViewHolder(PendingJobsAdapter.ViewHolder holder, int position) {
        final Request request =  requests.get(position);

        holder.asuntoTextView.setText(request.getTopic());
        holder.tipoServicioTextView.setText(request.getSpecialty().getDescription());

    }

    @Override
    public int getItemCount() {
        return requests.size();
    }

    public List<Request> getRequests(){
        return requests;
    }

    public PendingJobsAdapter setRequests(List<Request> requests){
        this.requests = requests;
        return this;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView asuntoTextView;
        TextView tipoServicioTextView;
        TextView detalleTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            asuntoTextView = (TextView) itemView.findViewById(R.id.asuntoTextView);
            tipoServicioTextView = (TextView) itemView.findViewById(R.id.tipoServicioTextView);
            detalleTextView = (TextView) itemView.findViewById(R.id.detalleTextView);
        }
    }
}
