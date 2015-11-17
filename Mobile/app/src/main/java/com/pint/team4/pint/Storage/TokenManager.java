package com.pint.team4.pint.Storage;

import android.content.Context;

/**
 * Created by gregoryjean-baptiste on 11/16/15.
 */
public class TokenManager {
    public static TokenStorage getTokenStore(Context context) {
        /*Pointless but I really wanted to do this*/
        return new SharedPrefTokenStorage(context);
    }
}
