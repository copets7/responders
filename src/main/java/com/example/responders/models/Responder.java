package com.example.responders.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "responders")
public class Responder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateOfReceiptForRepair;
    private LocalDateTime repairEndDate;
    private boolean refurbished;
    private String hrTag;
    private String additionalInformation;


    public Responder(LocalDateTime dateOfReceiptForRepair, LocalDateTime repairEndDate, boolean refurbished, String hrTag, String additionalInformation) {
        this.dateOfReceiptForRepair = dateOfReceiptForRepair;
        this.repairEndDate = repairEndDate;
        this.refurbished = refurbished;
        this.hrTag = hrTag;
        this.additionalInformation = additionalInformation;
    }

    public Responder() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateOfReceiptForRepair() {
        return dateOfReceiptForRepair;
    }

    public void setDateOfReceiptForRepair(LocalDateTime dateOfReceiptForRepair) {
        this.dateOfReceiptForRepair = dateOfReceiptForRepair;
    }

    public LocalDateTime getRepairEndDate() {
        return repairEndDate;
    }

    public void setRepairEndDate(LocalDateTime repairEndDate) {
        this.repairEndDate = repairEndDate;
    }

    public boolean isRefurbished() {
        return refurbished;
    }

    public void setRefurbished(boolean refurbished) {
        this.refurbished = refurbished;
    }

    public String getHrTag() {
        return hrTag;
    }

    public void setHrTag(String hrTag) {
        this.hrTag = hrTag;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Responder responder = (Responder) o;
        return refurbished == responder.refurbished && Objects.equals(id, responder.id) && Objects.equals(dateOfReceiptForRepair, responder.dateOfReceiptForRepair) && Objects.equals(repairEndDate, responder.repairEndDate) && Objects.equals(hrTag, responder.hrTag) && Objects.equals(additionalInformation, responder.additionalInformation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateOfReceiptForRepair, repairEndDate, refurbished, hrTag, additionalInformation);
    }
}
