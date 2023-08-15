package com.app.crud.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.app.crud.R;
import com.app.crud.model.UserApp;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.google.firebase.database.ValueEventListener;


public class ListUserDataActivity extends AppCompatActivity
{
    private DatabaseReference firebaseDatabase = FirebaseDatabase.getInstance().getReference();
    UserApp userApp = new UserApp();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.app.crud.R.layout.activity_list_user_data);
    }

    TextView usernameText = findViewById(R.id.profile_username);

     /*   firebaseDatabase.child("user").child("-NPZUUObPJpwgCrNjbk9").child("name").addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            if (dataSnapshot.exists())
            {
                String data = dataSnapshot.getValue(String.class);

                if (data != null)
                {
                    usernameText.setText(data);
                }
                else
                {
                    usernameText.setText("String nula");
                }
            }
            else
            {
                usernameText.setText("Dados não encontrados");
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError)
        {
            Log.e("ProfileActivity", "Erro ao ler dados do banco de dados: " + databaseError.getMessage());
        }
    }); */
}