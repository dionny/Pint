package com.pint.team4.pint.Storage;

/**
 * Created by gregoryjean-baptiste on 11/16/15.
 */
public interface TokenStorage {
    boolean hasToken();
    String getToken();
    void putToken(String token);
    void deleteToken();
}
