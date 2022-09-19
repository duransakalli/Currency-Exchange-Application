package com.drn.microservices.currencyexchangeservice;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "currency")
@AllArgsConstructor
@NoArgsConstructor
public class CurrentExchange {

    @NotNull
    @Id
    @Column(nullable = false)
    private Long id;

    @Column(name="valueFrom")
    private String from;

    @Column(name="valueTo")
    private String to;

    private BigDecimal conversionMultiple;
    private String environment;

    public CurrentExchange(Long id, String from, String to, BigDecimal conversionMultiple) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
    }
}
