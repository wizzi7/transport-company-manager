package BDBT_proj.Controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import BDBT_proj.DAO.AdresyDAO;
import BDBT_proj.DAO.KontrahenciDAO;
import BDBT_proj.DAO.PracownicyDAO;
import BDBT_proj.DAO.TrasyDAO;
import BDBT_proj.DAO.WynagrodzeniaDAO;
import BDBT_proj.Model.Adresy;
import BDBT_proj.Model.Kontrahenci;
import BDBT_proj.Model.Pracownicy;
import BDBT_proj.Model.Trasy;
import BDBT_proj.Model.Wynagrodzenia;

@Controller
public class AppController {
	
	@Autowired
	private PracownicyDAO daoPracownicy;

	@Autowired
	private WynagrodzeniaDAO daoWynagrodzenia;

	@Autowired
	private TrasyDAO daoTrasy;

	@Autowired
	private KontrahenciDAO daoKontrahenci;

	@Autowired
	private AdresyDAO daoAdresy;
	
	//************************ ADMIN **************************//
	//************************ PRACOWNICY **************************//
	@RequestMapping("/admin")
	public String showPracownicy(Model model) {
		List<Pracownicy> listPracownicy = daoPracownicy.list();
		model.addAttribute("listPracownicy", listPracownicy);
		return "/admin";
	}
	
	@RequestMapping("/dodaj-pracownika")
	public String showNewFormPracownicy(Model model) {
		Pracownicy pracownik = new Pracownicy();
		model.addAttribute("pracownik", pracownik);
		Adresy adres = new Adresy();
		model.addAttribute("adres", adres);
		return "dodajPracownika";
	}
	
	@RequestMapping(value = "/zapisz-pracownika", method = RequestMethod.POST)
	public String save(@ModelAttribute("pracownik") Pracownicy pracownik) {
		daoPracownicy.save(pracownik);
		return "redirect:/admin";
	}

	@RequestMapping("/edytuj-pracownika/{nrPracownika}")
	public ModelAndView showEditFormPracownik(@PathVariable(name = "nrPracownika") int nrPracownika) {
		ModelAndView mav = new ModelAndView("edytujPracownika");
		Pracownicy pracownik = daoPracownicy.get(nrPracownika);
		mav.addObject("pracownik", pracownik);
		mav.addObject("/images/profilelogo", 1);
		return mav;
	}
	
	@RequestMapping(value = "/zaktualizuj-pracownika", method = RequestMethod.POST)
	public String zaktualizujPracownika(@ModelAttribute("pracownik") Pracownicy pracownik) {
		daoPracownicy.update(pracownik);
		return "redirect:/admin";
	}
	
	@RequestMapping("/usun-pracownika/{nrPracownika}")
	public String delete(@PathVariable(name = "nrPracownika") int nrPracownika) {
		daoPracownicy.delete(nrPracownika);
		return "redirect:/admin";
	}
	
	//************************ WYNAGRODZENIA **************************//
	@RequestMapping("/admin/wynagrodzenia")
	public String showWynagrodzenia(Model model) {
		List<Pracownicy> listPracownicy = daoPracownicy.list();
		List<Wynagrodzenia> listWynagrodzenia = daoWynagrodzenia.list();
		int len = listPracownicy.size();
		int i = 0;
		boolean appears;
		while(i <= len - 1 ) {
			appears = false;
			for (int j = 0; j < listWynagrodzenia.size(); j++) {
				if (listPracownicy.get(i).getNrPracownika() == listWynagrodzenia.get(j).getNrPracownika()) {
					listPracownicy.remove(i);
					len--;
					appears = true;
					break;
				}
			}
			if(!appears)
				i++;
		}
		model.addAttribute("listPracownicy", listPracownicy);
		model.addAttribute("listWynagrodzenia", listWynagrodzenia);
		return "/wynagrodzenia";
	}
	
