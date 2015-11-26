package com.pint.Presentation.ViewModels;

import javax.validation.constraints.NotNull;
import java.sql.Date;

/**
 * Created by Dionny on 11/26/2015.
 */
public class BloodDriveDetailViewModel extends BloodDriveSummaryViewModel {

    @NotNull
    public int numberOfDonors;

    public BloodDriveDetailViewModel(){

    }

    public BloodDriveDetailViewModel(long bloodDriveId, String title, String description, Date startTime, Date endTime, String address, int numberOfDonors)
    {
        super(bloodDriveId, title, description, startTime, endTime, address);
        this.numberOfDonors = numberOfDonors;
    }
}
