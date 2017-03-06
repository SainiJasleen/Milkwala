package jas.cse.milkwala.views.activity.register;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jas.cse.milkwala.R;
import jas.cse.milkwala.modle.properties.register.RegisterBody;
import jas.cse.milkwala.modle.properties.register.RegisterResponse;
import jas.cse.milkwala.views.activity.BaseActivity;

public class RegisterActivity extends BaseActivity implements RegisterView {

    @BindView(R.id.edittextemail)
    EditText editTextemail;

    @BindView(R.id.edittextpassword)
    EditText editTextpassword;

    @BindView(R.id.edittextusername)
    EditText editTextusername;

    @BindView(R.id.edittextphone)
    EditText editTextphone;

    IRegisterPresenter registerPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        registerPresenter=new RegisterPresenter(this,this);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.buttonRegister)
    public void onRegisterButtonClick()
    {
            RegisterBody registerBody=new RegisterBody();
            registerBody.setEmail(editTextemail.getText().toString());
            registerBody.setPassword(editTextpassword.getText().toString());
            registerBody.setMobileNumber(editTextphone.getText().toString());
            registerBody.setUserName(editTextusername.getText().toString());
            registerBody.setDeviceToken("asdf");
            registerPresenter.requestRegister(registerBody);

        }

    @Override
    public void onRegistrationComplete(RegisterResponse response) {
        Toast.makeText(this,getString(R.string.RegistarationSucessful),Toast.LENGTH_SHORT).show();
        this.finish();

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
}
