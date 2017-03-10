package jas.cse.milkwala.views.activity.profile;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jas.cse.milkwala.R;
import jas.cse.milkwala.modle.networkconnection.BaseUrl;
import jas.cse.milkwala.modle.properties.profile.ProfileResult;
import jas.cse.milkwala.views.activity.BaseActivity;

public class ProfileActivity extends BaseActivity implements ProfileView {

    @BindView(R.id.textViewCity)
    TextView textViewCity;

    @BindView(R.id.textViewState)
    TextView textViewState;

    @BindView(R.id.buttonUpdateInfo)
    Button buttonUpdateInfo;

    //Data Variables
    String[] ARRAY_CITY;
    String[] ARRAY_STATES;


    IProfilePresenter profilePresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        profilePresenter=new ProfilePresenter(this,this);
        ButterKnife.bind(this);
        profilePresenter.loadCities();
        profilePresenter.loadStates();
    }

    @Override
    public void loadProfile(ProfileResult profileResult) {

    }

    @Override
    public void updateProfileResult() {

    }

    @Override
    public void startProgress() {
        startProgressDialog(getString(R.string.loadingPleasewait));
    }

    @Override
    public void stopProgress() {
        stopProgressDialog();
    }

    @Override
    public void loadCities(String[] cities) {
        ARRAY_CITY=cities;
    }

    @Override
    public void loadStates(String[] states) {
        ARRAY_STATES=states;
    }
    @OnClick(R.id.textViewCity)
    public void onCityClick()
    {
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setItems(ARRAY_CITY, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                textViewCity.setText(ARRAY_CITY[which]);
            }
        });
        dialog.show();
    }

    @OnClick(R.id.textViewState)
    public void onStateClick()
    {
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setItems(ARRAY_STATES, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                textViewState.setText(ARRAY_STATES[which]);
            }
        });
        dialog.show();
    }
    public void updateinfo(View view)
    {


    }

}
