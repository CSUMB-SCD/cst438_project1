package group_project.csumb.com.autitrak.brittany;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;

import java.util.List;

import group_project.csumb.com.autitrak.R;

/**
 * Created by britt on 11/25/2017.
 */



public class ToDoListAdapter extends RecyclerView.Adapter<ToDoListAdapter.ListItemViewHolder>{
    public static final int RADIUS = 8;
    private List<ListItem> itemList;
    private Context ctx;

//    public ToDoListAdapter(Context ctx, List<ListItem> itemList) {
//        this.ctx = ctx;
//        this.itemList = itemList;
//    }

    public ToDoListAdapter(List<ListItem> itemList) {
        this.itemList = itemList;
    }

    @Override
    public ListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        LayoutInflater inflater = LayoutInflater.from(ctx);
//        View view = inflater.inflate(R.layout.individual_list_item, null);
//        return new ListItemViewHolder(view);

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

        ColorGenerator colgen = ColorGenerator.MATERIAL;
        Drawable ptsDrawable = TextDrawable.builder().buildRound(holder.txtPoints.getText().toString(), colgen.getRandomColor());

        holder.ptsIcon.setImageDrawable(ptsDrawable);

        holder.taskImage.setImageResource(itemList.get(position).getImg());

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ListItemViewHolder extends RecyclerView.ViewHolder {
        TextView txtDescription, txtPoints, txtLevel, txtStartDate, txtEndDate;
        ImageView ptsIcon;
        ImageView taskImage;

        public ListItemViewHolder(View itemView) {
            super(itemView);
            txtDescription = (TextView)itemView.findViewById(R.id.idDescription);
            txtLevel = (TextView)itemView.findViewById(R.id.idLevel);
            txtStartDate = (TextView)itemView.findViewById(R.id.idStartDate);
            txtEndDate = (TextView)itemView.findViewById(R.id.idEndDate);
            txtPoints = (TextView)itemView.findViewById(R.id.idPoints);

            ColorGenerator colgen = ColorGenerator.MATERIAL;
            ptsIcon = (ImageView) itemView.findViewById(R.id.task_pt_icon);
            Drawable ptsDrawable = TextDrawable.builder().buildRound(txtPoints.getText().toString(), colgen.getRandomColor());
            ptsIcon.setImageDrawable(ptsDrawable);

            taskImage = (ImageView) itemView.findViewById(R.id.idImage);

        }
    }

}
