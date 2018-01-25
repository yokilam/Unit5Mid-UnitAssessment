package nyc.c4q.unit5midunitassessment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private TextView name, phone, email,addressOne, addressTwo;
    private ImageView image;
    private String personName, personPhone, personEmail, url, firstAddress, secondAddress;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        name= findViewById(R.id.detail_name);
        phone= findViewById(R.id.phone);
        email= findViewById(R.id.email);
        image= findViewById(R.id.detail_image);
        addressOne= findViewById(R.id.address1);
        addressTwo= findViewById(R.id.address2);
        button= findViewById(R.id.back);

        Intent intent= getIntent();
        personName=intent.getStringExtra("first");
        personEmail=intent.getStringExtra("email");
        personPhone=intent.getStringExtra("number");
        url= intent.getStringExtra("picture");
        firstAddress= intent.getStringExtra("first_address");
        secondAddress= intent.getStringExtra("second_address");

        name.setText(personName);
        phone.setText(personPhone);
        email.setText(personEmail);
        addressOne.setText(firstAddress);
        addressTwo.setText(secondAddress);
        Picasso.with(this).load(url).fit().into(image);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1= new Intent(DetailActivity.this, MainActivity.class);
                startActivity(intent1);
            }
        });

    }
}
