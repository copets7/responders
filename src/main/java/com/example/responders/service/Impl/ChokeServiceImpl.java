package com.example.responders.service.Impl;

import com.example.responders.dto.ChokeDTO;
import com.example.responders.models.Choke;
import com.example.responders.repository.ChokeRepository;
import com.example.responders.service.ChokeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChokeServiceImpl implements ChokeService {

    private final ChokeRepository chokeRepository;

    public ChokeServiceImpl(ChokeRepository chokeRepository) {
        this.chokeRepository = chokeRepository;
    }


    @Override
    public boolean save(ChokeDTO chokeDTO) {
        return false;
    }

    @Override
    public void save(Choke choke) {
    chokeRepository.save(choke);
    }

    @Override
    public List<ChokeDTO> getAll() {
        return chokeRepository.findAll().
                stream().map(this::toDto).
                collect(Collectors.toList());
    }

    @Override
    public Choke findByName(String name) {
        return null;
    }

    @Override
    public void updateProfile(ChokeDTO chokeDTO) {

    }

    private ChokeDTO toDto(Choke choke){
     return new ChokeDTO(choke.getAmount());
    }
}
