package pe.edu.upc.frontendexpertmobiledev.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pe.edu.upc.frontendexpertmobiledev.R;
import pe.edu.upc.frontendexpertmobiledev.models.Request;

/**
 * Created by paul.cabrera on 07/10/2017.
 */

public class RequestAdapter extends RecyclerView.Adapter<RequestAdapter.ViewHolder>{
    private List<Request> requestList;

    public RequestAdapter(List<Request> requestList) {
        this.requestList = requestList;
    }

    @Override
    public RequestAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_history_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RequestAdapter.ViewHolder holder, int position) {
        holder.imgThumbnail.setImageResource(R.mipmap.ic_launcher);
        holder.txtDescription.setText(requestList.get(position).getDescription());

//        holder.txtTitle.setText(requestList.get(position).getSubject());

        //holder.txtTitle.setText(requestList.get(position).getSubject());

    }

    @Override
    public int getItemCount() {
        return requestList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgThumbnail;
        private TextView txtTitle, txtDescription;

        public ViewHolder(View itemView) {
            super(itemView);
            txtTitle = (TextView) itemView.findViewById(R.id.txtTitle);
            txtDescription = (TextView) itemView.findViewById(R.id.txtDescription);
            imgThumbnail = (ImageView) itemView.findViewById(R.id.imgThumbnail);
        }
    }
}
