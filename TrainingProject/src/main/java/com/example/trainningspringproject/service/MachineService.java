package com.example.trainningspringproject.service;

import com.example.trainningspringproject.entity.Machine;
import com.example.trainningspringproject.repository.MachineRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.annotation.Target;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MachineService {
    @Autowired
    private MachineRepository machineRepositor;

    public List<Machine> listAll(){
        return machineRepositor.findAll();
    }

    public void deleteMachine(int id){
        boolean exists =  machineRepositor.existsById(id);
        if(!exists){
            throw new IllegalStateException("Machine with id"+ id +"is not exists");
        }
        else{
           machineRepositor.deleteById(id);
        }
    }

    public void addNewMachine(Machine machine){
        machineRepositor.save(machine);
    }
@Transactional
   public void updateMachine(int id, String Name, String Location){
        Machine machine = machineRepositor.findById(id).orElseThrow(()-> new IllegalStateException(
                "Machine with id" + id +"does not exists"
        ));
        System.out.println(Name);
        if(Name != null &&
        Name.length() > 0 &&
        !Objects.equals(machine.getName(),Name)){
            machine.setName(Name);
        }

        if(Location != null &&
                Location.length() > 0 &&
                !Objects.equals(machine.getLocation(),Location)){
            machine.setLocation(Location);
        }
    }

}
