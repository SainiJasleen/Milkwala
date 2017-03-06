package jas.cse.milkwala.utils.customcontrols.dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

import jas.cse.milkwala.R;

/**
 * Created by User on 28-02-2017.
 */

public class ApplicationDialog {


    public void showMessageDialogWithFinish(final Activity activity,String message)
    {
        AlertDialog.Builder dialog=new AlertDialog.Builder(activity);
        dialog.setCancelable(false);
        dialog.setMessage(message);
        dialog.setTitle(activity.getString(R.string.feedback));
        dialog.setPositiveButton(activity.getString(R.string.ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                activity.finish();
            }
        });
        dialog.show();
    }
   
   }

