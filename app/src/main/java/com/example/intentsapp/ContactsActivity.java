package com.example.intentsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class ContactsActivity extends AppCompatActivity {

    EditText etname,etnum,etweb,etloc;
    Button btnSubmit;
    RadioButton rbtn1,rbtn2,rbtn3;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        etname=findViewById(R.id.etname);
        etnum=findViewById(R.id.etnum);
        etweb=findViewById(R.id.etweb);
        etloc=findViewById(R.id.etloc);
        btnSubmit=findViewById(R.id.btnSubmit);
        rbtn1=findViewById(R.id.rbtn1);
        rbtn2=findViewById(R.id.rbtn2);
        rbtn3=findViewById(R.id.rbtn3);
        radioGroup=findViewById(R.id.radioGroup);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etname.getText().toString().isEmpty() ||
                        etnum.getText().toString().isEmpty() ||
                        etweb.getText().toString().isEmpty() ||
                        etloc.getText().toString().isEmpty()){
                    Toast.makeText(ContactsActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    String name,number,website,location;
                    int img=1;
                    name=etname.getText().toString().trim();
                    number=etnum.getText().toString().trim();
                    website=etweb.getText().toString().trim();
                    location=etloc.getText().toString().trim();

                    switch (radioGroup.getCheckedRadioButtonId()){
                        case R.id.rbtn2:
                            img=2;
                            break;
                        case R.id.rbtn3:
                            img=3;
                            break;
                    }

                    Bundle extras = new Bundle();
                    Intent intent;
                    intent = new Intent();

                    extras.putString("name",name);
                    extras.putString("number",number);
                    extras.putString("website",website);
                    extras.putString("location",location);
                    extras.putInt("image",img);

                    intent.putExtras(extras);

                    setResult(RESULT_OK,intent);
                    ContactsActivity.this.finish();
                }
            }
        });
    }

}