	@RequestMapping("/admin/wynagrodzenia/dodajWynagrodzenie/{nrPracownika}")
	public String showNewFormWynagrodzenie(@PathVariable(name = "nrPracownika") int nrPracownika, Model model) {
		Wynagrodzenia wynagrodzenie = new Wynagrodzenia();
		wynagrodzenie.setNrPracownika(nrPracownika);
		Pracownicy pracownik = new Pracownicy();
		pracownik = daoPracownicy.get(nrPracownika);
		wynagrodzenie.setImie(pracownik.getImie());
		wynagrodzenie.setNazwisko(pracownik.getNazwisko());
		model.addAttribute("wynagrodzenie", wynagrodzenie);
		model.addAttribute("pracownik", pracownik);
		return "dodajWynagrodzenie";
	}

	@RequestMapping(value = "/zapisz-wynagrodzenie", method = RequestMethod.POST)
	public String saveWynagrodzenie(@ModelAttribute("wynagrodzenie") Wynagrodzenia wynagrodzenie) {
		daoWynagrodzenia.save(wynagrodzenie);
		return "redirect:/admin/wynagrodzenia";
	}

	@RequestMapping("/admin/wynagrodzenia/edytuj-wynagrodzenie/{nrWynagrodzenia}")
	public ModelAndView showEditFormWynagrodzenie(@PathVariable(name = "nrWynagrodzenia") int nrWynagrodzenia) {
		ModelAndView mav = new ModelAndView("edytujWynagrodzenie");
		Wynagrodzenia wynagrodzenie = daoWynagrodzenia.get(nrWynagrodzenia);
		mav.addObject("wynagrodzenie", wynagrodzenie);
		return mav;
	}

	@RequestMapping("/admin/wynagrodzenia/usun-wynagrodzenie/{nrWynagrodzenia}")
	public String deleteW(@PathVariable(name = "nrWynagrodzenia") int nrWynagrodzenia) {
		daoWynagrodzenia.delete(nrWynagrodzenia);
		return "redirect:/admin/wynagrodzenia";
	}

	@RequestMapping(value = "zaktualizuj-wynagrodzenie", method = RequestMethod.POST)
	public String update(@ModelAttribute("wynagrodzenie") Wynagrodzenia wynagrodzenie) {
		daoWynagrodzenia.update(wynagrodzenie);
		return "redirect:/admin/wynagrodzenia";
	}

	
	
	//************************ KONTRAHENCI **************************//
	@RequestMapping("/admin/kontrahenci")
	public String showKontrahenci(Model model) {
		List<Kontrahenci> listKontrahenci = daoKontrahenci.list();
		model.addAttribute("listKontrahenci", listKontrahenci);
		List<Adresy> listAdresy = daoAdresy.list();
		model.addAttribute("listAdresy", listAdresy);
		return "/kontrahenci";
	}

	@RequestMapping(value = "/zapisz-kontrahenta", method = RequestMethod.POST)
	public String saveKontrahenci(@ModelAttribute("kontrahent") Kontrahenci kontrahent) {
		Adresy adres = new Adresy();
		adres.setMiasto(kontrahent.getMiasto());
		adres.setUlica(kontrahent.getUlica());
		adres.setNrLokalu(kontrahent.getNrLokalu());
		adres.setKodPocztowy(kontrahent.getKodPocztowy());
		adres.setKraj(kontrahent.getKraj());
		daoAdresy.save(adres);
		Integer value = daoAdresy.getNextNrAdresu();
		kontrahent.setNrAdresu(value.intValue() - 1);
		daoKontrahenci.save(kontrahent);
		return "redirect:/admin/kontrahenci";
	}

	@RequestMapping("/edytuj-kontrahenta/{nrKontrahenta}&{nrAdresu}")
	public ModelAndView showEditForm3(@PathVariable(name = "nrKontrahenta") int nrKontrahenta,
			@PathVariable(name = "nrAdresu") int nrAdresu) {
		ModelAndView mav = new ModelAndView("edytujKontrahenta");
		Kontrahenci kontrahent = daoKontrahenci.get(nrKontrahenta);
		Adresy adres = daoAdresy.get(nrAdresu);
		mav.addObject("kontrahent", kontrahent);
		mav.addObject("adres", adres);
		mav.addObject("/images/profilelogo", 1);
		return mav;
	}

