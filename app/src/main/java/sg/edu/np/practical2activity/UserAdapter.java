package sg.edu.np.practical2activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>
{
    ArrayList<User> list_users;
    private RecyclerViewCLickListener listener;

    public UserAdapter(ArrayList<User>input, RecyclerViewCLickListener listener){
        this.list_users = input;
        this.listener = listener;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder
    implements View.OnClickListener {
        TextView name;
        TextView desc;
        ImageView profilepic;

        public UserViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textname);
            desc = itemView.findViewById(R.id.textdesc);
            profilepic = itemView.findViewById(R.id.pfp123);
            profilepic.setOnClickListener(this);

        }
        @Override
        public void onClick(View v) {
            listener.onClick(v, getAdapterPosition());
        }
    }

    public UserViewHolder onCreateViewHolder
            (ViewGroup parent, int viewType) {
        View item = LayoutInflater.from
                (parent.getContext()).inflate(R.layout.recycler_view_item,
                        parent, false);
        return new UserViewHolder(item);
    }

    public void onBindViewHolder(UserViewHolder holder, int position){
        User list_items = list_users.get(position);
        holder.name.setText(list_items.getName());
        holder.desc.setText(list_items.getDescription());
    }

    public int getItemCount() {
        return list_users.size();
    }

    public interface RecyclerViewCLickListener {
        void onClick(View v, int pos);
    }
}
