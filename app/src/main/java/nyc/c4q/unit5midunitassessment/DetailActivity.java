package nyc.c4q.unit5midunitassessment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private TextView name, phone, email;
    private ImageView image;
    private String personName, personPhone, personEmail, url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        name= findViewById(R.id.detail_name);
        phone= findViewById(R.id.phone);
        email= findViewById(R.id.email);
        image= findViewById(R.id.detail_image);

        Intent intent= getIntent();
        personName=intent.getStringExtra("first");
        personEmail=intent.getStringExtra("email");
        personPhone=intent.getStringExtra("phone");
        url= intent.getStringExtra("picture");

        name.setText(personName);
        phone.setText(personPhone);
        email.setText(personEmail);
        Picasso.with(this).load(url).fit().into(image);

    }
}
