package jas.cse.milkwala.views.activity.register;

import jas.cse.milkwala.modle.properties.register.RegisterBody;
import okhttp3.ResponseBody;

/**
 * Created by User on 03-03-2017.
 */

public interface IRegisterPresenter {
    public void requestRegister(RegisterBody registerBody);
}
