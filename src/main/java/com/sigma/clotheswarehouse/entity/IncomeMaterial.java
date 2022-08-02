package com.sigma.clotheswarehouse.entity;

import com.sigma.clotheswarehouse.entity.template.AbsUUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class IncomeMaterial extends AbsUUID {

    @ManyToOne
    private Material material;

    private Timestamp incomeDate;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private double price;

    @ManyToOne
    private Measurement measurement;
}
