package com.example.homework4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextZipcode;
    Button buttonSearchZipcode, buttonReport;
    TextView textViewBirdName, textViewPersonName;

    //Add some comment

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        buttonSearchZipcode = findViewById(R.id.buttonSearchZipcode);
        buttonReport = findViewById(R.id.buttonReport);
        editTextZipcode = findViewById(R.id.editTextSearchZipcode);

        buttonSearchZipcode.setOnClickListener(this);
        buttonReport.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == buttonSearchZipcode) {
            int zipcode = Integer.parseInt(editTextZipcode.getText().toString());
        }
        else {
            Intent intentReport = new Intent(this, MainActivity.class);
            startActivity(intentReport);
        }
    }
}
