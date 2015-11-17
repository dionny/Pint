package com.pint.team4.pint;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.pint.team4.pint.Storage.TokenManager;
import com.pint.team4.pint.Storage.TokenStorage;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TokenStorage tokenStorage = TokenManager.getTokenStore(this.getApplicationContext());

        Intent intent;

        if(tokenStorage.hasToken()) {
            intent = new Intent(this, HomeActivity.class);
            this.startActivity(intent);
        } else {
            intent = new Intent(this, LoginActivity.class);
            this.startActivity(intent);
        }
    }
}
