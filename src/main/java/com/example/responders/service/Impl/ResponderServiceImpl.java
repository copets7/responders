package com.example.responders.service.Impl;

import com.example.responders.dto.ResponderDTO;
import com.example.responders.models.Responder;
import com.example.responders.models.Role;
import com.example.responders.models.User;
import com.example.responders.repository.ResponderRepository;
import com.example.responders.service.ResponderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ResponderServiceImpl implements ResponderService {

    private final Logger logger = LoggerFactory.getLogger(ResponderServiceImpl.class);
    private final ResponderRepository responderRepository;

    public ResponderServiceImpl(ResponderRepository responderRepository) {
        this.responderRepository = responderRepository;
    }

    @Override
    public boolean save(ResponderDTO responderDTO) {
        logger.info("Creating new responder {}" , responderDTO.getHrTag());
        LocalDateTime localDateTime = LocalDateTime.now();
        Responder responder = new Responder(localDateTime, null, false, responderDTO.getHrTag(), responderDTO.getAdditionalInformation());
        responderRepository.save(responder);
        return true;
    }

    @Override
    public void save(Responder responder) {
        responderRepository.save(responder);
    }

    @Override
    public List<ResponderDTO> getAll() {
        return responderRepository.findAll().
                stream().map(this::toDto).
                collect(Collectors.toList());
    }

    @Override
    public Responder findByName(String name) {
        return null;
    }

    @Override
    public void updateProfile(ResponderDTO responderDTO) {
    }

    @Override
    public void deleteById(Long id) {
        responderRepository.deleteById(id);
    }

    private ResponderDTO toDto(Responder responder) {
        ResponderDTO responderDTO = new ResponderDTO(
                responder.getId(),
                responder.getDateOfReceiptForRepair(),
                responder.getRepairEndDate(),
                responder.isRefurbished(),
                responder.getHrTag(),
                responder.getAdditionalInformation());
        return responderDTO;
    }
}
