package jas.cse.milkwala.views.activity.register;

import android.app.Activity;

import jas.cse.milkwala.R;
import jas.cse.milkwala.modle.networkconnection.BaseUrl;
import jas.cse.milkwala.modle.networkconnection.WebInterface;
import jas.cse.milkwala.modle.properties.LoginResultPrp;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by User on 03-03-2017.
 */

public class RegisterPresenter implements IRegisterPresenter,BaseUrl {

    RegisterView view;
    Activity activity;
    RegisterPresenter(RegisterView view,Activity activity)
    {
        this.activity=activity;
        this.view=view;
    }

    @Override
    public void requestRegister(String email, String password, String userName, String phone) {

        if(checkFieldEmpty(email,password,userName,phone))
        {
            if(isEmailValid(email))
            {
                makeLoginRequest(email,password,userName,phone);
            }
        }


    }
    private boolean checkFieldEmpty(String email,String password,String userName,String phone)
    {
        if(email.trim().length()==0)
        {
            view.showFeedbackMessage(activity.getString(R.string.emailempty));
            return false;
        }
        else if(password.trim().length()==0)
        {
            view.showFeedbackMessage(activity.getString(R.string.passwordEmpty));

            return  false;
        }
        else if(userName.trim().length()==0)
        {
            view.showFeedbackMessage(activity.getString(R.string.usernameempty));

            return  false;
        }

        else if(phone.trim().length()==0)
        {
            view.showFeedbackMessage(activity.getString(R.string.phoneempty));

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
            view.showFeedbackMessage("Validate email address");
            return true;
        }
        else
        {
            view.showFeedbackMessage("Not a valid email address");
            return false;
        }

    }


    private void makeLoginRequest(String email,String password,String userName,String phone)
    {
        view.startProgress();
        Retrofit retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        final Call<LoginResultPrp> result=retrofit.create(WebInterface.class).requestRegister(userName,email,password,phone);
        result.enqueue(new Callback<LoginResultPrp>() {
            @Override
            public void onResponse(Call<LoginResultPrp> call, Response<LoginResultPrp> response) {
                view.stopProgress();
                view.onRegisterComplete(response.body());
            }

            @Override
            public void onFailure(Call<LoginResultPrp> call, Throwable t) {
                view.stopProgress();
                view.showFeedbackMessage(activity.getString(R.string.alreadyregistered));
            }
        });
    }

}
