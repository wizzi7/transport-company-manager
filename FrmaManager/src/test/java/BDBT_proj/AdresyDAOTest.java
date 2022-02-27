package BDBT_proj;

import static org.junit.jupiter.api.Assertions.*;


import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import BDBT_proj.DAO.AdresyDAO;
import BDBT_proj.Model.Adresy;

class AdresyDAOTest {

	private AdresyDAO dao;
	
	@BeforeEach
	void setUp() throws Exception {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setUrl("jdbc:oracle:thin:@127.0.0.1:1522:ORCL2");
		datasource.setUsername("DSTEFANO");
		datasource.setPassword("password");
		datasource.setDriverClassName("oracle.jdbc.OracleDriver");
		dao = new AdresyDAO(new JdbcTemplate(datasource));
	}

	@Test
	void testList() {
		List<Adresy> listAdresy = dao.list();
		assertTrue(!listAdresy.isEmpty());
	}

	
	@Test
	void testSave() {
		Adresy adres = new Adresy(100, "Warszawa", "Moja", "10/51", "00-987", "Polska");
		dao.save(adres);
	}

	@Test
	void testGet() {
		int id = 7;
		Adresy adres = dao.get(id);
		assertNotNull(adres);
	}

	@Test
	void testUpdate() {
		Adresy adres = new Adresy();
		adres.setNrAdresu(7);
		adres.setMiasto("Warszawaaa");
		adres.setUlica("Krzywolka");
		adres.setNrLokalu("37e");
		adres.setKodPocztowy("09-987");
		adres.setKraj("Polska");
		dao.update(adres);
	}

	@Test
	void testDelete() {
		int nrAdresu = 61;
		dao.delete(nrAdresu);
	}
}
