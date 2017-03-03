package jas.cse.milkwala.modle.networkconnection;

import jas.cse.milkwala.modle.properties.LoginResultPrp;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by User on 02-03-2017.
 */

public interface WebInterface {
    @FormUrlEncoded
    @POST("milkwala/ws/login.php")
    Call<LoginResultPrp> requestLogin(@Field("email")String email,@Field("password") String password);

    @FormUrlEncoded
    @POST("milkwala/ws/forgetPassword.php")
    Call<ResponseBody> requestForgetPassword(@Field("email")String email);

    @FormUrlEncoded
    @POST("milkwala/ws/register.php")
    Call<LoginResultPrp> requestRegister(@Field("email")String email, @Field("password") String password, @Field("userName")String userName,@Field("phone")String phone);


}
