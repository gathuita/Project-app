package com.example.loan.ticktok.facebook.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class  parties extends AppCompatActivity {
    int[] images = {R.drawable.azimio, R.drawable.uda, R.drawable.anc, R.drawable.ford, R.drawable.wiper};

    String[] Parties = {"Azimio La Umoja ", "UDA", "ANC", "FORD KENYA", "WIPER"};

    String[] PartyLeaders = {"Raila Odinga", "William Ruto", "Musalia Mudavadi", "Moses Wetangula", "Kalonzo Musyoka"};

    //String[] Occupations = {"Party Leader","Party Leader","Party Leader","Party Leader","Party Leader"};

    ListView listView;

    ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parties);
        listView = (ListView) findViewById(R.id.listView);

        listAdapter = new ListAdapter(parties.this, Parties,PartyLeaders,images);

        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(parties.this,"Congratulation you are now a member of "+Parties[i]+" Lead by "+PartyLeaders[i], Toast.LENGTH_LONG).show();
            }
        });
    }
}