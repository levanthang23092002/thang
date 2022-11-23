package com.example.baigiuakithuchanh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.DatabaseMetaData;

public class MainActivity extends AppCompatActivity {
    DatabaseReference mData;
    private Button lognin, fb,gg;
    private EditText email;
    private EditText pass;
    private TextView addacc;
    private CheckBox checkBox;
    private ImageView btn_eye_pass,btn_eye_confirm;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("SignIn");
        setContentView(R.layout.activity_main);

        mData = FirebaseDatabase.getInstance().getReference();

        mData.child("thongtin").push().setValue("thang le");
        checkBox =findViewById(R.id.savepass);
        lognin = findViewById(R.id.btnlognin);
        email = findViewById(R.id.txtemail);
        pass = findViewById(R.id.txtpass);
        addacc=findViewById(R.id.btnadacc);
        fb=findViewById(R.id.btnfb);
        gg=findViewById(R.id.btngg);

        btn_eye_confirm=findViewById(R.id.btn_eye_confirm);
        btn_eye_pass=findViewById(R.id.btn_eye_pass);


        sharedPreferences = getSharedPreferences("datalogin",MODE_PRIVATE);
        email.setText( sharedPreferences.getString("Name",""));
        pass.setText(sharedPreferences.getString("pass",""));
        checkBox.setChecked(sharedPreferences.getBoolean("checkbox0",false));

        btn_eye_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pass.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                btn_eye_confirm.setVisibility(View.VISIBLE);
                btn_eye_pass.setVisibility(View.INVISIBLE);
            }
        });
        btn_eye_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                btn_eye_confirm.setVisibility(View.INVISIBLE);
                btn_eye_pass.setVisibility(View.VISIBLE);
            }
        });

        lognin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = email.getText().toString().trim();
                String passwork = pass.getText().toString().trim();

                if(email.getText().toString().equals("") || pass.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Không được để trống!!", Toast.LENGTH_SHORT).show();
                }
                else
                if (email.getText().toString().equals(appunti.name) && pass.getText().toString().equals(appunti.pass)) {
                    Toast.makeText(MainActivity.this, "Đăng nhập thành công!!", Toast.LENGTH_SHORT).show();
                    openhome();
                    if (checkBox.isChecked()){
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("Name",name);
                        editor.putString("pass",passwork);
                        editor.putBoolean("checkbox",true);
                        editor.commit();
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "Tên Email hoặc password không tồn tại!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openhome();
            }
        });

        gg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openhome();
            }
        });

        addacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignup();
            }
        });
    }
//    public void openprofile(){
//        Intent intent = new Intent(this ,profile.class);
//        startActivity(intent);
//    }
//
    public void openhome(){
        Intent intent = new Intent(this ,home.class);
        startActivity(intent);
    }
    public void openSignup(){
        Intent intent = new Intent(this ,Signup.class);
        startActivity(intent);
    }

}