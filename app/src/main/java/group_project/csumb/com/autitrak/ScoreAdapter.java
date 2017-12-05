package group_project.csumb.com.autitrak;

/**
 * Created by britt on 12/3/2017.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ScoreAdapter extends RecyclerView.Adapter<ScoreAdapter.ListItemViewHolder>{
    ArrayList<ListItem> scoreList;

    public ScoreAdapter(ArrayList<ListItem> itemList) {
        this.scoreList = itemList;
    }

    @Override
    public ListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.high_score_item, null, true);
        return new ListItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListItemViewHolder holder, int position) {
        holder.txtDescription.setText(scoreList.get(position).getDescription());
        holder.txtEndDate.setText(scoreList.get(position).getEndDate());
        holder.txtPoints.setText(String.valueOf(scoreList.get(position).getPoints()));
    }

    @Override
    public int getItemCount() {
        return scoreList.size();
    }

    public class ListItemViewHolder extends RecyclerView.ViewHolder {
        TextView txtDescription, txtPoints, txtEndDate;

        public ListItemViewHolder(View itemView) {
            super(itemView);
            txtDescription = (TextView)itemView.findViewById(R.id.idDescription);
            txtEndDate = (TextView)itemView.findViewById(R.id.idEndDate);
            txtPoints = (TextView)itemView.findViewById(R.id.idPoints);
        }
    }
}
