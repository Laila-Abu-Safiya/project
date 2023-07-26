package com.example.trainningspringproject.controller;

import com.example.trainningspringproject.entity.Machine;
import com.example.trainningspringproject.service.JobService;
import com.example.trainningspringproject.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "tenant/machine/device")
public class MachineController {

    private final MachineService machineService;
    private final JobService jobService;
    @Autowired
    public MachineController(MachineService machineService, JobService jobService) {
        this.machineService = machineService;
        this.jobService = jobService;
    }

    @GetMapping
    public List<Machine> getAllMachine(){
        return machineService.listAll();
    }

    @PostMapping
    public void addNewMacines(@RequestBody Machine machine){
        machineService.addNewMachine(machine);
    }

    @DeleteMapping(path = "{id}")
    public void deleteMachine(@PathVariable("id") int id){
        //this method will check if there is any job related and delete it
        jobService.checkIfMachineUsed(id);

        //delete machine
        machineService.deleteMachine(id);

    }

   @PutMapping(path = "{id}")
    public void updateMachineInfo(@PathVariable("id") int id,
                                  @RequestParam(required = false) String Name,
                                  @RequestParam(required = false) String Location){
        machineService.updateMachine(id,Name,Location);
    }
}
