package jas.cse.milkwala.views.activity.login;

import android.app.Activity;

import jas.cse.milkwala.R;
import jas.cse.milkwala.modle.networkconnection.BaseUrl;
import jas.cse.milkwala.modle.networkconnection.WebInterface;
import jas.cse.milkwala.modle.properties.LoginResultPrp;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by User on 02-03-2017.
 */

public class LoginPresenter implements ILoginPresenter, BaseUrl {

    LoginView loginView;
    Activity activity;

    LoginPresenter(LoginView loginView,Activity activity)
    {
        this.loginView=loginView;
        this.activity=activity;
    }

    @Override
    public void requestLogin(String email, String password) {
        if(checkFieldEmpty(email,password))
        {
            if(isEmailValid(email))
            {
                makeLoginRequest(email,password);
            }
        }


    }


/*   @Override
    public void requestForgotPassword(String email) {

    }*//*

*/
    @Override
    public void requestForgotPassword(String email) {
        if(checkFieldEmpty(email,"PASSWORD"))
        {
            if(isEmailValid(email))
            {
              //  makeForgetPasswordRequest(email);
            }
        }
    }



    private boolean checkFieldEmpty(String email,String password)
    {
        if(email.trim().length()==0)
        {
            loginView.showFeedbackMessage(activity.getString(R.string.emailempty));
            return false;
        }
        else if(password.trim().length()==0)
        {
            loginView.showFeedbackMessage(activity.getString(R.string.passwordEmpty));

            return  false;
        }
        else
        {
            return  true;
        }
    }


    private boolean isEmailValid(String email)
    {
        String emailPattern="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if(email.matches(emailPattern))
        {
            loginView.showFeedbackMessage("Validate email address");
            return true;
        }
        else
        {
            loginView.showFeedbackMessage("Not a valid email address");
            return false;
        }

    }


    private void makeLoginRequest(String email,String password)
    {
        loginView.startProgress();
        Retrofit retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        final Call<LoginResultPrp> result=retrofit.create(WebInterface.class).requestLogin(email,password);
        result.enqueue(new Callback<LoginResultPrp>() {
            @Override
            public void onResponse(Call<LoginResultPrp> call, Response<LoginResultPrp> response) {
                loginView.stopProgress();
                loginView.onLoginComplete(response.body());
            }

            @Override
            public void onFailure(Call<LoginResultPrp> call, Throwable t) {
                loginView.stopProgress();
                loginView.showFeedbackMessage(activity.getString(R.string.wrongusernamepassword));
            }
        });
    }

/*
    private void makeForgetPasswordRequest(String email)
    {
        loginView.startProgress();
        Retrofit retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        final Call<ResponseBody> result=retrofit.create(WebInterface.class).requestForgetPassword(email);
        result.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                loginView.stopProgress();
               // loginView.onForgetPasswordComplete();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                loginView.stopProgress();
                loginView.showFeedbackMessage(activity.getString(R.string.pleaseentervalidemail));
            }
        });
    }*/
}
