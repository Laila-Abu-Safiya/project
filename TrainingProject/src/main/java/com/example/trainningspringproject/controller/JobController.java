package com.example.trainningspringproject.controller;

import com.example.trainningspringproject.entity.Job;
import com.example.trainningspringproject.service.JobService;
import com.example.trainningspringproject.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "user/job/task")
public class JobController {

    private final JobService jobService;
    private final MachineService machineService;
    @Autowired
    public JobController(JobService jobService, MachineService machineService) {
        this.jobService = jobService;
        this.machineService = machineService;
    }



    @GetMapping
    public List<Job> getAllJobs(){
        return jobService.listAllJobs();
    }

    @PostMapping
    public void addNewJob(@RequestBody Job job){
        boolean exists = machineService.checkMachineById(job.getMachineid());
        if(exists) {
            jobService.addNewJob(job);
        }
        else {
            throw new IllegalStateException("Machine with id "+ job.getMachineid() +" is not exists");

        }
    }

}
