package jas.cse.milkwala.views.activity.login;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jas.cse.milkwala.R;
import jas.cse.milkwala.modle.properties.LoginResultPrp;
import jas.cse.milkwala.views.activity.BaseActivity;
import jas.cse.milkwala.views.activity.register.RegisterActivity;

public class LoginActivity extends BaseActivity implements LoginView {
    @BindView(R.id.edittextemail)
    EditText editTextemail;

    @BindView(R.id.edittextpassword)
    EditText editTextpassword;

    @BindView(R.id.textviewregister)
    TextView textViewRegister;

    ILoginPresenter loginPresenter;   //object of LoginPresenter, but by the name ILoginPresenter, because it implements ILoginPresenter.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginPresenter=new LoginPresenter(this,this);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.textviewregister)
    public void onClickRegisterTextview()
    {
        Intent intent=new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.buttonSignin)
    public void onLoginButtonClick()
    {
        loginPresenter.requestLogin(editTextemail.getText().toString(),editTextpassword.getText().toString());
    }

/*
    @OnClick(R.id.textViewForgotPassword)
    public void onForgotPasswordClick()
    {
        loginPresenter.requestForgotPassword(editTextEmail.getText().toString());
    }
*/

    @Override
    public void onLoginComplete(LoginResultPrp loginResult) {
        Toast.makeText(this,loginResult.getResult().getMessage(), Toast.LENGTH_SHORT).show();
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
    public void showFeedbackMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

   /* @Override
    public void onForgetPasswordComplete() {

    }*/
}
