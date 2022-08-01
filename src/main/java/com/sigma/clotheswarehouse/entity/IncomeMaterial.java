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

    @Column(nullable = false)
    private Timestamp timestamp;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private Double price;

    @ManyToOne
    private Measurement measurement;
}
