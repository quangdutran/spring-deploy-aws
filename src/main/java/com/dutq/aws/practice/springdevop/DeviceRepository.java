package com.dutq.aws.practice.springdevop;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DeviceRepository extends CrudRepository<Device, Integer> {
    List<Device> findAllById(Iterable<Integer> integers);
    List<Device> findByOnSale(boolean onSale);
}
