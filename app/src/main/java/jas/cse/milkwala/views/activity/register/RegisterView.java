package jas.cse.milkwala.views.activity.register;

import jas.cse.milkwala.modle.properties.register.RegisterResponse;

/**
 * Created by User on 03-03-2017.
 */

public interface RegisterView {

    void onRegistrationComplete(RegisterResponse response);


    void startProgress();
    void stopProgress();

    void showFeedbackMessage(String message);

}
