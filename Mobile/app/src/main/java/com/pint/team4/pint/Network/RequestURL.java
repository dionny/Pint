package com.pint.team4.pint.Network;

/**
 * Created by gregoryjean-baptiste on 11/18/15.
 */
public class RequestURL {
    public static final String REQ_BD_BY_LOC = "";
    public static final String REQ_USER_NOTIF = "";
    public static final String REQ_BD_NOTIF = "";
    public static final String REQ_BD = "";

    public static String buildUrl(String url, String paramName, String value) {
        if(url.contains("?")) {
            return url + "&" + paramName + "=" + value;
        } else {
            return url + "?" + paramName + "=" + value;
        }
    }

    public static String buildUrl(String url, String paramName, int value) {
        if(url.contains("?")) {
            return url + "&" + paramName + "=" + value;
        } else {
            return url + "?" + paramName + "=" + value;
        }
    }

    public static String buildUrl(String url, String paramName, float value) {
        if(url.contains("?")) {
            return url + "&" + paramName + "=" + value;
        } else {
            return url + "?" + paramName + "=" + value;
        }
    }
}
