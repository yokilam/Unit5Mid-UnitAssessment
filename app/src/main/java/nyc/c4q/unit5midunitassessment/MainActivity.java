package nyc.c4q.unit5midunitassessment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;

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
    private RecyclerView rv;
    private static final String TAG = MainActivity.class.getSimpleName();
    private UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SetUpRetrofit();
        rv= findViewById(R.id.rv);
        rv.setLayoutManager(new GridLayoutManager(this, 3));
    }

    public void SetUpRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://randomuser.me/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UserServices userServices = retrofit.create(UserServices.class);

        Call<ArrayObject> call= userServices.getUserList();
        call.enqueue(new Callback<ArrayObject>() {
            @Override
            public void onResponse(Call <ArrayObject> call, Response<ArrayObject> response) {
                ArrayObject object= response.body();
                userList=object.getResults();
                rv.setAdapter(new UserAdapter(userList));
                Log.d(TAG, "onResponse: " + object.getResults().get(0).getName().getFirst());
            }

            @Override
            public void onFailure(Call <ArrayObject> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString() );
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.action_load:
                SetUpRetrofit();
                break;
        }
        return true;
    }
}
