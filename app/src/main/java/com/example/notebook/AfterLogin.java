package com.example.notebook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;//注意不要导入android的包


public class AfterLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);
     //   Toolbar myToolbar=(Toolbar)findViewById(R.id.my_toolbar);
      //  setSupportActionBar(myToolbar);
    }
}
