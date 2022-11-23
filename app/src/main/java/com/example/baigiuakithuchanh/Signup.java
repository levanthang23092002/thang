package com.example.baigiuakithuchanh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Signup extends AppCompatActivity {
    private EditText name,email,pass,confirm;
    private Button signup;
    private View back;
    private ImageView btn_eye_pass,btn_eye_confirm,btn_eye_confirm1,btn_eye_confirm2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        setTitle("SignUp");
        signup = findViewById(R.id.btnsignup);
        name =findViewById(R.id.txtten);
        email =findViewById(R.id.txtsuemail);
        pass=findViewById(R.id.txtsupass);
        confirm=findViewById(R.id.txtconfirm);
        back = findViewById(R.id.btnbacksignup);
        btn_eye_confirm=findViewById(R.id.btn_eye_confirm);
        btn_eye_pass=findViewById(R.id.btn_eye_pass);
        btn_eye_confirm1=findViewById(R.id.btn_eye_confirm1);
        btn_eye_confirm2=findViewById(R.id.btn_eye_confirm2);



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

        btn_eye_confirm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirm.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                btn_eye_confirm2.setVisibility(View.VISIBLE);
                btn_eye_confirm1.setVisibility(View.INVISIBLE);
            }
        });
        btn_eye_confirm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirm.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                btn_eye_confirm2.setVisibility(View.INVISIBLE);
                btn_eye_confirm1.setVisibility(View.VISIBLE);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pass1,con1;
                pass1= pass.getText().toString().trim();
                con1=confirm.getText().toString().trim();
                if(email.getText().toString().equals("") || pass.getText().toString().equals("") || name.getText().toString().equals("")|| confirm.getText().toString().equals("")){
                    Toast.makeText(Signup.this, "not allowed Null!!", Toast.LENGTH_SHORT).show();
                }
                else if (pass1 .equals(con1)){
                    Toast.makeText(Signup.this, "Create Account Successful!!", Toast.LENGTH_SHORT).show();
                    String name1=name.getText().toString().trim();
                    String email1=email.getText().toString().trim();
                    String pass2=pass.getText().toString().trim();
                    appunti.email=email1;
                    appunti.name= name1;
                    appunti.pass=pass2;

                    openlognin();}
                else {
                    Toast.makeText(Signup.this, "PassWord and Confirm must be equal!!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openlognin();
            }
        });

    }
    public void openlognin(){
        Intent intent = new Intent(this ,MainActivity.class);
        startActivity(intent);
    }



}