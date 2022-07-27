package com.example.responders.service;

import com.example.responders.dto.BatteryDTO;
import com.example.responders.models.Battery;


import java.util.List;

public interface BatteryService {

    boolean save(BatteryDTO batteryDTO);
    void save(Battery battery);
    List<BatteryDTO> getAll();
    Battery findByName(String name);
    void updateProfile(BatteryDTO batteryDTO);
}
