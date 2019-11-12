package com.example.homework4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextBirdName, editTextZipcode, editTextPersonName;
    Button buttonSubmit, buttonSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSubmit = findViewById(R.id.buttonSubmit);
        buttonSearch = findViewById(R.id.buttonSearchZipcode);
        editTextBirdName = findViewById(R.id.editTextBirdName);
        editTextZipcode = findViewById(R.id.editTextSearchZipcode);
        editTextPersonName = findViewById(R.id.editTextPersonName);

        buttonSubmit.setOnClickListener(this);
        buttonSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == buttonSubmit) {
            String birdName = editTextBirdName.getText().toString();
            String personName = editTextPersonName.getText().toString();
            int zipcode = Integer.parseInt(editTextZipcode.getText().toString());

            Bird bird = new Bird(birdName, zipcode, personName);

            // get handle to "birds" key in the JSON store
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("birds");

            // add b to the list in "birds"
            myRef.push().setValue(bird);

            Toast.makeText(this, "Added a bird sighting", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent searchIntent = new Intent(this, SearchActivity.class);
            startActivity(searchIntent);
        }
    }
}
