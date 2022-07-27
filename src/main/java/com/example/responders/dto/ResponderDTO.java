package com.example.responders.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class ResponderDTO {

    private Long id;
    private LocalDateTime dateOfReceiptForRepair;
    private LocalDateTime repairEndDate;
    private boolean refurbished;
    private String hrTag;
    private String additionalInformation;

    public ResponderDTO(Long id, LocalDateTime dateOfReceiptForRepair,
                        LocalDateTime repairEndDate, boolean refurbished,
                        String hrTag, String additionalInformation) {
        this.id = id;
        this.dateOfReceiptForRepair = dateOfReceiptForRepair;
        this.repairEndDate = repairEndDate;
        this.refurbished = refurbished;
        this.hrTag = hrTag;
        this.additionalInformation = additionalInformation;
    }

    public ResponderDTO() {
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
        ResponderDTO that = (ResponderDTO) o;
        return refurbished == that.refurbished && Objects.equals(dateOfReceiptForRepair, that.dateOfReceiptForRepair) && Objects.equals(repairEndDate, that.repairEndDate) && Objects.equals(hrTag, that.hrTag) && Objects.equals(additionalInformation, that.additionalInformation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateOfReceiptForRepair, repairEndDate, refurbished, hrTag, additionalInformation);
    }
}
