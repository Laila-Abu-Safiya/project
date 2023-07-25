package com.example.trainningspringproject.service;

import com.example.trainningspringproject.entity.Machine;
import com.example.trainningspringproject.repository.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MachineService {
    @Autowired
    private MachineRepository Repo;

    public List<Machine> listAll(){
        return Repo.findAll();
    }

    public Optional<Machine> listUserMachines(int id) {
        return Repo.findById(id);
    }
    public void delete(int id){
        Repo.deleteById(id);
    }

    public void save(Machine std){
        Repo.save(std);
    }

    public Machine get(int id) {
        return Repo.findById(id).get();
    }
}
