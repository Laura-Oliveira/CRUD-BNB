package com.app.crud.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.app.crud.R;

public class RegisterTypeUserActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_type_user);
    }

    public void openRegisterUserPage(View view)
    {
        Intent intent = new Intent(this, RegisterUserActivity.class);
        startActivity(intent);
    }

    public void openRegisterCompanyPage(View view)
    {
        Intent intent = new Intent(this, RegisterUserCompanyActivity.class);
        startActivity(intent);
    }
}