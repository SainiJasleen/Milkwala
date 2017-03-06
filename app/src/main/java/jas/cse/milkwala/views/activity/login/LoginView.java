package jas.cse.milkwala.views.activity.login;

import jas.cse.milkwala.modle.properties.login.LoginResultPrp;

/**
 * Created by User on 02-03-2017.
 */

public interface LoginView {
    void onLoginComplete(LoginResultPrp loginResult);

    void startProgress();
    void stopProgress();

    void showFeedbackMessage(String message);

 //   void onForgetPasswordComplete();

}
