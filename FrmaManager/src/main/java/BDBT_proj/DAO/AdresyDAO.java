package BDBT_proj.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import BDBT_proj.Model.Adresy;

@Repository
public class AdresyDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// Constructor for JdbcTemplate
	public AdresyDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	// Lista zawierajaca informacje z bazy danych
	public List<Adresy> list() {
		String sql = "SELECT * FROM ADRESY";
		List<Adresy> listAdresy = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Adresy.class));
		return listAdresy;
	}

	// Insert - Wstawiwanie nowego wiersza do bazy
	public void save(Adresy adres) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("adresy").usingColumns("NR_ADRESU", "MIASTO", "ULICA", "NR_LOKALU", "KOD_POCZTOWY", "KRAJ" );
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adres);
		insertActor.execute(param);	
	}

	// Read - odczytywanie danych z bazy
	public Adresy get(int Nr_Adresu) {
		Object[] args = {Nr_Adresu};
		String sql = "SELECT * FROM ADRESY WHERE NR_ADRESU = " + args[0];
		Adresy adres = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Adresy.class));
		return adres;
	}

	// Update - aktualizacja danych
	public void update(Adresy adres) {
		String sql = "UPDATE ADRESY SET MIASTO=:miasto, ULICA=:ulica, NR_LOKALU=:nrLokalu, KOD_POCZTOWY=:kodPocztowy, KRAJ=:kraj WHERE Nr_Adresu=:nrAdresu";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adres);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql,  param);
	}

	// Delete - usuniecie wybranego rekordu z danymi 
	public void delete(int Nr_Adresu) {
		String sql = "DELETE FROM ADRESY WHERE NR_ADRESU = ?";
		jdbcTemplate.update(sql, Nr_Adresu);
	}
	
	public int getNextNrAdresu()
	{
		String sql = "select AdresySeq1.nextval from dual";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
}
