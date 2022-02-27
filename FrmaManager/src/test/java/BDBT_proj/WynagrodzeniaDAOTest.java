package BDBT_proj;

import static org.junit.jupiter.api.Assertions.*;


import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import BDBT_proj.DAO.WynagrodzeniaDAO;
import BDBT_proj.Model.Wynagrodzenia;

class WynagrodzeniaDAOTest {

	private WynagrodzeniaDAO dao;
	
	@BeforeEach
	void setUp() throws Exception {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setUrl("jdbc:oracle:thin:@127.0.0.1:1522:ORCL2");
		datasource.setUsername("DSTEFANO");
		datasource.setPassword("password");
		datasource.setDriverClassName("oracle.jdbc.OracleDriver");
		dao = new WynagrodzeniaDAO(new JdbcTemplate(datasource));
	}

	@Test
	void testList() {
		List<Wynagrodzenia> listWynagrodzenia = dao.list();
		assertTrue(!listWynagrodzenia.isEmpty());
	}

	
	@Test
	void testSave() {
		Wynagrodzenia wyn = new Wynagrodzenia(10, 162 ,21,6);
		dao.save(wyn);
	}

	@Test
	void testGet() {
		Wynagrodzenia wyn = dao.get(157);
		assertNotNull(wyn);
	}

	@Test
	void testUpdate() {
		Wynagrodzenia wyn = new Wynagrodzenia();
		wyn.setNrWynagrodzenia(23);
		wyn.setImie("Szymon");
		wyn.setNazwisko("Stefan");
		wyn.setKwotaPodstawowa(0);
		wyn.setKwotaDodatkowa(0);
		dao.update(wyn);
	}

	@Test
	void testDelete() {
		dao.delete(81);
	}
}
