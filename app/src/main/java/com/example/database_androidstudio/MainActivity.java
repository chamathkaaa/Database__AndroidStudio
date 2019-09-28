package com.example.database_androidstudio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.database_androidstudio.Database.DBHelper;

import java.util.ConcurrentModificationException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button signIn, btnAdd, selectAll,update,delete;
    TextView userName, password;
    public DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = (TextView)findViewById(R.id.editUsername);
        password = (TextView)findViewById(R.id.editPassword);

        btnAdd = findViewById(R.id.btnAdd);
        selectAll = findViewById(R.id.btnSelect);
        update = findViewById(R.id.btnUpdate);
        delete = findViewById(R.id.btnDelete);
        signIn = findViewById(R.id.btnSign);

    }

}
