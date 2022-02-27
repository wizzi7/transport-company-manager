package BDBT_proj;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import BDBT_proj.DAO.KontrahenciDAO;
import BDBT_proj.Model.Kontrahenci;

class KontrahenciDAOTest {

	private KontrahenciDAO dao;

	@BeforeEach
	void setUp() throws Exception {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setUrl("jdbc:oracle:thin:@127.0.0.1:1522:ORCL2");
		datasource.setUsername("DSTEFANO");
		datasource.setPassword("password");
		datasource.setDriverClassName("oracle.jdbc.OracleDriver");
		dao = new KontrahenciDAO(new JdbcTemplate(datasource));
	}

	@Test
	void testList() {
		List<Kontrahenci> listKontrahenci = dao.list();
		assertTrue(!listKontrahenci.isEmpty());
	}

	@Test
	void testSave() {
		Kontrahenci kont = new Kontrahenci(1000, "CCC", "ccc@onet.pl", "Warszawa", "Cicha", "42", "02-987", "Polska", 7);
		dao.save(kont);
	}

	@Test
	void testGet() {
		Kontrahenci kont = dao.get(1);
		assertNotNull(kont);
	}

	@Test
	void testUpdate() {
		Kontrahenci kont = new Kontrahenci();
		kont.setNrKontrahenta(7);
		kont.setNazwaKontrahenta("CCC");
		kont.setMiasto("Warszawa");
		kont.setUlica("Cicha");
		kont.setNrLokalu("42");
		kont.setKodPocztowy("02-987");
		kont.setKraj("Polska");
		kont.setNrAdresu(7);
		dao.update(kont);
	}
	
	@Test
	void testUpdateToNull() {
		Kontrahenci kont = dao.get(1);
		dao.updateToNull(kont);
	}

	@Test
	void testDelete() {
		dao.delete(41);
	}
}
