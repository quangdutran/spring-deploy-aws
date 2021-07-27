package com.aws.cicd.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("/items")
public class DemoApplication {

	@Autowired
	private ItemRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@PostMapping
	public ItemDTO createItem(@RequestBody ItemDTO item) {
		Item itemAdd = Item.builder().age(item.getAge()).name(item.getName()).build();
		itemAdd = repository.save(itemAdd);
		return ItemDTO.builder().uuid(itemAdd.getUuid()).age(itemAdd.getAge())
				.name(itemAdd.getName()).build();
	}

	@GetMapping
	public long countItem() {
		return repository.count();
	}

}
