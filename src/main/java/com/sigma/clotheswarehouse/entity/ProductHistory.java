package com.sigma.clotheswarehouse.entity;

import com.sigma.clotheswarehouse.entity.template.AbsUUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ProductHistory extends AbsUUID {
    @ManyToOne
    private Product product;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private double amount;

    @ManyToOne
    private Client client;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp date;
}
