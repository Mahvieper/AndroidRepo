package com.example.myuserapplication.Utility;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

public class DialogUtil {
    public void Dialog(Context con, String value) {
        //Starting of the Dialog Box
        AlertDialog.Builder builder = new AlertDialog.Builder(con);

        // Set the message show for the Alert time
        builder.setMessage(value);


        // Set Alert Title
        builder.setTitle("Alert");

        // Set Cancelable false
        // for when the user clicks on the outside
        // the Dialog Box then it will remain show
        builder.setCancelable(false);

        // Set the positive button with yes name
        // OnClickListener method is use of
        // DialogInterface interface.

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) { }
        });

        // Set the Negative button with No name
        // OnClickListener method is use
        // of DialogInterface interface.

        // Create the Alert dialog
        AlertDialog alertDialog = builder.create();

        // Show the Alert Dialog box
        alertDialog.show();

        Toast.makeText(con, "SignUp Successful", Toast.LENGTH_SHORT).show();
    }

}
