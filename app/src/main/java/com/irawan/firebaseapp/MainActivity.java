package com.irawan.firebaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    TextView ledStatus,ledStatus2,ledStatus3, sensor;
    Button btnOn, btnOff, btnOn2, btnOff2, btnOn3, btnOff3;

    DatabaseReference refLED1, refLED2, refLED3, refSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensor = findViewById(R.id.sensor);

        ledStatus = findViewById(R.id.ledStatus);
        btnOn = findViewById(R.id.btnOn);
        btnOff = findViewById(R.id.btnOff);

        ledStatus2 = findViewById(R.id.ledStatus2);
        btnOn2 = findViewById(R.id.btnOn2);
        btnOff2 = findViewById(R.id.btnOff2);

        ledStatus3 = findViewById(R.id.ledStatus3);
        btnOn3 = findViewById(R.id.btnOn3);
        btnOff3 = findViewById(R.id.btnOff3);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        refLED1 = database.getReference("led").child("led1");
        refLED2 = database.getReference("led").child("led2");
        refLED3 = database.getReference("led").child("led3");

        refSensor = database.getReference("sensor").child("suhu");

        // Read from the database
        refLED1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                ledStatus.setText("LED is "+value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
//                Log.w(TAG, "Failed to read value.", error.toException());
                Toast.makeText(MainActivity.this, "Failed to read value. "+error.toException(), Toast.LENGTH_SHORT).show();
            }
        });

        refLED2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                ledStatus2.setText("LED 2 is "+value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
//                Log.w(TAG, "Failed to read value.", error.toException());
                Toast.makeText(MainActivity.this, "Failed to read value. "+error.toException(), Toast.LENGTH_SHORT).show();
            }
        });

        refLED3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                ledStatus3.setText("LED is "+value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
//                Log.w(TAG, "Failed to read value.", error.toException());
                Toast.makeText(MainActivity.this, "Failed to read value. "+error.toException(), Toast.LENGTH_SHORT).show();
            }
        });

        refSensor.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                float value = dataSnapshot.getValue(float.class);
                sensor.setText("Suhu = "+value+" Derajat");
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
//                Log.w(TAG, "Failed to read value.", error.toException());
                Toast.makeText(MainActivity.this, "Failed to read value. "+error.toException(), Toast.LENGTH_SHORT).show();
            }
        });

        btnOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refLED1.setValue("ON");
            }
        });

        btnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refLED1.setValue("OFF");
            }
        });

        btnOn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refLED2.setValue("ON");
            }
        });

        btnOff2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refLED2.setValue("OFF");
            }
        });

        btnOn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refLED3.setValue("ON");
            }
        });

        btnOff3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refLED3.setValue("OFF");
            }
        });
    }
}
