package com.example.intentsapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvmain,tvName,tvNumber,tvWebsite,tvLocation;
    Button btn1;
    final int ACTIVITYCONTACTS=3;
    ImageView imageView,imgCall,imgWeb,imgLoc;
    LinearLayout lin1,lin2,lin3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvmain= findViewById(R.id.tvmain);
        btn1=findViewById(R.id.btn1);
        tvName=findViewById(R.id.tvName);
        tvNumber=findViewById(R.id.tvNumber);
        tvWebsite=findViewById(R.id.tvWebsite);
        tvLocation=findViewById(R.id.tvLocation);
        imageView=findViewById(R.id.imageView);
        imgCall=findViewById(R.id.imgCall);
        imgWeb=findViewById(R.id.imgWeb);
        imgLoc=findViewById(R.id.imgLoc);
        lin1=findViewById(R.id.lin1);
        lin2=findViewById(R.id.lin2);
        lin3=findViewById(R.id.lin3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent;
                intent = new Intent(MainActivity.this,
                        com.example.intentsapp.ContactsActivity.class);
                startActivityForResult(intent,ACTIVITYCONTACTS);
            }
        });

        imgCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+tvNumber.getText().toString().trim()));
                startActivity(intent);
            }
        });
        imgWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+tvWebsite.getText().toString().trim()));
                startActivity(intent);
            }
        });
        imgLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="+tvLocation.getText().toString().trim()));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK){
            String name,number,website,location;
            int image;

            Bundle extras=new Bundle();
            extras=data.getExtras();

            name=extras.getString("name");
            number=extras.getString("number");
            website=extras.getString("website");
            location=extras.getString("location");
            image=extras.getInt("image");

            System.out.println(name+" "+number+" "+website+" "+location);
            tvName.setText(name);
            tvNumber.setText(number);
            tvWebsite.setText(website);
            tvLocation.setText(location);
            switch(image){
                case 1:
                    imageView.setImageResource(R.drawable.ic_baseline_sentiment_satisfied_alt_24);
                    break;
                case 2:
                    imageView.setImageResource(R.drawable.ic_baseline_sentiment_satisfied_24);
                    break;
                case 3:
                    imageView.setImageResource(R.drawable.ic_baseline_sentiment_very_dissatisfied_24);
                    break;
            }
            tvName.setVisibility(View.VISIBLE);
            lin1.setVisibility(View.VISIBLE);
            lin2.setVisibility(View.VISIBLE);
            lin3.setVisibility(View.VISIBLE);
            imageView.setVisibility(View.VISIBLE);

       }
    }
}