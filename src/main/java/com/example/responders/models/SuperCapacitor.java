package com.example.responders.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "supercapacitor")
public class SuperCapacitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long amount;

    public SuperCapacitor(Long amount) {
        this.amount = amount;
    }

    public SuperCapacitor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        SuperCapacitor that = (SuperCapacitor) o;
        return Objects.equals(id, that.id) && Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount);
    }

    @Override
    public String toString() {
        return "SuperCapacitor{" +
                "amount=" + amount +
                '}';
    }
}
