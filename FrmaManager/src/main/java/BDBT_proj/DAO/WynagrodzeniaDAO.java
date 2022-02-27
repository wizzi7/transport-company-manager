package BDBT_proj.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import BDBT_proj.Model.Wynagrodzenia;

@Repository
public class WynagrodzeniaDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// Constructor for JdbcTemplate
	public WynagrodzeniaDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	// Lista zawierajaca informacje z bazy danych
	public List<Wynagrodzenia> list() {
		String sql = "select * from pracownicy_wynagrodzenia";
		List<Wynagrodzenia> listWynagrodzenia = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Wynagrodzenia.class));
		return listWynagrodzenia;
	}

	// Insert - Wstawiwanie nowego wiersza do bazy
	public void save(Wynagrodzenia wynagrodzenie) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("wynagrodzenia").usingColumns("NR_WYNAGRODZENIA", "KWOTA_PODSTAWOWA", "KWOTA_DODATKOWA", "NR_PRACOWNIKA");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(wynagrodzenie);
		insertActor.execute(param);
	}

	// Read - odczytywanie danych z bazy
	public Wynagrodzenia get(int nrWynagrodzenia) {
		Object[] args = {nrWynagrodzenia};
		String sql = "SELECT * FROM pracownicy_wynagrodzenia WHERE NR_WYNAGRODZENIA = " + args[0];
		Wynagrodzenia wynagrodzenie = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Wynagrodzenia.class));
		return wynagrodzenie;
	}

	// Update - aktualizacja danych
	public void update(Wynagrodzenia wynagrodzenie) {
		String sql = "UPDATE Pracownicy_wynagrodzenia SET KWOTA_PODSTAWOWA=:kwotaPodstawowa,"
				+ " KWOTA_DODATKOWA=:kwotaDodatkowa WHERE Nr_WYNAGRODZENIA=:nrWynagrodzenia";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(wynagrodzenie);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql,  param);
		}

	// Delete - usuniecie wybranych rekordow z danymi id
	public void delete(int nrWynagrodzenia) {
		String sql = "DELETE FROM WYNAGRODZENIA WHERE NR_Wynagrodzenia = ?";
		jdbcTemplate.update(sql, nrWynagrodzenia);
	}
}

