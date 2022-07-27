package com.example.responders.service.Impl;

import com.example.responders.dto.BatteryDTO;
import com.example.responders.models.Battery;
import com.example.responders.repository.BatteryRepository;
import com.example.responders.service.BatteryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BatteryServiceImpl implements BatteryService {

    private final BatteryRepository batteryRepository;

    public BatteryServiceImpl(BatteryRepository batteryRepository){
        this.batteryRepository = batteryRepository;
    }
    @Override
    public boolean save(BatteryDTO batteryDTO) {
        return false;
    }

    @Override
    public void save(Battery battery) {
    batteryRepository.save(battery);
    }

    @Override
    public List<BatteryDTO> getAll() {
        return batteryRepository.
                findAll().stream().
                map(this::toDto).
                collect(Collectors.toList());
    }

    @Override
    public Battery findByName(String name) {
        return null;
    }

    @Override
    public void updateProfile(BatteryDTO batteryDTO) {
    }

    private BatteryDTO toDto(Battery battery){
        BatteryDTO batteryDTO = new BatteryDTO(battery.getAmount());
        return batteryDTO;
    }
}
