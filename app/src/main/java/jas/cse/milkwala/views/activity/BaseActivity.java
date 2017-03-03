package jas.cse.milkwala.views.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by User on 02-03-2017.
 */

public class BaseActivity extends AppCompatActivity {
    ProgressDialog progressDialog;

    public void startProgressDialog(String message)
    {

        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage(message);
        progressDialog.setCancelable(false);
        progressDialog.show();

    }
    public void stopProgressDialog()
    {
        if(progressDialog!=null) {
            progressDialog.dismiss();
        }
    }
}
