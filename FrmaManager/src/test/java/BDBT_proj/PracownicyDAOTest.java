package BDBT_proj;

import static org.junit.jupiter.api.Assertions.*;


import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import BDBT_proj.DAO.PracownicyDAO;
import BDBT_proj.Model.Pracownicy;

class PracownicyDAOTest {

	private PracownicyDAO dao;
	
	@BeforeEach
	void setUp() throws Exception {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setUrl("jdbc:oracle:thin:@127.0.0.1:1522:ORCL2");
		datasource.setUsername("DSTEFANO");
		datasource.setPassword("password");
		datasource.setDriverClassName("oracle.jdbc.OracleDriver");
		dao = new PracownicyDAO(new JdbcTemplate(datasource));
	}

	@Test
	void testList() {
		List<Pracownicy> listPracownicy = dao.list();
		assertTrue(!listPracownicy.isEmpty());
	}

	@Test
	void testSave() {

		Pracownicy prac = new Pracownicy(10, "Damian", "Kowal",  "Polska", "00365987415", "785632015", "M");
		dao.save(prac);
	}

	@Test
	void testGet() {
		Pracownicy pracownik = dao.get(5);
		assertNotNull(pracownik);
	}

	@Test
	void testUpdate() {
		Pracownicy prac = new Pracownicy();
		prac.setImie("Damian");
		prac.setNazwisko("Kowal");
		prac.setNarodowosc("Polska");
		prac.setPlec("M");
		prac.setNrTelefonu("9876545678");
		prac.setPesel("098656896");
		dao.update(prac);
	}

	@Test
	void testDelete() {
		dao.delete(6);
	}
}
