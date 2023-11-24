package com.example.demo;

import com.example.demo.business.CadeauService;
import com.example.demo.dao.Cadeau;
import com.example.demo.dao.CadeauRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class CadeauServiceTests {

	@Autowired
	CadeauService cadeauService;

	@Test
	public void testService(){
		Optional<Cadeau> optional = cadeauService.getCadeauById(1);
		if(optional.isPresent()){
			Cadeau cadeau = optional.get();
			System.out.println(cadeau);
		}

	}

}
