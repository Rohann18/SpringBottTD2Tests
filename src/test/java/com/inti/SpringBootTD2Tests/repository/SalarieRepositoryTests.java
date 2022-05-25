package com.inti.SpringBootTD2Tests.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.inti.SpringBootTD2Tests.model.Salarie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SalarieRepositoryTests {

	@Autowired
	SalarieRepository salarieRepository;
	
	Salarie salarie, salarie2;
	
	@BeforeEach
	public void setUp() {
		salarie = new Salarie();
		salarie2 = new Salarie("Toto","Titi","titi.toto@test.fr");
	}
	
	@Test
	public void testSaveSalarie() {
		//Given
		
		//When
		Salarie savedSalarie = salarieRepository.save(salarie2);
		
		//Then
		assertThat(savedSalarie).isNotNull();
		assertThat(savedSalarie.getId()).isGreaterThan(1);
	}
	
	@Test
	public void testReadSalarie() {
		//Given

		//When
		Salarie readSalarie = salarieRepository.getReferenceById(4);
		//Then
		assertThat(readSalarie).isNotNull();
		assertThat(readSalarie.getId()).isEqualTo(4);
		assertThat(readSalarie.getNom()).isEqualTo("Haire");
		assertThat(readSalarie.getPrenom()).isEqualTo("Axel");
		assertThat(readSalarie.getEmail()).isEqualTo("axel.haire@test.fr");
	}
	
	@Test
	public void testAllReadSalarie() {
		//Given
		List<Salarie> listSalarie = new ArrayList<Salarie>();
		//When
		listSalarie = salarieRepository.findAll();
		//Then
		assertThat(listSalarie).isNotNull();
		assertThat(listSalarie).hasSize((int) salarieRepository.count());
		assertThat(listSalarie.get(0).getClass()).hasSameClassAs(Salarie.class);
	}
	
	@Test
	public void testUpdateSalarie() {
		//Given
		Salarie s1 = salarieRepository.getReferenceById(5);
		//When
		s1.setNom("Jument");
		Salarie s = salarieRepository.save(s1);
		//Then
		assertThat(s).isNotNull();
		assertThat(s.getNom()).isEqualTo("Jument");
		
	}
	
	@Test
	public void testDeleteSalarie() {
		//Given
		int id = 4;
		//When
		salarieRepository.deleteById(id);
		//Then
		assertThat(salarieRepository.existsById(id)).isFalse();
	}
}
