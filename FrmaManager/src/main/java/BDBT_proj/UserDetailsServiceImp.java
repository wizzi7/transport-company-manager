package BDBT_proj;

import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import BDBT_proj.DAO.UzytkownicyDAO;
import BDBT_proj.Model.Uzytkownicy;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

	@Autowired
	private UzytkownicyDAO dao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Uzytkownicy user = findUserbyUsername(username);
		UserBuilder builder = null;
		if (user != null) {
			builder = org.springframework.security.core.userdetails.User.withUsername(username);
			builder.password(new BCryptPasswordEncoder().encode(user.getHaslo()));
			builder.roles(user.getStanowisko());
		} else {
			throw new UsernameNotFoundException("User not found.");
		}
		return builder.build();
	}

	private Uzytkownicy findUserbyUsername(String username) {
		Uzytkownicy user = dao.get(username);
		if (user.getStanowisko().equals("ADMIN")) {
			return new Uzytkownicy(username, user.getHaslo(), "ADMIN");
		}
		if (user.getStanowisko().equals("KIEROWCA")) {
			return new Uzytkownicy(username, user.getHaslo(), "KIEROWCA", user.getNrPracownika());
		}
		return null;
	}
}