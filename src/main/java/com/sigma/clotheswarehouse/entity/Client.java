package com.sigma.clotheswarehouse.entity;

import com.sigma.clotheswarehouse.entity.template.AbsLong;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Client extends AbsLong {

    @Column(nullable = false)
    private String fio;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private boolean deleted;

}