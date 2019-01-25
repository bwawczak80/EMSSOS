package net.wawczak.brian.emssos;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class userInput extends AppCompatActivity {

    EditText userNameInput;
    EditText dobInput;
    EditText emergencyContactInput;
    EditText contactPhoneInput;

    EditText medConditionInput;
    EditText allergyInput;
    EditText rxInput;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_input);

    userNameInput = findViewById(R.id.idInputName);
    dobInput = findViewById(R.id.idInputDob);
    emergencyContactInput = findViewById(R.id.idInputEmerCon);
    contactPhoneInput = findViewById(R.id.idInputConPhone);
    medConditionInput = findViewById(R.id.idMedConditionInput);
    allergyInput = findViewById(R.id.idAllergyInput);
    rxInput = findViewById(R.id.idRxInput);

    save = findViewById(R.id.btnSave);


    save.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            saveUserData();

            Intent intent = new Intent(userInput.this, MainActivity.class);
            startActivity(intent);
        }
    });
    }


    public void saveUserData() {

        String holdName = userNameInput.getText().toString();
        String holdDob = dobInput.getText().toString();
        String holdEmergencyContact = emergencyContactInput.getText().toString();
        String holdContactNum = contactPhoneInput.getText().toString();

        String holdCondition = medConditionInput.getText().toString();
        String holdAllergy = allergyInput.getText().toString();
        String holdRx = rxInput.getText().toString();

        SharedPreferences sp = getSharedPreferences("UserData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        editor.putString("userName", holdName);
        editor.putString("dOfB", holdDob);
        editor.putString("emerCon", holdEmergencyContact);
        editor.putString("conNum", holdContactNum);
        editor.putString("conditionList", holdCondition);
        editor.putString("allergyList", holdAllergy);
        editor.putString("rxList", holdRx);
        editor.apply();

    }
}
