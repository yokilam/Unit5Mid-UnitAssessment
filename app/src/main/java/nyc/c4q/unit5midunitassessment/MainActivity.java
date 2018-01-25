package nyc.c4q.unit5midunitassessment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    List <User> userList = new ArrayList <>();
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://randomuser.me/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UserServices userServices = retrofit.create(UserServices.class);

        Call<ArrayObject> call= userServices.getUserList();
        call.enqueue(new Callback <ArrayObject>() {
            @Override
            public void onResponse(Call <ArrayObject> call, Response<ArrayObject> response) {
                ArrayObject object= response.body();
                userList=object.getResults();

                Log.d(TAG, "onResponse: " + object.getResults().get(0).getName().getFirst());

            }

            @Override
            public void onFailure(Call <ArrayObject> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString() );
            }
        });

    }
}
