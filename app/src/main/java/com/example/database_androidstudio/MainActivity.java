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

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.addInfo(userName.getText().toString(),password.getText().toString());
                Toast.makeText(getApplicationContext(),"Data Added Successfully",Toast.LENGTH_LONG).show();
            }
        });

        selectAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List data = dbHelper.readAllInfo();

                for(int i = 0; i < data.size();i++){
                    Log.v("Data" +i,data.get(i).toString());
                    Toast.makeText(getApplicationContext(),"Received Successfully",Toast.LENGTH_LONG).show();
                }
            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.updateInfo(userName.getText().toString(),password.getText().toString());
                Toast.makeText(getApplicationContext(),"Data Updated Successfully",Toast.LENGTH_LONG).show();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.deleteInfo(userName.getText().toString());
                Toast.makeText(getApplicationContext(),"Data Deleted Successdully",Toast.LENGTH_LONG).show();
            }
        });

        dbHelper = new DBHelper(this);


    }

    public void addInfo(View view){
        String uname = userName.getText().toString();
        String pw = password.getText().toString();

        long newRowId = dbHelper.addInfo(uname,pw);

        Context context = getApplicationContext();
        CharSequence text = "Success";
        CharSequence text1 = "Fail";
        int duration = Toast.LENGTH_SHORT;
        if(newRowId > 0){
            Toast toast = Toast.makeText(context,text,duration);
            toast.show();
        }else{
            Toast toast = Toast.makeText(context,text1,duration);
            toast.show();
        }
    }

    public void selectAll(View view){

    }

    public void delete(View view){
        String uname = userName.getText().toString();

        //dbHelper.deleteInfo(uname);
        List delete = dbHelper.readAllInfo();

        Context context = getApplicationContext();
        CharSequence text = "Success";
        CharSequence text1 = "Fail";
        int duration = Toast.LENGTH_SHORT;


    }

    /*public void deleteInfo(String userName){

        SQLiteDatabase db = getReadableDatabase();

        String selection = UsersMaster.Users.COLUMN_NAME_USERNAME + "LIKE ?";
        String[] selectionArgs = {userName};

        db.delete(UsersMaster.Users.TABLE_NAME,selection,selectionArgs);
    }*/
}
