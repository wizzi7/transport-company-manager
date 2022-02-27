package BDBT_proj.DAO;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import BDBT_proj.Model.Pracownicy;

@Repository
public class PracownicyDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// Constructor for JdbcTemplate
	public PracownicyDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	// Lista zawierajaca informacje z bazy danych
	public List<Pracownicy> list() {
		String sql = "SELECT * FROM PRACOWNICY";
		List<Pracownicy> listPracownicy = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Pracownicy.class));
		return listPracownicy;
	}

	// Insert - Wstawiwanie nowego wiersza do bazy
	public void save(Pracownicy pracownik) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("pracownicy").usingColumns("NR_PRACOWNIKA", "IMIE", "NAZWISKO", "NARODOWOSC","PESEL", "NR_TELEFONU",
				"PLEC");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownik);
		insertActor.execute(param);
	}

	// Read - odczytywanie danych z bazy
	public Pracownicy get(int nrPracownika) {
		Object[] args = {nrPracownika};
		String sql = "SELECT * FROM Pracownicy WHERE NR_PRACOWNIKA = " + args[0];
		Pracownicy pracownik = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Pracownicy.class));
		return pracownik;
	}

	// Update - aktualizacja danych
	public void update(Pracownicy pracownik) {
		String sql = "UPDATE Pracownicy SET IMIE=:imie, NAZWISKO=:nazwisko, NARODOWOSC=:narodowosc,PLEC=:plec, "
				+ "NR_TELEFONU=:nrTelefonu, PESEl=:pesel WHERE Nr_PRACOWNIKA=:nrPracownika";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownik);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql,  param);
		}

	// Delete - usuniecie wybranych rekordow z danymi id
	public void delete(int nrPracownika) {
		String sql = "DELETE FROM Pracownicy WHERE NR_PRACOWNIKA = ?";
		jdbcTemplate.update(sql, nrPracownika);
	}
}

