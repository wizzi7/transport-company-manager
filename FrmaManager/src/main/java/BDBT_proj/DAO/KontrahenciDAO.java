package BDBT_proj.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import BDBT_proj.Model.Kontrahenci;

@Repository
public class KontrahenciDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// Constructor for JdbcTemplate
	public KontrahenciDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	// Lista zawierajaca informacje z bazy danych
	public List<Kontrahenci> list() {
		String sql = "select * from kontr_adresy";
		List<Kontrahenci> listKontrahenci = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Kontrahenci.class));
		return listKontrahenci;
	}

	// Insert - Wstawiwanie nowego wiersza do bazy
	public void save(Kontrahenci kontrahent) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("Kontrahenci").usingColumns("NR_KONTRAHENTA", "NAZWA_KONTRAHENTA", "EMAIL", "NR_ADRESU");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(kontrahent);
		insertActor.execute(param);
		
	}

	// Read - odczytywanie danych z bazy
	public Kontrahenci get(int nrKontrahenta) {
		Object[] args = {nrKontrahenta};
		String sql = "SELECT * FROM kontr_adresy WHERE NR_KONTRAHENTA = " + args[0];
		Kontrahenci kontrahent = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Kontrahenci.class));

		return kontrahent;
	}

	// Update - aktualizacja danych
	public void update(Kontrahenci kontrahent) {
		String sql = "UPDATE Kontrahenci SET NAZWA_KONTRAHENTA=:nazwaKontrahenta, EMAIL=:email WHERE Nr_KONTRAHENTA=:nrKontrahenta";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(kontrahent);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql,  param);
		}
	
	// Update - aktualizacja danych
		public void updateToNull(Kontrahenci kontrahent) {
			String sql = "UPDATE Kontrahenci SET NR_ADRESU=null WHERE Nr_KONTRAHENTA=:nrKontrahenta";
			BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(kontrahent);
			NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
			template.update(sql,  param);
			}

	// Delete - usuniecie wybranych rekordow z danymi id
	public void delete(int nrKontrahenta) {
		String sql = "DELETE FROM KONTRAHENCI WHERE NR_KONTRAHENTA = ?";
		jdbcTemplate.update(sql, nrKontrahenta);
	}
}

