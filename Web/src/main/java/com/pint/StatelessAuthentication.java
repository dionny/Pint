package com.pint;

import com.pint.entity.Employee;
import com.pint.entity.Hospital;
import com.pint.repository.EmployeeRepository;
import com.pint.repository.HospitalRepository;
import com.pint.security.User;
import com.pint.security.UserRole;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.filter.CharacterEncodingFilter;
import com.pint.repository.UserRepository;
import sun.security.krb5.internal.HostAddress;

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
            private UserRepository userRepository;

            @Autowired
            private EmployeeRepository employeeRepository;

            @Autowired
            private HospitalRepository hospitalRepository;

            @Override
            public void afterPropertiesSet() {
                Hospital hospital = addHospital();
                addEmployee(hospital, "manager", "manager", "Dionny", "Santiago", "555-555-5551", UserRole.MANAGER);
                addEmployee(hospital, "coordinator", "coordinator", "Gregory", "Jean-Baptiste", "555-555-5551", UserRole.COORDINATOR);
                addEmployee(hospital, "nurse", "nurse", "Anjli", "Chhatwani", "555-555-5551", UserRole.NURSE);
                addUser("donor", "donor", UserRole.DONOR);
            }

            private Hospital addHospital() {
                Hospital hospital = new Hospital("FIU Hospital");
                hospitalRepository.create(hospital);
                return hospital;
            }

            private void addEmployee(Hospital hospital,
                                     String username,
                                     String password,
                                     String firstName,
                                     String lastName,
                                     String phoneNumber,
                                     UserRole role) {

                if (userRepository.findByUsername(username) != null) {
                    return;
                }

                User user = new User();
                user.setUsername(username);
                user.setPassword(new BCryptPasswordEncoder().encode(password));
                user.grantRole(role);

                userRepository.save(user);

                Employee employee = new Employee(firstName, lastName, phoneNumber, hospital);
                employee.setUserId(user.getId());

                employeeRepository.save(employee);
            }

            private void addUser(String username, String password, UserRole role) {
                // Don't add if user already exists.
                if (userRepository.findByUsername(username) != null) {
                    return;
                }

                User user = new User();
                user.setUsername(username);
                user.setPassword(new BCryptPasswordEncoder().encode(password));
                user.grantRole(role);
                userRepository.save(user);
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
