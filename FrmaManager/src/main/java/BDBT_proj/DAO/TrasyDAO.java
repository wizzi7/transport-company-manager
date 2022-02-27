package BDBT_proj.DAO;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import BDBT_proj.Model.Trasy;
import BDBT_proj.Model.Wynagrodzenia;

@Repository
public class TrasyDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// Constructor for JdbcTemplate
	public TrasyDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	// Lista zawierajaca informacje z bazy danych
	public List<Trasy> list() {
		String sql = "select * from Trasy";
		List<Trasy> listTrasy = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Trasy.class));
		return listTrasy;
	}

	// Insert - Wstawiwanie nowego wiersza do bazy
	public void save(Wynagrodzenia wynagrodzenie) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("pracownicy_wynagrodzenia").usingColumns("NR_WYNAGRODZENIA", "NR_PRACOWNIKA","IMIE", "NAZWISKO", "KWOTA_PODSTAWOWA","KWOTA_DODATKOWA");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(wynagrodzenie);
		insertActor.execute(param);
	}

	// Read - odczytywanie danych z bazy
	public Trasy get(int nrPracownika) {
		Object[] args = {nrPracownika};
		String sql = "SELECT * FROM trasy WHERE NR_PRACOWNIKA = " + args[0];
		Trasy trasa = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Trasy.class));
		return trasa;
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
	public void delete(int nrPracownika) {
		String sql = "DELETE FROM Pracownicy WHERE NR_PRACOWNIKA = ?";
		jdbcTemplate.update(sql, nrPracownika);
	}
}

