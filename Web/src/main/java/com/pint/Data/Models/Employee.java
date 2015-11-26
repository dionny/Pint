package com.pint.Data.Models;

import com.pint.BusinessLogic.Utilities.Constants;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = Constants.EMPLOYEE_TABLE_NAME)
public class Employee implements Comparable {

    @NotNull
    @Id
    private Long userId;

    @NotNull
    @Size(min = 1, max = 50)
    private String firstName;

    @NotNull
    @Size(min = 1, max = 50)
    private String lastName;

    @NotNull
    @Size(min = 1, max = 15)
    private String phoneNumber;

    @Transient
    private String email;

    @OneToOne(targetEntity = Hospital.class)
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String phoneNo, Hospital hospital) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNo;
        this.hospital = hospital;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * Getter of firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter of firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter of lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter of lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter of hospital
     */
    public Hospital getHospitalId() {
        return hospital;
    }

    /**
     * Setter of hospital
     */
    public void setHospitalId(Hospital hospital) {
        this.hospital = hospital;
    }

    /**
     * Getter of phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Setter of phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Getter of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter of firstName
     */
    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public int compareTo(Object o) {
        return userId.compareTo(((Employee) o).getUserId());
    }

    @Override
    public boolean equals(Object other) {
        return userId.equals(((Employee) other).userId);
    }
}
