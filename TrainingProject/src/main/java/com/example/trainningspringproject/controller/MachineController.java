package com.example.trainningspringproject.controller;

import com.example.trainningspringproject.entity.Machine;
import com.example.trainningspringproject.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(path = "tenant/machine/device")
public class MachineController {

    private final MachineService machineService;
    private static final Logger logger = Logger.getLogger(MachineController.class.getName());

    @Autowired
    public MachineController(MachineService machineService) {
        this.machineService = machineService;
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
        machineService.deleteMachine(id);
    }

   @PutMapping(path = "{id}")
    public void updateMachineInfo(@PathVariable("id") int id,
                                  @RequestParam(required = false) String Name,
                                  @RequestParam(required = false) String Location){
        machineService.updateMachine(id,Name,Location);
    }
}
