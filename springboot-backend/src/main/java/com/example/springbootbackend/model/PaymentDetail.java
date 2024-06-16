package com.example.springbootbackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "payment_details", schema = "itss")
public class PaymentDetail {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "amount", nullable = false, precision = 10)
    private BigDecimal amount;

    @Column(name = "provider", nullable = false)
    private String provider;

    private String status;

    private Instant createdAt;

    private Instant updatedAt;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    @Column(name = "amount", nullable = false, precision = 10)
    public BigDecimal getAmount() {
        return amount;
    }

    @Column(name = "provider", nullable = false)
    public String getProvider() {
        return provider;
    }

    @ColumnDefault("'pending'")
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    @Column(name = "created_at")
    public Instant getCreatedAt() {
        return createdAt;
    }

    @Column(name = "updated_at")
    public Instant getUpdatedAt() {
        return updatedAt;
    }


}