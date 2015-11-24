package com.pint.team4.pint.ListManagement.ListElements;

import com.pint.team4.pint.Network.RequestURL;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by gregoryjean-baptiste on 11/18/15.
 */
public class BloodDriveElement implements ListElement {

    String name;
    float latitude;
    float longitude;
    long id;
    String shortDesc;

    public BloodDriveElement(JSONObject bloodDrive) {
        try {
            name = bloodDrive.getString("title");
            latitude = (float) bloodDrive.getDouble("latitude");
            longitude = (float) bloodDrive.getDouble("longitude");
            id = bloodDrive.getLong("id");
            shortDesc = bloodDrive.getString("short");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getRequestUrl() {
        String url = RequestURL.REQ_BD;
        url = RequestURL.buildUrl(url, "bdid", this.id);
        return url;
    }
}
