package jas.cse.milkwala.utils.customcontrols.dialogs;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by User on 28-02-2017.
 */

public class ConnectionUtils {

    public boolean checkInternetConnection(Activity activity) {
        ConnectivityManager connectivityManager = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        boolean isNetworkConnected = false;
        try {
            if (networkInfo.isConnected() == true) {
                isNetworkConnected = true;
            } else {
                isNetworkConnected = false;
            }
        }
        catch (NullPointerException e)
            {
            isNetworkConnected=false;
            }
        return  isNetworkConnected;
    }
}
