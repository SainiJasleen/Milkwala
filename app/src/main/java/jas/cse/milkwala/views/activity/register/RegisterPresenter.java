package jas.cse.milkwala.views.activity.register;

import android.app.Activity;

/**
 * Created by User on 03-03-2017.
 */

public class RegisterPresenter implements IRegisterPresenter {

    RegisterView view;
    Activity activity;
    RegisterPresenter(RegisterView view,Activity activity)
    {
        this.activity=activity;
        this.view=view;
    }
    @Override
    public void requestRegister(String email, String password, String userName, String deviceToken, int phone) {

    }
}
