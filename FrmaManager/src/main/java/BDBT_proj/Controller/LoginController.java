package BDBT_proj.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import BDBT_proj.DAO.UzytkownicyDAO;
import BDBT_proj.Model.Uzytkownicy;


@Controller
public class LoginController {

	@Autowired
	private UzytkownicyDAO dao;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Uzytkownicy> listUzytkownicy = dao.list();
		model.addAttribute("listUzytkownicy", listUzytkownicy);
		return "index";
	}
	
	@RequestMapping("/default")
	public String defaultAfterLogin(HttpServletRequest request) {
		if (request.isUserInRole("ROLE_ADMIN")) {
			return "redirect:/admin";
		} else if (request.isUserInRole("ROLE_KIEROWCA")) {
			return "redirect:/kierowca";
		}
		return "redirect:/pusta";
	}
}
