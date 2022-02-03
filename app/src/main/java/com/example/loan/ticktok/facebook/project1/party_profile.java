package com.example.loan.ticktok.facebook.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

public class party_profile extends AppCompatActivity {

    CircleImageView img;
    TextView name,party;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_party_profile);

        img = (CircleImageView) findViewById(R.id.image);
        name = (TextView) findViewById(R.id.nametxt);
        party =(TextView) findViewById(R.id.partytxt);

        Intent intent = this.getIntent();

        String nametxt = intent.getStringExtra("name");
        String partytxt = intent.getStringExtra("party");
        int image = intent.getIntExtra("image",R.drawable.raila);


        name.setText(nametxt);
        party.setText(partytxt);
        img.setImageResource(image);


    }
}
