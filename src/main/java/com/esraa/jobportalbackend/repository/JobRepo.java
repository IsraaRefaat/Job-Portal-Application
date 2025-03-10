package com.esraa.jobportalbackend.repository;

import com.esraa.jobportalbackend.models.JobModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<JobModel, Integer> {




    List<JobModel> findByPostProfileContainingOrPostDescContaining(String PostProfile, String PostDesc);
}



// ArrayList to store JobPost objects
//List<JobModel> jobs = new ArrayList<>(Arrays.asList(
//
//        new JobModel(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
//                List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),
//
//
//        new JobModel(2, "Frontend Developer", "Experience in building responsive web applications using React", 3,
//                List.of("HTML", "CSS", "JavaScript", "React")),
//
//
//        new JobModel(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
//                List.of("Python", "Machine Learning", "Data Analysis")),
//
//
//        new JobModel(4, "Network Engineer", "Design and implement computer networks for efficient data communication", 5,
//                List.of("Networking", "Cisco", "Routing", "Switching")),
//
//
//        new JobModel(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android", 3,
//                List.of("iOS Development", "Android Development", "Mobile App"))
//));
//
////method to add a new Job
//public void addJob(JobModel job) {
//    jobs.add(job);
//    System.out.println(jobs);
//}
//
//
////method to fetch all jobs
//public List<JobModel> getAllJobs() {
//    return jobs;
//}
//
//public JobModel getJob(int id) {
//    for (JobModel job : jobs) {
//        if (job.getPostId()==id)
//            return job;
//    }
//    return null;
//}
//
//public JobModel updateJob(JobModel job) {
//    for(JobModel jobModel : jobs){
//        if(jobModel.getPostId()==job.getPostId())
//        {
//            jobModel.setPostProfile(job.getPostProfile());
//            jobModel.setPostDesc(job.getPostDesc());
//            jobModel.setReqExperience(job.getReqExperience());
//            jobModel.setReqExperience(job.getReqExperience());
//
//
//            return jobModel;
//        }
//
//    }
//    return null;
//}
//
//public void deleteJob(int id) {
//    jobs.removeIf(job -> job.getPostId() == id);
//}