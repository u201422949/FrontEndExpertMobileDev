package pe.edu.upc.frontendexpertmobiledev.network;

import pe.edu.upc.frontendexpertmobiledev.models.Client;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by paul.cabrera on 07/10/2017.
 */

public interface APIService {

    @POST("login")
    Call<Client> savePost(@Header("Content-Type") String content_type,
                          @Field("usuario") String user,
                          @Field("password") String password,
                          @Field("tipo") String type);
}