package com.example.ssl.sharedpreference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText username,password;
    private Button save,read;
    private TextView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.Username);
        password = (EditText)findViewById(R.id.Password);
        save = (Button)findViewById(R.id.Save);
        read = (Button) findViewById(R.id.Read);
        show = (TextView) findViewById(R.id.Show);

        save.setOnClickListener(this);
        read.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.Save:
                savedata();
                break;
            case R.id.Read:
                readdata();
                break;
        }
    }

    private void savedata() {
        String name = username.getText().toString();
        String pass = password.getText().toString();
        SharedPreferences sp = getSharedPreferences("data",MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("UserName:",name);
        editor.putString("Password:",pass);
        editor.commit();

    }

    private void readdata() {
        SharedPreferences sp = getSharedPreferences("data",MODE_PRIVATE);
        String name=sp.getString("UserName:","");
        String pass = sp.getString("Password:","");
        show.setText("User Name:"+name+"\n"+"Password:"+pass);
    }
}