	@RequestMapping(value = "/zaktualizuj-kontrahenta", method = RequestMethod.POST)
	public String updateKontrahenci(@ModelAttribute("kontrahent") Kontrahenci kontrahent) {
		daoKontrahenci.update(kontrahent);
		Kontrahenci kontr = daoKontrahenci.get(kontrahent.getNrKontrahenta());
		Adresy adres = new Adresy(kontr.getNrAdresu(), kontrahent.getMiasto(), kontrahent.getUlica(),
				kontrahent.getNrLokalu(), kontrahent.getKodPocztowy(), kontrahent.getKraj());
		daoAdresy.update(adres);
		return "redirect:/admin/kontrahenci";
	}

	@RequestMapping("/usun-kontrahenta/{nrKontrahenta}")
	public String deleteKontrahenci(@PathVariable(name = "nrKontrahenta") int nrKontrahenta) {
		Kontrahenci kontr = daoKontrahenci.get(nrKontrahenta);
		int nrAdresu = kontr.getNrAdresu();
		daoKontrahenci.updateToNull(kontr);
		daoKontrahenci.delete(nrKontrahenta);
		daoAdresy.delete(nrAdresu);
		return "redirect:/admin/kontrahenci";
	}

	@RequestMapping("/dodaj-kontrahenta")
	public String showNewForm2(Model model) {
		Kontrahenci kontrahent = new Kontrahenci();
		model.addAttribute("kontrahent", kontrahent);
		Adresy adres = new Adresy();
		model.addAttribute("adres", adres);
		return "dodajKontrahenta";
	}
	
	//************************ KIEROWCA **************************//
	@RequestMapping("/edytuj-swoje-dane/{nrPracownika}")
	public ModelAndView showEditForm2(@PathVariable(name = "nrPracownika") int nrPracownika) {
		ModelAndView mav = new ModelAndView("edytujPracownikaK");
		Pracownicy pracownik = daoPracownicy.get(nrPracownika);
		mav.addObject("pracownik", pracownik);
		mav.addObject("/images/profilelogo", 1);
		return mav;
	}

	@RequestMapping(value = "/zaktualizuj-pracownikaK", method = RequestMethod.POST)
	public String updatePracownicyK(@ModelAttribute("pracownik") Pracownicy pracownik) {
		daoPracownicy.update(pracownik);
		return "redirect:/kierowca";
	}

	@RequestMapping("/kierowca")
	public String showKierPracownicy(Model model) {

		List<Pracownicy> listPracownicy = daoPracownicy.list();
		List<Pracownicy> listPracownicy2 = new ArrayList<>();
		for (Pracownicy pracownik : listPracownicy) {
			if (pracownik.getNrPracownika() == 5)
				listPracownicy2.add(pracownik);
		}
		model.addAttribute("listPracownicy", listPracownicy2);
		return "/kierowca";
	}

	@RequestMapping("/kierowca/wynagrodzenie")
	public String showKierWyn(Model model) {
		List<Wynagrodzenia> listWynagrodzenia = daoWynagrodzenia.list();
		List<Wynagrodzenia> listWynagrodzenia2 = new ArrayList<>();
		for (Wynagrodzenia wynagrodzenie : listWynagrodzenia) {
			if (wynagrodzenie.getNrPracownika() == 5)
				listWynagrodzenia2.add(wynagrodzenie);
		}
		model.addAttribute("listWynagrodzenia", listWynagrodzenia2);
		return "/wynagrodzenie";
	}

	// Trasy - kierowca

	@RequestMapping("/kierowca/trasy")
	public String showKierTrasy(Model model) {
		List<Trasy> listTrasy = daoTrasy.list();
		List<Trasy> listTrasy2 = new ArrayList<>();
		for (Trasy trasa : listTrasy) {
			if (trasa.getNrPracownika() == 5)
				listTrasy2.add(trasa);
		}
		model.addAttribute("listTrasy", listTrasy2);
		return "/trasy";
	}

	// INNE

	@RequestMapping("/500")
	public String accessDenied() {
		return "pusta";
	}

	@RequestMapping("/kontakt")
	public String showKontakt(Model model) {
		return "/kontakt";
	}

	@RequestMapping("/onas")
	public String showONas(Model model) {
		return "/onas";
	}
}
