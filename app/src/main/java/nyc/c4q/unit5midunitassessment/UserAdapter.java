package nyc.c4q.unit5midunitassessment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yokilam on 1/24/18.
 */

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {
    List<User> userList= new ArrayList <>();

    public UserAdapter(List <User> userList) {
        this.userList = userList;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View child = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new UserViewHolder(child);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.bind(userList.get(position));
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public void swap(List<User> list) {
        userList.clear();
        userList = list;
        notifyDataSetChanged();
    }
}
