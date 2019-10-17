package com.shanker.cab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CustomerLoginRegisterActivity extends AppCompatActivity {

    //first initialize the buttons

    private Button customerLoginBtn, customerRegBtn;
    private TextView customerRegLink, customerStatus;
    private EditText customerEmail, customerPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_login_register);

    //initialize it using by ID

        customerLoginBtn = (Button) findViewById(R.id.customer_loginbtn);
        customerRegBtn = (Button)findViewById(R.id.customer_registerbtn);
        customerRegLink = (TextView) findViewById(R.id.customer_reglink);
        customerStatus = (TextView) findViewById(R.id.customer_status);
        customerEmail = (EditText) findViewById(R.id.customer_email);
        customerPass = (EditText) findViewById(R.id.customer_password);

        //if registerlink not pressed

        customerRegBtn.setVisibility(View.INVISIBLE);
        customerRegBtn.setEnabled(false);


        //user click on Registerlink set onclickListener
        customerRegLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //set loginButton as Invisible

                customerLoginBtn.setVisibility(View.INVISIBLE);
                customerRegLink.setVisibility(View.INVISIBLE);
                customerStatus.setText("Customer Register");

                customerRegBtn.setVisibility(View.VISIBLE);
                customerLoginBtn.setEnabled(true);

            }
        });

    }
}
