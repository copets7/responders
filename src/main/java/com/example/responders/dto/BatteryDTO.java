package com.example.responders.dto;

import java.util.Objects;

public class BatteryDTO {

    private Long amount;

    public BatteryDTO(Long amount) {
        this.amount = amount;
    }

    public BatteryDTO() {
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BatteryDTO that = (BatteryDTO) o;
        return Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
