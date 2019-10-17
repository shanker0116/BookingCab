package com.shanker.cab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {

    //first initialize the buttons

    private Button welcomeDriverBtn;
    private Button welcomeCustomerBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        //assign ID along with typecasting

        welcomeDriverBtn = (Button) findViewById(R.id.driver_select_btn);
        welcomeCustomerBtn = (Button) findViewById(R.id.customer_select_btn);


        // button on click actions

        welcomeDriverBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //using intent move from parent to defined activity

                Intent loginRegIntent = new Intent(WelcomeActivity.this,DriverLoginRegisterActivity.class);
                startActivity(loginRegIntent);
            }
        });


        welcomeCustomerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //using intent move from parent to defined activity

                Intent loginRegIntent = new Intent(WelcomeActivity.this,CustomerLoginRegisterActivity.class);
                startActivity(loginRegIntent);
            }
        });

    }
}
