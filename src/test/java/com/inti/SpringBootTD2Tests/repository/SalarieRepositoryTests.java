package com.inti.SpringBootTD2Tests.repository;

import static org.assertj.core.api.Assertions.assertThat;

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
}
