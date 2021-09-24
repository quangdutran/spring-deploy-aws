package com.dutq.aws.practice.springdevop;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@Builder
public class DeviceDTO {
    private int id;
    private String name;
    private String description;
    private BigDecimal price;
    private boolean onSale;
}
