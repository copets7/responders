package com.example.responders.dto;

import java.util.Objects;

public class ChokeDTO {

    private Long amount;

    public ChokeDTO(Long amount) {
        this.amount = amount;
    }

    public ChokeDTO() {
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
        ChokeDTO chokeDTO = (ChokeDTO) o;
        return Objects.equals(amount, chokeDTO.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
