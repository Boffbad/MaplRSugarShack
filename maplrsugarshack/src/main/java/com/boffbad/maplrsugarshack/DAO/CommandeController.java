package com.boffbad.maplrsugarshack.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boffbad.maplrsugarshack.model.Commande;
import com.boffbad.maplrsugarshack.model.StatutCommande;

@RestController
public class CommandeController {

	@Autowired
	CommandeRepository commandeRepository;
	@Autowired
	StatutCommandeRepository statutCommandeRepository;
	
	@GetMapping("/commandes")
	public List<Commande> getAllCommandes() {
		return (List<Commande>) commandeRepository.findAll();
	}

	@PutMapping("/commande/valider/{id}")
	public void validerCommande(@PathVariable("id") int id){
		Commande cmde = commandeRepository.findById(id).get();
		
		if(cmde != null) {
			StatutCommande statutCommande = statutCommandeRepository.findByNom("Valide");
			cmde.setStatutCommande(statutCommande);
			commandeRepository.save(cmde);
		}
	}
	
}
