package com.app.crud;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterUserActivity extends AppCompatActivity {

    /* Get firebase database instance */
    private DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    private EditText name, email, phone, password;

    private String txt_name, txt_email, txt_password, txt_phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
    }

    public String validateCPF(String cpf){
        CPFValidator cpfValidator = new CPFValidator();
        cpfValidator.assertValidCPF(cpf);

        if((cpfValidator.assertValidCPF(cpf)) == true)
        {
            return "CPF Valido";
        }
        else
        {
            return "CPF Invalido";
        }
    }

    public void registerUser(View view)
    {
        String typeUser = "";
        UserApp userApp = new UserApp();
        DatabaseReference databaseReferenceInstance = database.getRef();
        DatabaseReference databaseReference = databaseReferenceInstance.child("user");

        /* Converting EditText type into String type */
        txt_name = name.getText().toString();
        txt_email = email.getText().toString();
        txt_password = password.getText().toString();
        txt_phone = phone.getText().toString();

        /* Select the database instance child user */
        databaseReference = database.getDatabase().getReference("user");

        /* Setting data into ServiceApp class */
        userApp.setName(txt_name);
        userApp.setEmail(txt_email);
        userApp.setPhone(txt_phone);
        userApp.setPassword(txt_password);

        /* Transfering data into Firebase object reference */
        userApp.setId(databaseReference.push().getKey());

        /* Data transfered from object to Firebase database */
        databaseReference.child(userApp.getId()).setValue(userApp);

        databaseReference.child("user").child(userApp.getId()).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error saving data", task.getException());
                }
                else {
                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
                }
            }
        });

        Intent activity = new Intent(RegisterUserActivity.this, MainActivity.class);
        startActivity(activity);
        Toast.makeText(this,"Usuário(a) Cadastrado com Sucesso!",Toast.LENGTH_LONG).show();
    }
}