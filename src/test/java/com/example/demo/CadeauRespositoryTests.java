package com.example.demo;

import com.example.demo.dao.Cadeau;
import com.example.demo.dao.CadeauRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CadeauRespositoryTests {

	@Autowired
	CadeauRepository cadeauRepository;

	@Test
	void testSaveCadeau() {
		Cadeau cadeau = new Cadeau("Boite de bonbons","aux chocolat", 2.99f);

		cadeauRepository.save(cadeau);
	}

}
