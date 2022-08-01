package com.sigma.clotheswarehouse.entity;

import com.sigma.clotheswarehouse.entity.template.AbsUUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OutcomeMaterial extends AbsUUID {

    @ManyToOne
    private Material material;

    @ManyToOne
    private Product product;

    private Double amount;
}
