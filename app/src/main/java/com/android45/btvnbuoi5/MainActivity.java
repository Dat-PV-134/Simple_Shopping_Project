package com.android45.btvnbuoi5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etUserName;
    Button btnLogin;
    String process;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        etUserName = findViewById(R.id.etUserName);
        btnLogin = findViewById(R.id.btnLogin);
        Intent intent = new Intent(getBaseContext(), FoodOrderActivity.class);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = etUserName.getText().toString();
                intent.putExtra("User", process);
                startActivity(intent);
            }
        });
    }
}