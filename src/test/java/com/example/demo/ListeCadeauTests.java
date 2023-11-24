package com.example.demo;

import com.example.demo.business.CadeauService;
import com.example.demo.dao.Cadeau;
import com.example.demo.dao.CadeauRepository;
import com.example.demo.dao.ListeCadeau;
import com.example.demo.dao.ListeCadeauRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class ListeCadeauTests {

	@Autowired
	CadeauRepository cadeauRepository;

	@Autowired
	ListeCadeauRepository listeCadeauRepository;

	@Test
	public void testListe(){
		Optional<Cadeau> optional1 = cadeauRepository.findById(1);
		Optional<Cadeau> optional2 = cadeauRepository.findById(2);

		if(optional1.isPresent() && optional2.isPresent()){
			Cadeau cadeau1 = optional1.get();
			Cadeau cadeau2 = optional2.get();

			ListeCadeau listeJeanChristophe = new ListeCadeau();
			listeJeanChristophe.setNom("Noel Jean-Christophe");
			listeCadeauRepository.save(listeJeanChristophe);

			cadeau1.setListeCadeau(listeJeanChristophe);
			cadeauRepository.save(cadeau1);

			cadeau2.setListeCadeau(listeJeanChristophe);
			cadeauRepository.save(cadeau2);
		}




	}

}
