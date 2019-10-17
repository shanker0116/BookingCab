package com.shanker.cab;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class DriverLoginRegisterActivity extends AppCompatActivity {

    //initialize the Fields

    private Button driverLoginBtn, driverRegisterBtn;

    private TextView driverStatus, driverRegLink;

    private EditText driverEmail, driverPass;

    //inital database

    private FirebaseAuth mAuth;
    //intial progress dailog
    private ProgressDialog loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_login_register);

        //declare mauth

        mAuth = FirebaseAuth.getInstance();

        //declare loading bar
        loadingBar = new ProgressDialog(this);

        //initialize fields using ID

        driverLoginBtn = findViewById(R.id.driver_loginbtn);
        driverRegisterBtn = findViewById(R.id.driver_registerbtn);

        driverStatus = findViewById(R.id.driverlogin_status);
        driverRegLink = findViewById(R.id.driver_reglink);

        driverEmail = findViewById(R.id.driver_email);
        driverPass = findViewById(R.id.driver_password);
        loadingBar = new ProgressDialog(this);

        //if not click on register link

        driverRegisterBtn.setVisibility(View.INVISIBLE);
        driverRegisterBtn.setEnabled(false);


        //set onclick on driver register link for account

        driverRegLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //set login and reg link to Invisible

                driverLoginBtn.setVisibility(View.INVISIBLE);
                driverRegLink.setVisibility(View.INVISIBLE);
                driverStatus.setText("Driver Register");

                driverRegisterBtn.setVisibility(View.VISIBLE);
                driverRegisterBtn.setEnabled(true);



            }
        });

        //set on click lister for register button

        driverRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //get text and set to string

                String email = driverEmail.getText().toString();
                String pass = driverPass.getText().toString();

                //create method for registerdriver

                registerDriver(email,pass);
            }
        });

    }

    // create method for register driver

    private void registerDriver(String email, String pass) {

        //if condition for check email is empty

        if (TextUtils.isEmpty(email))
        {
            //prompt msg if email empty
            Toast.makeText(DriverLoginRegisterActivity.this, "Please Enter Email...", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(pass))
        {
            //prompt msg if email empty

            Toast.makeText(DriverLoginRegisterActivity.this, "Please Enter Password...", Toast.LENGTH_SHORT).show();
        }
        else
        {

            //set loading bar

            loadingBar.setTitle("Driver Registration");
            loadingBar.setMessage("Please Wait...While we are register your data!");
            loadingBar.show();

            //create user with mauth

            mAuth.createUserWithEmailAndPassword(email, pass)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            //check condition if task is success?
                            if (task.isSuccessful())
                            {
                                Toast.makeText(DriverLoginRegisterActivity.this, "Driver Register Successfully!", Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();
                            }
                            else
                            {
                                Toast.makeText(DriverLoginRegisterActivity.this, "Driver Register failed, Try Again!", Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();
                            }
                        }
                    });
        }
     }
}
