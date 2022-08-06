package com.sigma.clotheswarehouse.entity;

import com.sigma.clotheswarehouse.entity.template.AbsUUID;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "outcome_material_report")
public class ResourceForOutcomeMaterial extends AbsUUID {

    @ManyToOne
    private Material material;

    private double materialAmount;

}
