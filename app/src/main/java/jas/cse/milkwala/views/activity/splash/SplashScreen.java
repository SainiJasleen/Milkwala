package jas.cse.milkwala.views.activity.splash;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import jas.cse.milkwala.R;
import jas.cse.milkwala.utils.customcontrols.dialogs.ApplicationDialog;
import jas.cse.milkwala.utils.customcontrols.dialogs.ConnectionUtils;
import jas.cse.milkwala.views.activity.login.LoginActivity;

public class SplashScreen extends AppCompatActivity {
    int Splash_Time=3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

    }

    protected void onResume()
    {
        super.onResume();
        chechConnection();
    }
    private void chechConnection()
    {
        ConnectionUtils connectionUtils=new ConnectionUtils();
        boolean value=connectionUtils.checkInternetConnection(this);
        if(value==true)
        {
            startSplash();
        }
        else
        {
            ApplicationDialog applicationDialog=new ApplicationDialog();
            applicationDialog.showMessageDialogWithFinish(this,getString(R.string.internetconnectionmessage));
        }
    }

    private void startSplash() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashScreen.this,LoginActivity.class);
                startActivity(intent);
            }
        },Splash_Time);
    }

}
