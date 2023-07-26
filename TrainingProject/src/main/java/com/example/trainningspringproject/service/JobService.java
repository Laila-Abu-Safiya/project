package com.example.trainningspringproject.service;

import com.example.trainningspringproject.entity.Job;
import com.example.trainningspringproject.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public List<Job> listAllJobs(){
        return jobRepository.findAll();
    }

    public void addNewJob(Job job){
        jobRepository.save(job);
    }

    public void checkIfMachineUsed(int machineid){
        Optional<Job> existsJobs = jobRepository.findJobByMachineId(machineid);
        if(existsJobs.isPresent()){
            System.out.println("acess");
            checkDeleteRelatedJob(existsJobs.get().getTaskid());
        }
    }

    public void checkDeleteRelatedJob(int id){
        jobRepository.deleteById(id);
    }



}
