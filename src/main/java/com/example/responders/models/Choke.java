package com.example.responders.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "choke")
public class Choke {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long amount;

    public Choke(Long amount) {
        this.amount = amount;
    }

    public Choke() {
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
        Choke choke = (Choke) o;
        return Objects.equals(id, choke.id) && Objects.equals(amount, choke.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount);
    }
}
