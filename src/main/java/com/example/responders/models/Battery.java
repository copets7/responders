package com.example.responders.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "battery")
public class Battery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long amount;

    public Battery(Long amount) {
        this.amount = amount;
    }

    public Battery() {
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
        Battery battery = (Battery) o;
        return Objects.equals(id, battery.id) && Objects.equals(amount, battery.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount);
    }
}
