package com.dutq.aws.practice.springdevop;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringdevopApplicationTests {

	@Autowired
	private DeviceRepository deviceRepository;

	@Test
	void testApp() {
		Device device = new Device("NAME","DESC", new BigDecimal(230.5),true);
		device = deviceRepository.save(device);
		Optional<Device> deviceFound = deviceRepository.findById(device.getId());

		assertTrue(deviceFound.isPresent());
	}

}
