package group_project.csumb.com.autitrak;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by britt on 11/25/2017.
 */

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ListItemViewHolder>{
    ArrayList<ListItem> itemList;

    public MyListAdapter(ArrayList<ListItem> itemList) {
        this.itemList = itemList;
    }

    @Override
    public ListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, null, false);
        return new ListItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListItemViewHolder holder, int position) {
        holder.textName.setText(itemList.get(position).getName());
        holder.textInfo.setText(itemList.get(position).getInfo());
        holder.photo.setImageResource(itemList.get(position).getImageID());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ListItemViewHolder extends RecyclerView.ViewHolder {
        TextView textName,textInfo;
        ImageView photo;

        public ListItemViewHolder(View itemView) {
            super(itemView);
            textName = (TextView)itemView.findViewById(R.id.idName);
            textInfo = (TextView)itemView.findViewById(R.id.idInfo);
            photo = (ImageView)itemView.findViewById(R.id.idImage);
        }
    }
}
