package com.example.responders.service.Impl;

import com.example.responders.dto.SuperCapacitorDTO;
import com.example.responders.models.SuperCapacitor;
import com.example.responders.repository.SuperCapacitorRepository;
import com.example.responders.service.SuperCapacitorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SuperCapacitorImpl implements SuperCapacitorService {

    private final SuperCapacitorRepository superCapacitorRepository;

    public SuperCapacitorImpl(SuperCapacitorRepository superCapacitorRepository) {
        this.superCapacitorRepository = superCapacitorRepository;
    }

    @Override
    public boolean save(SuperCapacitorDTO capacitorDTO) {
        return false;
    }

    @Override
    public void save(SuperCapacitor capacitor) {
    superCapacitorRepository.save(capacitor);
    }

    @Override
    public List<SuperCapacitorDTO> getAll() {
        System.out.println(superCapacitorRepository.findAll());
       return superCapacitorRepository.findAll().
               stream().map(this::toDto)
               .collect(Collectors.toList());
    }

    @Override
    public SuperCapacitor findByName(String name) {
        return null;
    }

    @Override
    public void updateProfile(SuperCapacitorDTO capacitorDTO) {
    }

    private SuperCapacitorDTO toDto(SuperCapacitor superCapacitor){
        SuperCapacitorDTO superCapacitorDTO = new SuperCapacitorDTO(superCapacitor.getAmount());
        return superCapacitorDTO;
    }
}
