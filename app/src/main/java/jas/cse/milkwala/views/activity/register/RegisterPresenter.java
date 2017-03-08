package jas.cse.milkwala.views.activity.register;

import android.app.Activity;

import jas.cse.milkwala.R;
import jas.cse.milkwala.modle.networkconnection.BaseUrl;
import jas.cse.milkwala.modle.networkconnection.WebInterface;
import jas.cse.milkwala.modle.properties.register.RegisterBody;
import jas.cse.milkwala.modle.properties.register.RegisterResponse;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by User on 06-03-2017.
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
    public void requestRegister(RegisterBody registerBody) {
        if (!isFieldEmpty(registerBody.getUserName()))
        {
            view.showFeedbackMessage(activity.getString(R.string.usernameempty));
        }
        else if(!isFieldEmpty(registerBody.getEmail()))
        {
            view.showFeedbackMessage(activity.getString(R.string.emailempty));

        }
       else if (!isFieldEmpty(registerBody.getPassword()))
        {
            view.showFeedbackMessage(activity.getString(R.string.passwordEmpty));
        }
        else if (!isFieldEmpty(registerBody.getMobileNumber()))
        {
            view.showFeedbackMessage(activity.getString(R.string.phoneempty));
        }
        else
        {
            if(isEmailValid(registerBody.getEmail()))
            makeRegisterRequest(registerBody);

        }

    }
    private boolean isFieldEmpty(String value)
    {
        if(value.trim().length()==0)
        {
            return false;
        }

        return  true;
       
    }

    private void makeRegisterRequest(RegisterBody registerBody) {
        view.startProgress();

        Retrofit retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        final Call<RegisterResponse> result=retrofit.create(WebInterface.class).requestRegister(registerBody.getEmail(),registerBody.getPassword(),registerBody.getUserName(),registerBody.getMobileNumber(),registerBody.getDeviceToken());
        result.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                view.stopProgress();
                if (response.body().getResult().getStatus()>0)
                {
                    view.onRegistrationComplete(response.body());
                }
                else if (response.body().getResult().getStatus()==-2)
                {
                    view.showFeedbackMessage(activity.getString(R.string.alreadyregistered));
                }


            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                view.stopProgress();
                view.showFeedbackMessage(activity.getString(R.string.wrongusernamepassword));

            }
        });
    }

    private boolean isEmailValid(String email)
    {
        String emailPattern="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if(email.matches(emailPattern))
        {
            return true;
        }
        else
        {
            view.showFeedbackMessage("Not a valid email address");
            return false;
        }

    }


}
