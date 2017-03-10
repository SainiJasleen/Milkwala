package jas.cse.milkwala.modle.networkconnection;

import jas.cse.milkwala.modle.properties.login.LoginResultPrp;
import jas.cse.milkwala.modle.properties.profile.ProfileResult;
import jas.cse.milkwala.modle.properties.register.RegisterBody;
import jas.cse.milkwala.modle.properties.register.RegisterResponse;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

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
    Call<RegisterResponse> requestRegister(@Field("email")String email, @Field("password") String password, @Field("userName")String userName, @Field("phone")String phone, @Field("deviceToken") String deviceToken);

    @GET("milkwala/ws/returnProfile.php?userId={userID}")
    Call<ProfileResult> requestProfile(@Query("userID")String userID);

/*
    @GET("milkwala/ws/updateProfile.php")

    @GET("milkwala/ws/returnProducts.php")*/


}
