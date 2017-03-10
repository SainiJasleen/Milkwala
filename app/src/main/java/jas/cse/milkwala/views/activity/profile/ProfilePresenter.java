package jas.cse.milkwala.views.activity.profile;

import android.app.Activity;
import android.view.View;
import android.widget.Button;

import jas.cse.milkwala.R;
import jas.cse.milkwala.modle.networkconnection.BaseUrl;

/**
 * Created by User on 10-03-2017.
 */

public class ProfilePresenter implements IProfilePresenter, BaseUrl {


    Activity activity;
    ProfileView view;

    ProfilePresenter(Activity activity, ProfileView profileView)
    {
        this.activity=activity;
        this.view=profileView;
    }


    @Override
    public void loadCities() {
        String[] cities=activity.getResources().getStringArray(R.array.cities);
        view.loadCities(cities);

    }

    @Override
    public void loadStates() {
        String[] states=activity.getResources().getStringArray(R.array.states);
        view.loadStates(states);
    }

}
