package nyc.c4q.unit5midunitassessment;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by yokilam on 1/24/18.
 */

public interface UserServices {

    @GET("api/?nat=us&inc=name,location,cell,email,dob,picture&results=20")
    Call<ArrayObject> getUserList();

}
