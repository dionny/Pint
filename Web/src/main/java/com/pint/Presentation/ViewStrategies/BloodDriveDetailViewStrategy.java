package com.pint.Presentation.ViewStrategies;

import com.pint.Data.Models.BloodDrive;
import com.pint.Data.Models.Employee;
import com.pint.Presentation.ViewModels.BloodDriveDetailViewModel;
import com.pint.Presentation.ViewModels.ViewModel;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dionny on 11/26/2015.
 */
public class BloodDriveDetailViewStrategy extends ViewStrategy<BloodDrive> {

    private final List<Employee> assignedNurses;
    private final List<Employee> unassignedNurses;

    public BloodDriveDetailViewStrategy(List<Employee> assignedNurses, List<Employee> unassignedNurses){
        this.assignedNurses = assignedNurses;
        this.unassignedNurses = unassignedNurses;
    }

    @Override
    protected ViewModel mapObject(BloodDrive drive) {
        return new BloodDriveDetailViewModel(
                drive.getBloodDriveId(),
                drive.getTitle(),
                drive.getDescription(),
                drive.getStartTime(),
                drive.getEndTime(),
                drive.getAddress(),
                drive.getNumberOfDonors(),
                assignedNurses,
                unassignedNurses);
    }

    @Override
    protected ViewModel defaultMapping() {
        return new BloodDriveDetailViewModel();
    }
}
