package jas.cse.milkwala.views.activity.register;

import jas.cse.milkwala.modle.properties.LoginResultPrp;

/**
 * Created by User on 03-03-2017.
 */

public interface RegisterView {

    void onRegisterComplete(LoginResultPrp loginResult);

    void startProgress();
    void stopProgress();

    void showFeedbackMessage(String message);

}
