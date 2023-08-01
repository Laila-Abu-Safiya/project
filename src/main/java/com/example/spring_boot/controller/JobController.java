package com.example.spring_boot.controller;

import com.example.spring_boot.entity.Job;
import com.example.spring_boot.entity.Machine;
import com.example.spring_boot.exptions.ValidateForExistsUser;
import com.example.spring_boot.service.JobService;
import com.example.spring_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class JobController {

    private final JobService jobService;
    private final UserService userService;

    @Autowired
    public JobController(JobService jobService, UserService userService) {
        this.jobService = jobService;
        this.userService = userService;
    }

    @PostMapping(path = "user/{userId}/job/task")
    public Job addNewMachine(@RequestBody Job job, @PathVariable("userId") int userId) throws Exception {
        boolean exists = userService.checkIfUserExists(userId);
        checkIfUserExists(exists);
        return jobService.addNewJob(job);

    }

    @DeleteMapping(path = "tenant/{userId}/job/task")
    public void deleteTask(@RequestBody int taskId) throws Exception {
        boolean exists = jobService.CheckIfTaskExists(taskId);

        if (exists) {
            jobService.deleteTask(taskId);
        } else {
            throw new Exception("Task is not exists");
        }

    }

    @GetMapping(path = "tenant/{userId}/job/task/{taskId}")
    public Optional<Job> getTaskById(@PathVariable("taskId") int taskId) throws Exception {
        return jobService.getTaskById(taskId);
    }
    public void checkIfUserExists(boolean exists) throws ValidateForExistsUser {
        if (!exists) {
            throw new ValidateForExistsUser("User is not exist");
        }
    }
}
