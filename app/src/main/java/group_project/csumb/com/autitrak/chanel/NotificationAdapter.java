package group_project.csumb.com.autitrak.chanel;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;

import org.w3c.dom.Text;

import java.util.List;

import group_project.csumb.com.autitrak.R;

/**
 * Created by chanel on 12/5/17.
 */

/**
 * Manage and display data of RecyclerView
 * RecyclerView.ViewHolder: views of RecyclerView
 * RecyclerView.Adapter: data to be shown with the ViewHolder
 */
public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder> {


    private Context mCtx;       // context used to inflate the layout
    private List<Notification> notificationList;    // store all notifications in a list

    public NotificationAdapter(Context mCtx, List<Notification> notificationList) {
        this.mCtx = mCtx;
        this.notificationList = notificationList;
    }

    /**
     *
     * @param parent
     * @param viewType
     * @return
     *      new instance of ViewHolder
     */
    @Override
    public NotificationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflating and returning our view holder
        LayoutInflater inflater  = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.caregiver_notif_list, null);
        return new NotificationViewHolder(view);
    }

    /**
     * Binds data to the ViewHolder
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(NotificationViewHolder holder, int position) {

        Log.d("NotificationAdapter", "setting views");
        // get product at specified position
        Notification notif = notificationList.get(position);

        // binding data with ViewHolder views
        holder.subject.setText(notif.getSubject());
        Log.d("NotificationAdapter", "set subject");
        holder.date.setText(notif.getDate());
        Log.d("NotificationAdapter", "set date");
        holder.message.setText(notif.getMessage());
        Log.d("NotificationAdapter", "set message");
        holder.sender.setText(notif.getSender());
        Log.d("NotificationAdapter", "set sender");

        //holder.senderIcon.setImageDrawable(mCtx.getDrawable(notif.getSenderIcon()));
    }

    /**
     *
     * @return
     *      size of notificationsList
     */
    @Override
    public int getItemCount() {
        return notificationList.size();
    }

    class NotificationViewHolder extends RecyclerView.ViewHolder {

        ImageView senderIcon;
        TextView subject;
        TextView date;
        TextView message;
        TextView sender;

        public NotificationViewHolder(View itemView) {
            super(itemView);

            subject = (TextView) itemView.findViewById(R.id.notif_subject);
            date = (TextView) itemView.findViewById(R.id.notif_date);
            message = (TextView) itemView.findViewById(R.id.notif_msg_preview);


            // sender stuff
            sender = (TextView) itemView.findViewById(R.id.notif_sender);

            //String senderFirstLetter = Character.toString(sender.getText().toString().charAt(0)).toUpperCase();

            ColorGenerator colgen = ColorGenerator.MATERIAL;
            senderIcon = (ImageView)itemView.findViewById(R.id.notif_sender_icon);
            Drawable senderDrawable = TextDrawable.builder().buildRound("A", colgen.getRandomColor());

            senderIcon.setImageDrawable(senderDrawable);

        }
    }
}
