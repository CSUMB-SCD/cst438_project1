package group_project.csumb.com.autitrak.brittany;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import group_project.csumb.com.autitrak.R;

/**
 * Created by britt on 11/25/2017.
 */

public class ToDoListAdapter extends RecyclerView.Adapter<ToDoListAdapter.ListItemViewHolder>{
    ArrayList<ListItem> itemList;

    public ToDoListAdapter(ArrayList<ListItem> itemList) {
        this.itemList = itemList;
    }

    @Override
    public ListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.individual_list_item, null, true);
        return new ListItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListItemViewHolder holder, int position) {
        holder.txtDescription.setText(itemList.get(position).getDescription());
        holder.txtLevel.setText(itemList.get(position).getLevel());
        holder.txtStartDate.setText(itemList.get(position).getStartDate());
        holder.txtEndDate.setText(itemList.get(position).getEndDate());
        holder.txtPoints.setText(String.valueOf(itemList.get(position).getPoints()));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ListItemViewHolder extends RecyclerView.ViewHolder {
        TextView txtDescription, txtPoints, txtLevel, txtStartDate, txtEndDate;

        public ListItemViewHolder(View itemView) {
            super(itemView);
            txtDescription = (TextView)itemView.findViewById(R.id.idDescription);
            txtLevel = (TextView)itemView.findViewById(R.id.idLevel);
            txtStartDate = (TextView)itemView.findViewById(R.id.idStartDate);
            txtEndDate = (TextView)itemView.findViewById(R.id.idEndDate);
            txtPoints = (TextView)itemView.findViewById(R.id.idPoints);
        }
    }
}
