package com.example.responders.service;

import com.example.responders.dto.ChokeDTO;
import com.example.responders.models.Choke;


import java.util.List;

public interface ChokeService {
    boolean save(ChokeDTO chokeDTO);
    void save(Choke choke);
    List<ChokeDTO> getAll();
    Choke findByName(String name);
    void updateProfile(ChokeDTO chokeDTO);
}
