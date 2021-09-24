package com.dutq.aws.practice.springdevop;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Data
@Table(name = "devices")
public class Device {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name="on_sale")
    private boolean onSale;

    public Device() {

    }

    public Device(String name, String description, BigDecimal price, boolean onSale) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.onSale = onSale;
    }
}
