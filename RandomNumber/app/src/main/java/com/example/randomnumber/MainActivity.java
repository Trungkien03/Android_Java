package com.example.randomnumber;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView minNumber;
    TextView maxNumber;
    TextView numResults;
    Button btnRandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        minNumber = (TextView) findViewById(R.id.minNumber);
        maxNumber = (TextView) findViewById(R.id.maxNumber);
        numResults = (TextView) findViewById(R.id.numResult);

        btnRandom = (Button) findViewById(R.id.btnClick);

        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (minNumber.getText().toString().isEmpty() || maxNumber.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Please provide enough input value", Toast.LENGTH_SHORT).show();
                    return;
                }
                int min = Integer.parseInt(minNumber.getText().toString());
                int max = Integer.parseInt(maxNumber.getText().toString());



                if(min > max){
                    Toast.makeText(MainActivity.this, "Min must be less thn Max", Toast.LENGTH_SHORT).show();
                    
                } else {
                    Random random = new Random();
                    int randomNum = random.nextInt(max - min + 1) + min;
                    numResults.setText(String.valueOf(randomNum));
                }
            }
        });

    }
}