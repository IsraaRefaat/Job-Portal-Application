package com.esraa.jobportalbackend.service;

import com.esraa.jobportalbackend.models.JobModel;
import com.esraa.jobportalbackend.repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JobService {

    @Autowired
    JobRepo repo;





    public void addJob(JobModel jobModel) {
        repo.save(jobModel);
    }

    public List<JobModel> getAllJobs() {
        return repo.findAll();
    }

    public JobModel getJob(int id) {
        return repo.findById(id).orElse(null);
    }

    public void updateJob(JobModel job) {
        repo.save(job);
    }

    public void deleteJob(int id) {
        repo.deleteById(id);
    }

    public void load() {
        // ArrayList to store JobPost objects
        List<JobModel> jobs = new ArrayList<>(Arrays.asList(

                new JobModel(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
                        List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),


                new JobModel(2, "Frontend Developer", "Experience in building responsive web applications using React", 3,
                        List.of("HTML", "CSS", "JavaScript", "React")),


                new JobModel(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
                        List.of("Python", "Machine Learning", "Data Analysis")),


                new JobModel(4, "Network Engineer", "Design and implement computer networks for efficient data communication", 5,
                        List.of("Networking", "Cisco", "Routing", "Switching"))
        ));

        repo.saveAll(jobs);
    }

    public List<JobModel> searchJobByKeyword(String keyword) {
        return repo.findByPostProfileContainingOrPostDescContaining(keyword,keyword);
    }

}
