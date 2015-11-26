package com.example.tomar.appdevelopment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {

    DataBaseHelper helper=new DataBaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
   /* ArrayList<String> arrayList= new ArrayList<String>();
    String string="";
    String string1="";

    public void onClick1 (View v){

        TextView textView2=(TextView) findViewById(R.id.textView2);

        Button button = (Button) v;

        string = (String) button.getText().toString();

        if(!string.contains("+") && ! string.contains("-") && !string.contains("*") && !string.contains("/")){
            string1=string1+string;
            if(arrayList.size()>0){
                arrayList.remove(arrayList.size()-1);
            }
            arrayList.add(string1);
        }
        else{
            arrayList.add(string);
            arrayList.add(string);
            string1="";
        }
        //textView2.setText(textView2.getText().toString()+string);
        textView2.setText(arrayList.toString());
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public void onButtonClick(View v)
    {
        if(v.getId()==R.id.BLogin)
        {
            EditText Username= (EditText)findViewById(R.id.TFUsername);
            String User=Username.getText().toString();
            EditText Password= (EditText)findViewById(R.id.TFPassword);
            String Pass=Password.getText().toString();
            String password=helper.searchPass(User);
            if(Pass.equals(password)) {
                Intent i = new Intent(MainActivity.this, display.class);
                i.putExtra("Username", User);
                startActivity(i);
            }else{
                Toast temp=Toast.makeText(MainActivity.this,"UserName and Password Dont Match",Toast.LENGTH_SHORT);
                temp.show();
            }
        }
        if (v.getId()== R.id.Bsignup)
        {
            Intent i= new Intent(MainActivity.this, SignUp.class);
            startActivity(i);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
