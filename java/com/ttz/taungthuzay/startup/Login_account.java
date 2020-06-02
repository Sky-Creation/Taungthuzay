package com.ttz.taungthuzay.startup;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.ttz.taungthuzay.R;
import com.ttz.taungthuzay.database.DatabaseAdapter;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Login_account extends Activity {

    public static final String MY_PREFS = "SharedPreferences";
    private DatabaseAdapter dbHelper;
    private EditText theUsername;
    private EditText thePassword;
    private CheckBox rememberDetails;


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences mySharedPreferences = getSharedPreferences(MY_PREFS, 0);
        SharedPreferences.Editor editor = mySharedPreferences.edit();
        editor.putLong("uid", 0);
        editor.commit();

        dbHelper = new DatabaseAdapter(this);
        dbHelper.open();

        setContentView(R.layout.activity_login_account);
        initControls();
    }

    private void initControls() {
        //Set the activity layout.
        theUsername = findViewById(R.id.Username);
        thePassword = findViewById(R.id.Password);
        Button loginButton = findViewById(R.id.Login);
        Button registerButton = findViewById(R.id.Register);
        Button clearButton = findViewById(R.id.Clear);
        Button exitButton = findViewById(R.id.Exit);
        rememberDetails = findViewById(R.id.RememberMe);

        //Create touch listeners for all buttons.
        loginButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                LogMeIn(v);
            }
        });

        registerButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Register(v);
            }
        });

        clearButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                ClearForm();
            }
        });

        exitButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Exit();
            }
        });
        //Create remember password check box listener.
        rememberDetails.setOnClickListener(new CheckBox.OnClickListener() {
            public void onClick(View v) {
                RememberMe();
            }
        });

        //Handle remember password preferences.
        SharedPreferences prefs = getSharedPreferences(MY_PREFS, 0);
        String thisUsername = prefs.getString("username", "");
        String thisPassword = prefs.getString("password", "");
        boolean thisRemember = prefs.getBoolean("remember", false);
        if (thisRemember) {
            theUsername.setText(thisUsername);
            thePassword.setText(thisPassword);
            rememberDetails.setChecked(true);
        }

    }

    /**
     * Deals with Exit option - exits the application.
     */
    private void Exit() {
        finish();
    }

    /**
     * Clears the login form.
     */
    private void ClearForm() {
        saveLoggedInUId(0, "", "");
        theUsername.setText("");
        thePassword.setText("");
    }

    /**
     * Handles the remember password option.
     */
    private void RememberMe() {
        boolean thisRemember = rememberDetails.isChecked();
        SharedPreferences prefs = getSharedPreferences(MY_PREFS, 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("remember", thisRemember);
        editor.apply();
    }

    /**
     * This method handles the user login process.
     *
     * @param v
     */
    private void LogMeIn(View v) {
        //Get the username and password
        String thisUsername = theUsername.getText().toString();
        String thisPassword = thePassword.getText().toString();

        //Assign the hash to the password
        thisPassword = md5(thisPassword);

        // Check the existing user name and password database
        Cursor theUser = dbHelper.fetchUser(thisUsername, thisPassword);
        if (theUser != null) {
            startManagingCursor(theUser);
            if (theUser.getCount() > 0) {
                saveLoggedInUId(theUser.getLong(theUser.getColumnIndex(DatabaseAdapter.COL_ID)), thisUsername, thePassword.getText().toString());
                stopManagingCursor(theUser);
                theUser.close();
                Intent i = new Intent(v.getContext(), MainActivity.class);
                startActivity(i);
            }

            //Returns appropriate message if no match is made
            else {
                Toast.makeText(getApplicationContext(),
                        "You have entered an incorrect username or password.",
                        Toast.LENGTH_SHORT).show();
                saveLoggedInUId(0, "", "");
            }
            stopManagingCursor(theUser);
            theUser.close();
        } else {
            Toast.makeText(getApplicationContext(),
                    "Database query error",
                    Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Open the Registration activity.
     *
     * @param v
     */
    private void Register(View v) {
        Intent i = new Intent(v.getContext(), Create_account.class);
        startActivity(i);
    }

    private void saveLoggedInUId(long id, String username, String password) {
        SharedPreferences settings = getSharedPreferences(MY_PREFS, 0);
        SharedPreferences.Editor myEditor = settings.edit();
        myEditor.putLong("uid", id);
        myEditor.putString("username", username);
        myEditor.putString("password", password);
        boolean rememberThis = rememberDetails.isChecked();
        myEditor.putBoolean("rememberThis", rememberThis);
        myEditor.apply();
    }

    /**
     * Deals with the password encryption.
     *
     * @param s The password.
     * @return
     */
    private String md5(String s) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(s.getBytes());
            byte[] messageDigest = digest.digest();

            StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < messageDigest.length; i++)
                hexString.append(Integer.toHexString(0xFF & messageDigest[i]));

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            return s;
        }
    }
}