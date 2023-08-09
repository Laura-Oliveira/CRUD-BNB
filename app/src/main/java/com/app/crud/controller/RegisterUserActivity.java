package com.app.crud.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.app.crud.R;
import com.app.crud.model.CPFValidator;
import com.app.crud.model.PessoaFisica;
import com.app.crud.view.ListUserDataActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterUserActivity extends AppCompatActivity
{
    /* Get firebase database instance */
    private DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    //Data User
    private EditText username, cpf;

    //General Data
    private EditText email, phone, cep, neigbornhood, city, typeAdress, adress, number, extraInfo, uf;

    private String txt_username, txt_cpf, txt_email, txt_phone, txt_cep, txt_neighborhood;
    private String txt_city, txt_typeAdress, txt_adress, txt_number, txt_extraInfo, txt_uf;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        username = findViewById(R.id.edit_text_register_username);
        cpf = findViewById(R.id.edit_text_register_cpf);
        email = findViewById(R.id.edit_text_register_email);
        phone = findViewById(R.id.edit_text_register_phone);
        cep = findViewById(R.id.edit_text_register_cep);
        neigbornhood = findViewById(R.id.edit_text_register_neighborhood);
        city = findViewById(R.id.edit_text_register_city);
        typeAdress = findViewById(R.id.edit_text_register_type_adress);
        adress = findViewById(R.id.edit_text_register_adress);
        number = findViewById(R.id.edit_text_register_number);
        extraInfo = findViewById(R.id.edit_text_register_extra_info);
        uf = findViewById(R.id.edit_text_register_uf);
    }

    public boolean validateCPF(String cpf){
        CPFValidator cpfValidator = new CPFValidator();
        cpfValidator.assertValidCPF(cpf);

        if((cpfValidator.assertValidCPF(cpf)) == true)
        {
            return true;
            //"CPF Valido";
        }
        else
        {
            return false;
            //"CPF Invalido";
        }
    }

    public void registerUser(View view)
    {
        PessoaFisica userApp = new PessoaFisica();
        DatabaseReference databaseReferenceInstance = database.getRef();
        DatabaseReference databaseReference = databaseReferenceInstance.child("user");

        /* Converting EditText type into String type */
        txt_cpf = cpf.getText().toString();
        txt_username = username.getText().toString();
        txt_email = email.getText().toString();
        txt_phone = phone.getText().toString();
        txt_cep = cep.getText().toString();
        txt_neighborhood = neigbornhood.getText().toString();
        txt_city = city.getText().toString();
        txt_typeAdress = typeAdress.getText().toString();
        txt_adress = adress.getText().toString();
        txt_number = number.getText().toString();
        txt_extraInfo = extraInfo.getText().toString();
        txt_uf = uf.getText().toString();

        validateCPF(txt_cpf);

        /* Select the database instance child user */
        databaseReference = database.getDatabase().getReference("user");

        /* Setting data into PessoaFIsica class */
        userApp.setName(txt_username);
        userApp.setCpf(Integer.parseInt(txt_cpf));;
        userApp.setEmail(txt_email);
        userApp.setPhone(Integer.parseInt(txt_phone));
        userApp.setCep(Integer.parseInt(txt_cep));
        userApp.setNeigbornhood(txt_neighborhood);
        userApp.setCity(txt_city);
        userApp.setTypeAdress(txt_typeAdress);
        userApp.setAdress(txt_adress);
        userApp.setNumber(Integer.parseInt(txt_number));
        userApp.setEmail(txt_extraInfo);
        userApp.setUf(txt_uf);

        /* Transfering data into Firebase object reference */
        userApp.setId(databaseReference.push().getKey());

        /* Data transfered from object to Firebase database */
        databaseReference.child(userApp.getId()).setValue(userApp);

        Intent activity = new Intent(RegisterUserActivity.this, ListUserDataActivity.class);
        Toast.makeText(this,"Pessoa Física Cadastrada com Sucesso!",Toast.LENGTH_LONG).show();
        startActivity(activity);
    }
}