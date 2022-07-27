package com.example.responders.service;

import com.example.responders.dto.SuperCapacitorDTO;
import com.example.responders.models.SuperCapacitor;


import java.util.List;

public interface SuperCapacitorService {
    boolean save(SuperCapacitorDTO capacitorDTO);
    void save(SuperCapacitor capacitor);
    List<SuperCapacitorDTO> getAll();
    SuperCapacitor findByName(String name);
    void updateProfile(SuperCapacitorDTO superCapacitorDTO);
}
