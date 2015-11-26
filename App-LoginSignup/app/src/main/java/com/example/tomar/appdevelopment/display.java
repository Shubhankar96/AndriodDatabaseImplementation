package com.example.tomar.appdevelopment;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by tomar on 26-11-2015.
 */
public class display extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
        String username=getIntent().getStringExtra("Username");
        TextView User= (TextView)findViewById(R.id.TVUsername);
        User.setText(username);
    }
}
