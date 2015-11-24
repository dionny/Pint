package com.pint.BusinessLogic.Services;

import com.pint.Data.DataFacade;
import com.pint.Data.Models.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Dionny on 11/24/2015.
 */
@Service
public class HospitalService {

    @Autowired
    private DataFacade dataFacade;

    public Hospital createHospital(String hospital) {
        return dataFacade.createHospital(hospital);
    }
}
