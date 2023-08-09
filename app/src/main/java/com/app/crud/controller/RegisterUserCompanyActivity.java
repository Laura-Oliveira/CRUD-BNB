package com.app.crud.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.app.crud.R;
import com.app.crud.model.Company;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterUserCompanyActivity extends AppCompatActivity
{
    /* Get firebase database instance */
    private DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    //Data User Company
    private EditText cnpj, razaoSocial;

    //General Data
    private EditText email, phone, cep, neigbornhood, city, typeAdress, adress, number, extraInfo, uf;

    private String txt_cpnj, txt_razaoSocial, txt_email, txt_phone, txt_cep, txt_neighborhood;
    private String txt_city, txt_typeAdress, txt_adress, txt_number, txt_extraInfo, txt_uf;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user_company);

        razaoSocial = findViewById(R.id.edit_text_register_company_name);
        cnpj = findViewById(R.id.edit_text_register_cnpj);
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
    public String validateCNPJ(String cnpj)
    {
        return cnpj;
    }

    public void registerUserCompany(View view)
    {
        Company companyUserApp = new Company();
        DatabaseReference databaseReferenceInstance = database.getRef();
        DatabaseReference databaseReference = databaseReferenceInstance.child("user");

        /* Converting EditText type into String type */
        txt_razaoSocial = razaoSocial.getText().toString();
        txt_cpnj = cnpj.getText().toString();
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

        validateCNPJ(txt_cpnj);

        /* Select the database instance child user */
        databaseReference = database.getDatabase().getReference("company");

        /* Setting data into PessoaFIsica class */
        companyUserApp.setRazaoSocial(txt_razaoSocial);
        companyUserApp.setCnpj(Integer.parseInt(txt_cpnj));
        companyUserApp.setEmail(txt_email);
        companyUserApp.setPhone(Integer.parseInt(txt_phone));
        companyUserApp.setCep(Integer.parseInt(txt_cep));
        companyUserApp.setNeigbornhood(txt_neighborhood);
        companyUserApp.setCity(txt_city);
        companyUserApp.setTypeAdress(txt_typeAdress);
        companyUserApp.setAdress(txt_adress);
        companyUserApp.setNumber(Integer.parseInt(txt_number));
        companyUserApp.setEmail(txt_extraInfo);
        companyUserApp.setUf(txt_uf);

        /* Transfering data into Firebase object reference */
        companyUserApp.setId(databaseReference.push().getKey());

        /* Data transfered from object to Firebase database */
        databaseReference.child(companyUserApp.getId()).setValue(companyUserApp);

        Intent activity = new Intent(RegisterUserCompanyActivity.this, RegisterUserCompanyActivity.class);
        Toast.makeText(this,"Pessoa Jurísica Cadastrada com Sucesso!",Toast.LENGTH_LONG).show();
        startActivity(activity);
    }
}