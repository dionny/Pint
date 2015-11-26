package com.pint;

import com.pint.BusinessLogic.Security.UserRole;
import com.pint.BusinessLogic.Services.BloodDriveService;
import com.pint.BusinessLogic.Services.HospitalService;
import com.pint.BusinessLogic.Services.UserService;
import com.pint.BusinessLogic.Utilities.Utils;
import com.pint.Data.Models.BloodDrive;
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
            public void afterPropertiesSet() throws Exception {
                // Let's build out a hospital.
                Hospital hospital = addHospital("FIU Hospital");
                addEmployee(hospital, "manager", "manager", "Dionny", "Santiago", "555-555-5551", UserRole.MANAGER);
                Employee coordinator =
                        addEmployee(hospital, "coordinator", "coordinator", "Gregory", "Jean-Baptiste", "555-555-5551", UserRole.COORDINATOR);
                Employee nurse = addEmployee(hospital, "nurse", "nurse", "Anjli", "Chhatwani", "555-555-5551", UserRole.NURSE);
                addEmployee(hospital, "nurse", "nurse", "Xuejiao", "Liu", "555-555-5551", UserRole.NURSE);
                addEmployee(hospital, "nurse2", "nurse2", "Dweep", "Patel", "555-555-5551", UserRole.NURSE);
                addEmployee(hospital, "nurse3", "nurse3", "Azizul", "Hakim", "555-555-5551", UserRole.NURSE);

                if (coordinator != null) {
                    BloodDrive drive = bloodDriveService.createBloodDrive(
                            hospital,
                            "FIU Blood Drive", "1234 FIU Way",
                            "We need blood due to the high frequency of accidents in the area.",
                            "Miami",
                            "FL",
                            Utils.parseDate("2015-12-02"),
                            Utils.parseDate("2015-12-05"),
                            coordinator);

                    bloodDriveService.assignNurse(drive.getBloodDriveId(), nurse);

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

                // Let's start building out a second hospital.
                Hospital hospital2 = addHospital("Baptist Hospital");
                addEmployee(hospital2, "h2nurse1", "h2nurse1", "Sajib", "Talukder", "555-555-5551", UserRole.NURSE);
                addEmployee(hospital2, "h2nurse2", "h2nurse2", "Peter", "Clarke", "555-555-5551", UserRole.NURSE);

                addDonor("donor", "donor", "USA", "Miami", "FL", 33165);
                addDonor("donor2", "donor2", "USA", "Homestead", "FL", 33135);
            }

            private Hospital addHospital(String name) {
                return hospitalService.createHospital(name);
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

            private void addDonor(String username, String password, String country, String city, String state, int zip) {

                if (userService.getUserByEmail(username) != null) {
                    return;
                }

                userService.createDonor(username, password, country, city, state, zip);
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
