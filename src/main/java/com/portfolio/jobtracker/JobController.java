package com.portfolio.jobtracker;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController // This annotation tells VS Code: "This class handles web requests"

public class JobController{

    private final JobRepository repository;

    // This is a Constructor. We will add one fake job to test it works.
    public JobController(JobRepository repository){
        this.repository = repository;
    }

    // When you visit the website address "/jobs", this function runs.
@GetMapping("/jobs")
    public List<JobApplication> getAllJobs(){
        return repository.findAll();
    }

@PostMapping("/jobs") // Entrance for new jobs
public JobApplication addJob(@RequestBody JobApplication newJob){
    return repository.save(newJob);
}

// The delete entrance
@DeleteMapping("/jobs/{id}")
public String deleteJob(@PathVariable Long id){
    
    if(repository.existsById(id)){
        repository.deleteById(id);
        return "Job with ID " + id + " was deleted.";
    }
    else{
        return "Job not found.";
    }
}

@PutMapping("/jobs/{id}")
public JobApplication updateJob(@PathVariable Long id, @RequestBody JobApplication updatedJob){

    JobApplication job = repository.findById(id).orElse(null);

    if(job !=null){
        job.setCompanyName(updatedJob.getCompanyName());
        job.setJobTitle(updatedJob.getJobTitle());
        job.setStatus(updatedJob.getStatus());

        return repository.save(job);
    }
    else{
        return null; // Job not found
    }

    

}
}







