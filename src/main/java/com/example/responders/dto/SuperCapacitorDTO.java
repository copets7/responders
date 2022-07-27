package com.example.responders.dto;

import java.util.Objects;

public class SuperCapacitorDTO {

    private Long amount;

    public SuperCapacitorDTO(Long amount) {
        this.amount = amount;
    }

    public SuperCapacitorDTO() {
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
        SuperCapacitorDTO that = (SuperCapacitorDTO) o;
        return Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public String toString() {
        return "SuperCapacitorDTO{" +
                "amount=" + amount +
                '}';
    }
}
