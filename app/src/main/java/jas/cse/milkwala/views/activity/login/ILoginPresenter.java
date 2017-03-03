package jas.cse.milkwala.views.activity.login;

/**
 * Created by User on 02-03-2017.
 */

public interface ILoginPresenter {
    public void requestLogin(String email,String password);
    public void requestForgotPassword(String email);
}
