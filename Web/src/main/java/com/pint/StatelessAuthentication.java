package com.pint;

import com.pint.BusinessLogic.Security.UserRole;
import com.pint.BusinessLogic.Services.BloodDriveService;
import com.pint.BusinessLogic.Services.HospitalService;
import com.pint.BusinessLogic.Services.UserService;
import com.pint.BusinessLogic.Utilities.Utils;
import com.pint.Data.Models.Employee;
import com.pint.Data.Models.Hospital;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.Filter;

@EnableAutoConfiguration
@Configuration
@ComponentScan
public class StatelessAuthentication {

    public static void main(String[] args) {
        SpringApplication.run(StatelessAuthentication.class, args);
    }

    @Bean
    public InitializingBean insertDefaultUsers() {
        return new InitializingBean() {

            @Autowired
            HospitalService hospitalService;

            @Autowired
            UserService userService;

            @Autowired
            BloodDriveService bloodDriveService;

            @Override
            public void afterPropertiesSet() {
                Hospital hospital = addHospital();
                addEmployee(hospital, "manager", "manager", "Dionny", "Santiago", "555-555-5551", UserRole.MANAGER);
                Employee coordinator =
                        addEmployee(hospital, "coordinator", "coordinator", "Gregory", "Jean-Baptiste", "555-555-5551", UserRole.COORDINATOR);
                addEmployee(hospital, "nurse", "nurse", "Anjli", "Chhatwani", "555-555-5551", UserRole.NURSE);
                addUser("donor", "donor", UserRole.DONOR);

                if (coordinator != null) {
                    bloodDriveService.createBloodDrive(
                            hospital,
                            "FIU Blood Drive", "1234 FIU Way",
                            "We need blood due to the high frequency of accidents in the area.",
                            "Miami",
                            "FL",
                            Utils.parseDate("2015-12-02"),
                            Utils.parseDate("2015-12-05"),
                            coordinator);

                    bloodDriveService.createBloodDrive(
                            hospital,
                            "FIU-MMC Blood Drive", "1234 Maidique Way",
                            "We're all about the pizza.",
                            "Miami",
                            "FL",
                            Utils.parseDate("2015-12-05"),
                            Utils.parseDate("2015-12-08"),
                            coordinator);

                    bloodDriveService.createBloodDrive(
                            hospital,
                            "Red Cross Blood Drive", "1234 Red Way",
                            "We need blood due to the high frequency of accidents in the area.",
                            "Miami",
                            "FL",
                            Utils.parseDate("2015-12-02"),
                            Utils.parseDate("2015-12-05"),
                            coordinator);

                    bloodDriveService.createBloodDrive(
                            hospital,
                            "Miami Children's Blood Drive", "1234 Infinite Way",
                            "We need donations for children patients.",
                            "Miami",
                            "FL",
                            Utils.parseDate("2015-12-05"),
                            Utils.parseDate("2015-12-08"),
                            coordinator);
                }
            }

            private Hospital addHospital() {
                return hospitalService.createHospital("FIU Hospital");
            }

            private Employee addEmployee(Hospital hospital,
                                         String username,
                                         String password,
                                         String firstName,
                                         String lastName,
                                         String phoneNumber,
                                         UserRole role) {

                if (userService.getUserByEmail(username) != null) {
                    return null;
                }

                return userService.createEmployee(username, password, firstName, lastName,
                        phoneNumber, role, hospital.getId());
            }

            private void addUser(String username, String password, UserRole role) {

                if (userService.getUserByEmail(username) != null) {
                    return;
                }

                userService.createUser(username, password, role);
            }
        };
    }

    @Bean
    public Filter characterEncodingFilter() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    }
}
