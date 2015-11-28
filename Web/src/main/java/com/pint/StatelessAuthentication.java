package com.pint;

import com.fasterxml.classmate.TypeResolver;
import com.pint.BusinessLogic.Security.User;
import com.pint.BusinessLogic.Security.UserRole;
import com.pint.BusinessLogic.Services.BloodDriveService;
import com.pint.BusinessLogic.Services.HospitalService;
import com.pint.BusinessLogic.Services.NotificationService;
import com.pint.BusinessLogic.Services.UserService;
import com.pint.BusinessLogic.Utilities.Utils;
import com.pint.Data.Models.*;
import org.joda.time.DateTime;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.filter.CharacterEncodingFilter;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.schema.WildcardType;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.Filter;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static springfox.documentation.schema.AlternateTypeRules.newRule;

@EnableAutoConfiguration
@Configuration
@ComponentScan
@EnableSwagger2
public class StatelessAuthentication {

    public static void main(String[] args) {
        SpringApplication.run(StatelessAuthentication.class, args);
    }

    @Autowired
    private TypeResolver typeResolver;

    @Bean
    public Docket petApi() {
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build().pathMapping("/")
                .directModelSubstitute(LocalDate.class, String.class).genericModelSubstitutes(ResponseEntity.class)
                .alternateTypeRules(newRule(typeResolver.resolve(DeferredResult.class, typeResolver.resolve(ResponseEntity.class, WildcardType.class)), typeResolver.resolve(WildcardType.class)))
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET, newArrayList(new ResponseMessageBuilder().code(500).message("500 message").responseModel(new ModelRef("Error")).build()));
    }

//    private SecurityContext securityContext() {
//        return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.regex("/anyPath.*")).build();
//    }

    @Bean
    public InitializingBean insertDefaultUsers() {
        return new InitializingBean() {

            @Autowired
            HospitalService hospitalService;

            @Autowired
            UserService userService;

            @Autowired
            BloodDriveService bloodDriveService;

            @Autowired
            NotificationService notificationService;

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
                            Utils.sqlDate(DateTime.now().minusDays(10)),
                            Utils.sqlDate(DateTime.now().plusDays(10)),
                            coordinator);

                    List<Long> nurses = new ArrayList<>();
                    nurses.add(nurse.getUserId());

                    bloodDriveService.assignNurses(userService.getUserById(coordinator.getUserId()), drive.getBloodDriveId(), nurses);

                    BloodDrive drive2 = bloodDriveService.createBloodDrive(
                            hospital,
                            "FIU-MMC Blood Drive", "1234 Maidique Way",
                            "We're all about the pizza.",
                            "Miami",
                            "FL",
                            Utils.sqlDate(DateTime.now().minusDays(5)),
                            Utils.sqlDate(DateTime.now().plusDays(15)),
                            coordinator);

                    bloodDriveService.createBloodDrive(
                            hospital,
                            "Red Cross Blood Drive", "1234 Red Way",
                            "We need blood due to the high frequency of accidents in the area.",
                            "Miami",
                            "FL",
                            Utils.sqlDate(DateTime.now().plusDays(7)),
                            Utils.sqlDate(DateTime.now().plusDays(25)),
                            coordinator);

                    bloodDriveService.createBloodDrive(
                            hospital,
                            "Miami Children's Blood Drive", "1234 Infinite Way",
                            "We need donations for children patients.",
                            "Miami",
                            "FL",
                            Utils.sqlDate(DateTime.now().plusDays(25)),
                            Utils.sqlDate(DateTime.now().plusDays(45)),
                            coordinator);

                    BloodDrive homesteadBloodDrive = bloodDriveService.createBloodDrive(
                            hospital,
                            "Homestead Blood Drive", "1234 Homestead Way",
                            "We are at the heart of homestead.",
                            "Homestead",
                            "FL",
                            Utils.sqlDate(DateTime.now().minusDays(25)),
                            Utils.sqlDate(DateTime.now().plusDays(3)),
                            coordinator);

                    // Create a few notifications.
                    Notification notification =
                            addNotification(drive,
                                    Utils.sqlDate(DateTime.now().minusDays(1)),
                                    "FIU Hospital Notification", "The pizza is here.", "We've got some pineapple pizza.");

                    Notification notification2 = addNotification(drive,
                            Utils.sqlDate(DateTime.now().minusDays(1).plusMinutes(30)),
                            "FIU Hospital Notification", "The pizza is half gone.", "We've got a little bit of pineapple pizza.");

                    Notification notification3 = addNotification(drive,
                            Utils.sqlDate(DateTime.now().minusDays(1).plusMinutes(60)),
                            "FIU Hospital Notification", "The pizza is completely gone.", "But we still need blood.");

                    // Create a few notifications.
                    Notification notificationDrive2 =
                            addNotification(drive2,
                                    Utils.sqlDate(DateTime.now().minusDays(2)),
                                    "Red Cross Notification", "We need a lot more blood.", "We required a lot more blood than originally anticipated.");

                    Notification notification2Drive2 =
                            addNotification(drive2,
                                    Utils.sqlDate(DateTime.now().minusDays(1).plusMinutes(30)),
                                    "Red Cross Notification",
                                    "Thank you very much for your donations.",
                                    "We are very thankful that we met our donation goals yesterday. Now let's keep going strong.");

                    Notification homesteadNotification =
                            addNotification(homesteadBloodDrive,
                                    Utils.sqlDate(DateTime.now().minusDays(1)),
                                    "Homestead Notification", "We are running out of time!", "Let's get more blood donations.");

                    Donor donor = addDonor("donor", "donor", "USA", "Miami", "FL", 33165);
                    Donor donor2 = addDonor("donor2", "donor2", "USA", "Homestead", "FL", 33135);

                    addUserNotification(notification, donor);
                    addUserNotification(notification2, donor);
                    addUserNotification(notification3, donor);

                    addUserNotification(notificationDrive2, donor);
                    addUserNotification(notification2Drive2, donor);

                    addUserNotification(homesteadNotification, donor2);
                }

                // Let's start building out a second hospital.
                Hospital hospital2 = addHospital("Baptist Hospital");
                addEmployee(hospital2, "h2nurse1", "h2nurse1", "Sajib", "Talukder", "555-555-5551", UserRole.NURSE);
                addEmployee(hospital2, "h2nurse2", "h2nurse2", "Peter", "Clarke", "555-555-5551", UserRole.NURSE);
            }

            private Notification addNotification(BloodDrive drive,
                                                 Date sentTime,
                                                 String title,
                                                 String shortDescription,
                                                 String longDescription) {
                return notificationService.createNotification(drive, sentTime, title, shortDescription, longDescription);
            }

            private UserNotification addUserNotification(Notification notification, Donor user) {
                return notificationService.createUserNotification(notification, user);
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
                                         UserRole role) throws Exception {

                if (userService.getUserByEmail(username) != null) {
                    return null;
                }

                return userService.createEmployee(username, password, firstName, lastName,
                        phoneNumber, role, hospital.getId());
            }

            private Donor addDonor(String username, String password, String country, String city, String state, int zip) {

                if (userService.getUserByEmail(username) != null) {
                    return null;
                }

                return userService.createDonor(username, password, country, city, state, zip);
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
