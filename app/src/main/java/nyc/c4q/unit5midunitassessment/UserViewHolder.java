package nyc.c4q.unit5midunitassessment;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.Serializable;

/**
 * Created by yokilam on 1/24/18.
 */

public class UserViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageView;
    private TextView textView;

    public UserViewHolder(View itemView) {
        super(itemView);
        imageView= itemView.findViewById(R.id.image);
        textView= itemView.findViewById(R.id.first_name);

    }

    public void bind(final User user) {
        String url= user.getPicture().getLarge();
        Picasso.with(itemView.getContext())
                .load(url)
                .into(imageView);

        final StringBuilder name= new StringBuilder();
        name.append(user.getName().getFirst()).append(" ").append(user.getName().getLast()).toString();
        final StringBuilder secondaddress= new StringBuilder();
        secondaddress.append(user.getLocation().getCity()).append(" ").append(user.getLocation().getState())
                .append(", ").append(user.getLocation().getPostcode()).toString();
        textView.setText(name);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(itemView.getContext(), DetailActivity.class);
                intent.putExtra("first", textView.getText().toString());
                intent.putExtra("picture", user.getPicture().getLarge());
                intent.putExtra("number", user.getCell());
                intent.putExtra("email", user.getEmail());
                intent.putExtra("first_address", user.getLocation().getStreet());
                intent.putExtra("second_address", (Serializable) secondaddress);
                itemView.getContext().startActivity(intent);
            }
        });
    }
}
