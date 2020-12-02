package edu.upc.dsa.retrofit4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserAdapterVH> {

    private List<UserResponse> userResponseList;
    private Context  context;
    private ClickedItem ClickedItem;



    public UsersAdapter(ClickedItem clickedItem) {
        this.ClickedItem = clickedItem;


    }
    public void setData (List<UserResponse> userResponseList){
        this.userResponseList = userResponseList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UsersAdapter.UserAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new UsersAdapter.UserAdapterVH(LayoutInflater.from(context).inflate(R.layout.row_users,parent,false));  /*el inflater es para añadir las views*/
    }

    @Override
    public void onBindViewHolder(@NonNull UsersAdapter.UserAdapterVH holder, int position) {

        UserResponse userResponse = userResponseList.get(position);
        String title = userResponse.getTitle();
        String singer = userResponse.getSinger();
        String prefix;



     holder.singer.setText(singer);
     holder.title.setText(title);
     holder.imagemore.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             ClickedItem.ClickedUser(userResponse);
         }
     });


    }
    public interface ClickedItem {
        public void ClickedUser(UserResponse userResponse);
    }

    @Override
    public int getItemCount() {
        return userResponseList.size();
    }

    public class UserAdapterVH extends RecyclerView.ViewHolder{
        TextView singer;
        TextView title;
        ImageView imagemore;



        public UserAdapterVH(@NonNull View itemView) {
            super(itemView);
            singer = itemView.findViewById(R.id.singer); /*damos valores a lo que son los text view*/
            title = itemView.findViewById(R.id.title);
            imagemore = itemView.findViewById(R.id.imageMore);


        }
    }
}
