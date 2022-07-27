package com.example.responders.repository;

import com.example.responders.models.Responder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponderRepository extends JpaRepository<Responder,Long> {
}
