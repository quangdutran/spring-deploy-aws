package com.aws.cicd.demo;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "Item")
@Builder
public class Item {
    @GeneratedValue
    @Id
    private UUID uuid;
    private String name;
    private int age;

    public Item() {
    }

    public Item(UUID uuid, String name, int age) {
        this.uuid = uuid;
        this.name = name;
        this.age = age;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
