package com.app.crud.model;
import android.app.Application;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class RealmDatabase extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        // on below line we are initializing our real m database.
        Realm.init(this);
        // on below line we are creating a variable for realm configuration and initializing it.
        RealmConfiguration config = new RealmConfiguration.Builder()
                // below line is to allow write
                // data to database on ui thread.
                .allowWritesOnUiThread(true)
                // below line is to delete realm
                // if migration is needed.
                .deleteRealmIfMigrationNeeded()
                // at last we are calling a build method to generate the configurations.
                .build();
        // on below line we are setting the default
        // configuration to our realm database.
        Realm.setDefaultConfiguration(config);
    }
}