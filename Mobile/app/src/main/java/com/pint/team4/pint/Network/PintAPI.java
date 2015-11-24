package com.pint.team4.pint.Network;

/**
 * Created by gregoryjean-baptiste on 11/17/15.
 */
public interface PintAPI {
    public void GetBloodDrivesByLocation(String city, String state);
    public void GetUserNotifications(long userId);
    public void GetBloodDriveNotifications(long bloodDriveId);
}
