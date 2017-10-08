package pe.edu.upc.frontendexpertmobiledev.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pe.edu.upc.frontendexpertmobiledev.R;
import pe.edu.upc.frontendexpertmobiledev.activities.DetailHistoryActivity;
import pe.edu.upc.frontendexpertmobiledev.models.Request;

/**
 * Created by paul.cabrera on 07/10/2017.
 */

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {
    private List<Request> requestList;

    public HistoryAdapter(List<Request> requestList) {
        this.requestList = requestList;
    }

    @Override
    public HistoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_history_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HistoryAdapter.ViewHolder holder, int position) {
        final Request request = requestList.get(position);

        holder.imgThumbnail.setImageResource(R.mipmap.ic_launcher);
        holder.txtDescription.setText(request.getDescription());

//        holder.txtTitle.setText(request.getSubject());

        //holder.txtTitle.setText(request.getSubject());


        /*
        holder.btnMore.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, DetailHistoryActivity.class);
                intent.putExtras(request.toBundle());
                context.startActivity(intent);
            }
        });
        */

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
        private Button btnMore;

        public ViewHolder(View itemView) {
            super(itemView);
            txtTitle = (TextView) itemView.findViewById(R.id.txtTitle);
            txtDescription = (TextView) itemView.findViewById(R.id.txtDescription);
            imgThumbnail = (ImageView) itemView.findViewById(R.id.imgThumbnail);
            btnMore = (Button) itemView.findViewById(R.id.btnAceptar);
        }
    }
}
