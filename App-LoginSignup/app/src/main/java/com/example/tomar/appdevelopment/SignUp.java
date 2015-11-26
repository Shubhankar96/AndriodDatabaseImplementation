package com.example.tomar.appdevelopment;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by tomar on 26-11-2015.
 */
public class SignUp extends Activity {
    DataBaseHelper helper= new DataBaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
    }
    public void onSignUpClick(View v)
    {
        if (v.getId() == R.id.Bsignupbutton)
        {
            EditText Name=(EditText)findViewById(R.id.TFName);
            EditText Email=(EditText)findViewById(R.id.TFemail);
            EditText Uname=(EditText)findViewById(R.id.TFuname);
            EditText Pass1=(EditText)findViewById(R.id.TFpass1);
            EditText Pass2=(EditText)findViewById(R.id.TFpass2);

            String namestr= Name.getText().toString();
            String emailstr= Email.getText().toString();
            String unamestr= Uname.getText().toString();
            String pass1str= Pass1.getText().toString();
            String pass2str= Pass2.getText().toString();

            if (!pass1str.equals(pass2str))
            {
            //POPUP MESSAGE
                Toast pass=Toast.makeText(SignUp.this,"Password Dont Match!",Toast.LENGTH_SHORT);
                pass.show();
            }
            else
            {
                //INSERT THE DETAILS IN DATABASE
                Contact c=new Contact();
                c.setName(namestr);
                c.setEmail(emailstr);
                c.setUname(unamestr);
                c.setPass(pass1str);

                helper.insertContact(c);
            }
        }
    }
}
