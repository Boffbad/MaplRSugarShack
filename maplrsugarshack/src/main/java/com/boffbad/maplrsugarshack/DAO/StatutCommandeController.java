package com.boffbad.maplrsugarshack.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.boffbad.maplrsugarshack.model.StatutCommande;

@RestController
public class StatutCommandeController {

	@Autowired
	StatutCommandeRepository statutCommandeRepository;
	
	@GetMapping("/statutcommandes")
	public List<StatutCommande> getAllStatutCommandes() {
		return (List<StatutCommande>) statutCommandeRepository.findAll();
	}

	@GetMapping("/statutcommande/{nom}")
	public StatutCommande getStatutCommandeByNom(@PathVariable("nom") String nom) {
		return (StatutCommande) statutCommandeRepository.findByNom(nom);
	}
	
}
