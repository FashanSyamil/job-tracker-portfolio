package com.portfolio.jobtracker;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Make this a table
public class JobApplication {

    @Id //This is the Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto generated this number (1,2,3..)
    private Long id;

    // 1. These are variables (fields) that stores data
    private String companyName;
    private String jobTitle;
    private String status;

    // The DEFAULT CONSTRUCTOR
    public JobApplication(){

    }

    // 2. This is a constructor, it runs when you create a new job.
    public JobApplication(String companyName, String jobTitle, String status){
        this.companyName = companyName;
        this.jobTitle = jobTitle;
        this.status = status;
    }

    // Getter for ID
    public Long getId(){
        return id;
    }

    // 3. Getters (to read data)
    public String getCompanyName(){
        return companyName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getJobTitle(){
        return jobTitle;
    }

    public String getStatus(){
        return status;
    }
}
