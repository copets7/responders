package com.example.responders.repository;

import com.example.responders.models.Battery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatteryRepository extends JpaRepository<Battery,Long> {
}
