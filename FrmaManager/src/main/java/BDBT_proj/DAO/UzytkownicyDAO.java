package BDBT_proj.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import BDBT_proj.Model.Uzytkownicy;

@Repository
public class UzytkownicyDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// Constructor for JdbcTemplate
	public UzytkownicyDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	// Lista zawierajaca informacje z bazy danych
	public List<Uzytkownicy> list() {
		String sql = "SELECT * FROM UZYTKOWNICY";
		List<Uzytkownicy> listUzytkownicy = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Uzytkownicy.class));
		return listUzytkownicy;
	}

	// Read - odczytywanie danych z bazy
	public Uzytkownicy get(String login) {
		Object[] args = {login.substring(0,login.length())};
		String sql = "SELECT * FROM UZYTKOWNICY WHERE LOGIN = '" + args[0] + "'";
		Uzytkownicy uzytkownik = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Uzytkownicy.class));
		return uzytkownik;
	}
	
	// Check - sprzawdzanie poprawnosci logowania
		public Uzytkownicy g(String login) {
			Object[] args = {login}; 
			String sql = "SELECT * FROM UZYTKOWNICY WHERE LOGIN = " + args[0];
			Uzytkownicy uzytkownik = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Uzytkownicy.class));
			return uzytkownik;
		}
}
