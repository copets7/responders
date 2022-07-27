package com.example.responders.service;

import com.example.responders.dto.ResponderDTO;
import com.example.responders.models.Responder;


import java.util.List;

public interface ResponderService {

    boolean save(ResponderDTO responderDTO);
    void save(Responder responder);
    List<ResponderDTO> getAll();
    Responder findByName(String name);
    void updateProfile(ResponderDTO responderDTO);

    void deleteById(Long id);
}
