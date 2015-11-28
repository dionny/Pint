package com.pint.Presentation.ViewModels;

import java.sql.Timestamp;

/**
 * Created by DionnyS on 11/28/2015.
 */
public class NotificationSummaryViewModel extends ViewModel {
    // User notification.
    public boolean hasSeen;

    // Notification.
    public Timestamp sentTime;
    public String title;
    public String shortDescription;

    // Blood drive.
    public Long bloodDriveId;
    public String bloodDriveTitle;

    public NotificationSummaryViewModel() {
    }

    public NotificationSummaryViewModel(boolean hasSeen,
                                        Timestamp sentTime,
                                        String title,
                                        String shortDescription,
                                        Long bloodDriveId,
                                        String bloodDriveTitle) {

        this.hasSeen = hasSeen;
        this.sentTime = sentTime;
        this.title = title;
        this.shortDescription = shortDescription;
        this.bloodDriveId = bloodDriveId;
        this.bloodDriveTitle = bloodDriveTitle;
    }
}
