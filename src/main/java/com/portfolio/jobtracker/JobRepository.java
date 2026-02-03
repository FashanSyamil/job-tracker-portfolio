package com.portfolio.jobtracker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<JobApplication, Long>{
    // This is really EMPTY
    // by extending JpaRepository, Spring automatically writes the code to save, delete, find data for you
}
