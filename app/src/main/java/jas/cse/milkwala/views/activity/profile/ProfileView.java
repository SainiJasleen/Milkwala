package jas.cse.milkwala.views.activity.profile;

import jas.cse.milkwala.modle.properties.profile.ProfileResult;

/**
 * Created by User on 10-03-2017.
 */

public interface ProfileView {
    void loadProfile(ProfileResult profileResult);
    void updateProfileResult();

    void startProgress();
    void stopProgress();

    void loadCities(String[] cities);
    void loadStates(String[] states);


}
