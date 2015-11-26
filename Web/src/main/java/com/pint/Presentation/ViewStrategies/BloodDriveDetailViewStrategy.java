package com.pint.Presentation.ViewStrategies;

import com.pint.Data.Models.BloodDrive;
import com.pint.Presentation.ViewModels.BloodDriveDetailViewModel;
import com.pint.Presentation.ViewModels.ViewModel;
import org.springframework.stereotype.Service;

/**
 * Created by Dionny on 11/26/2015.
 */
@Service
public class BloodDriveDetailViewStrategy extends ViewStrategy<BloodDrive> {
    @Override
    protected ViewModel mapObject(BloodDrive drive) {
        return new BloodDriveDetailViewModel(
                drive.getBloodDriveId(),
                drive.getTitle(),
                drive.getDescription(),
                drive.getStartTime(),
                drive.getEndTime(),
                drive.getAddress(),
                drive.getNumberOfDonors());
    }

    @Override
    protected ViewModel defaultMapping() {
        return new BloodDriveDetailViewModel();
    }
}
