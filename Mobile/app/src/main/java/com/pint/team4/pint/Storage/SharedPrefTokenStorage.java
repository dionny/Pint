package com.pint.team4.pint.Storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.pint.team4.pint.R;

/**
 * Created by gregoryjean-baptiste on 11/16/15.
 */
public class SharedPrefTokenStorage implements TokenStorage {

    private SharedPreferences sharedPreferences;
    private Context context;
    private String defaultValue = "null";

    public SharedPrefTokenStorage(Context context) {
        this.context = context;
        this.sharedPreferences = this.context.getSharedPreferences(
                this.context.getResources().getString(R.string.shared_pref_filename), Context.MODE_PRIVATE);
    }

    @Override
    public boolean hasToken() {
        return this.sharedPreferences.contains(this.context.getResources().getString(R.string.token_name));
    }

    @Override
    public String getToken() {
        String requestToken = this.sharedPreferences.getString(this.context.getResources().
                getString(R.string.token_name), defaultValue);
        return requestToken;
    }

    @Override
    public void putToken(String token) {
        SharedPreferences.Editor editor = this.sharedPreferences.edit();
        editor.putString(this.context.getResources().getString(R.string.token_name), token);
        editor.commit();
    }

    @Override
    public void deleteToken() {
        SharedPreferences.Editor editor = this.sharedPreferences.edit();
        editor.remove(this.context.getResources().getString(R.string.token_name));
        editor.commit();
    }
}
