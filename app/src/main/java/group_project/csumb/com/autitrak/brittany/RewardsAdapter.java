package group_project.csumb.com.autitrak.brittany;

/**
 * Created by britt on 12/3/2017.
 */

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

public class RewardsAdapter extends RecyclerView.Adapter<RewardsAdapter.ListItemViewHolder>{
    ArrayList<ListItem> rewardsList;

    public RewardsAdapter(ArrayList<ListItem> itemList) {
        this.rewardsList = itemList;
    }

    @Override
    public ListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reward_item, null, true);
        return new ListItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListItemViewHolder holder, int position) {
        holder.txtDescription.setText(rewardsList.get(position).getDescription());
        holder.txtEndDate.setText(rewardsList.get(position).getEndDate());
    }

    @Override
    public int getItemCount() {
        return rewardsList.size();
    }

    public class ListItemViewHolder extends RecyclerView.ViewHolder {
        TextView txtDescription, txtEndDate;

        public ListItemViewHolder(View itemView) {
            super(itemView);
            txtDescription = (TextView)itemView.findViewById(R.id.idDescription);
            txtEndDate = (TextView)itemView.findViewById(R.id.idEndDate);
        }
    }
}
