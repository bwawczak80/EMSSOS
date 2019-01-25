package net.wawczak.brian.emssos;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    Button display;
    Button edit;
    TextView displayUser;
    TextView displayDob;
    TextView displayContact;
    TextView displayContactPhone;
    TextView displayCondition;
    TextView displayAllergies;
    TextView displayRx;


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        setContentView(R.layout.activity_main);

        display = findViewById(R.id.btnDisplay);
        edit = findViewById(R.id.btnEdit);

        displayUser = findViewById(R.id.idDisplayUserName);
        displayDob = findViewById(R.id.idDisplayDob);
        displayContact = findViewById(R.id.idDisplayContact);
        displayContactPhone = findViewById(R.id.idDisplayContactPhone);
        displayCondition = findViewById(R.id.idDisplayMedCon);
        displayAllergies = findViewById(R.id.idDisplayallergies);
        displayRx = findViewById(R.id.idDisplayRx);

        displayUser.setText("");
        displayDob.setText("");
        displayContact.setText("");
        displayContactPhone.setText("");
        displayCondition.setText("");
        displayAllergies.setText("");
        displayRx.setText("");


        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String a[] = readFromSharedPref();
                displayUser.setText(String.format("%s\n", String.format("Name: %s", a[0])));
                displayDob.setText(String.format("Date Of Birth: %s\n", a[1]));
                displayContact.setText(String.format("Emergency Contact: %s\n", a[2]));
                displayContactPhone.setText(String.format(" Contact Phone: %s\n", a[3]));
                displayCondition.setText(String.format("Medical Conditions:\n%s\n", a[4]));
                displayAllergies.setText(String.format("Known Allergies:\n%s\n", a[5]));
                displayRx.setText(String.format("Current Medications:\n%s\n", a[6]));

            }
        });


        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, userInput.class);
                startActivity(intent);
            }
        });


    }

    public String[] readFromSharedPref() {

        SharedPreferences sp = getSharedPreferences("UserData", MODE_PRIVATE);
        String name = sp.getString("userName", "");
        String dob = sp.getString("dOfB", "");
        String contact = sp.getString("emerCon", "");
        String contactNum = sp.getString("conNum", "");
        String conditions = sp.getString("conditionList", "");
        String allergies = sp.getString("allergyList", "");
        String rx = sp.getString("rxList", "");
        return new String[]{name, dob, contact, contactNum, conditions, allergies, rx};

    }
}
