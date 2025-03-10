package com.esraa.jobportalbackend.controller;

import com.esraa.jobportalbackend.models.JobModel;
import com.esraa.jobportalbackend.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobController {

    @Autowired
    JobService jobService;


    @GetMapping(path="posts", produces = {"application/json"})
    public List<JobModel> viewAllJobs(){
      return jobService.getAllJobs();
    }

    @GetMapping("jobPost/{id}")
    public JobModel viewJobById(@PathVariable int id){
        return jobService.getJob(id);
    }


    @PostMapping("jobPost/keyword/{keyword}")
    public List<JobModel> searchJobsByKeyword(@PathVariable("keyword") String keyword){

        return jobService.searchJobByKeyword(keyword);
    }



    @PostMapping("jobPost")
    public JobModel addJob(@RequestBody JobModel job){
        jobService.addJob(job);
        return job;
    }

    @PutMapping("jobPost")
    public JobModel updateJob(@RequestBody JobModel job){

        jobService.updateJob(job);
       return jobService.getJob(job.getPostId());

    }

    @DeleteMapping("jobPost/{id}")
    public void deleteJob(@PathVariable int id){
        jobService.deleteJob(id);

    }

    @GetMapping("load")
    public String load(){
        jobService.load();
        return "Load complete.";
    }

}
