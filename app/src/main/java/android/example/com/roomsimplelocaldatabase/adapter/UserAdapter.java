package android.example.com.roomsimplelocaldatabase.adapter;

import android.content.Context;
import android.example.com.roomsimplelocaldatabase.R;
import android.example.com.roomsimplelocaldatabase.databinding.RecyclerItemBinding;
import android.example.com.roomsimplelocaldatabase.model.User;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.VH> {

    private List<User> userList;
    private LayoutInflater mInflater;

    public UserAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerItemBinding itemBinding = DataBindingUtil.inflate(
                mInflater, R.layout.recycler_item,parent, false);
        return new VH(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        if (userList != null){
            User user = userList.get(position);
            holder.binding.nameTextView.setText(user.getFirst_name() + " " + user.getLase_name());
            holder.binding.phoneNumberTextView.setText(user.getPhone_number());
        }

    }

    @Override
    public int getItemCount() {
        return userList != null? userList.size():0;
    }

    public void setUser(List<User> users) {
        userList = users;
    }

    public class VH extends RecyclerView.ViewHolder {
        private RecyclerItemBinding binding;

        public VH(@NonNull RecyclerItemBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
