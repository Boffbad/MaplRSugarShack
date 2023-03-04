package com.boffbad.maplrsugarshack.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boffbad.maplrsugarshack.model.Commande;
import com.boffbad.maplrsugarshack.model.LigneCommande;
import com.boffbad.maplrsugarshack.model.Produit;
import com.boffbad.maplrsugarshack.model.StatutCommande;

@RestController
@CrossOrigin("*")
public class LigneCommandeController {

	@Autowired
	LigneCommandeRepository ligneCommandeRepository;
	@Autowired
	CommandeRepository commandeRepository;
	@Autowired
	StatutCommandeRepository statutCommandeRepository;

	@GetMapping("/lignecommandes")
	public List<LigneCommande> getAllLigneCommandes() {
		return (List<LigneCommande>) ligneCommandeRepository.findAll();
	}

	@PostMapping("/lignecommande/{produit}/{quantite}")
	public void insertProductInCommande(@PathVariable("produit") Produit produit,
			@PathVariable("quantite") int quantite, @RequestBody Produit p) {
		StatutCommande statutCommande = null;
		statutCommande = statutCommandeRepository.findByNom("En cours");
		Commande cmde = getCurrentCommande();

		if (cmde == null) {
			cmde = new Commande();
			cmde.setStatutCommande(statutCommande);
			cmde = commandeRepository.save(cmde);
		}

		LigneCommande ligneCommande = new LigneCommande();
		ligneCommande.setProduit(produit);
		ligneCommande.setPrixUnitaire(produit.getPrix());
		ligneCommande.setCommande(cmde);
		ligneCommande.setQuantite(quantite);
		ligneCommandeRepository.save(ligneCommande);

	}

	public Commande getCurrentCommande() {
		// get statusCommande "En cours"
		StatutCommande statutCommande = null;
		statutCommande = statutCommandeRepository.findByNom("En cours");
		// check if commande in "En cours" status exists
		Commande cmde = null;
		cmde = commandeRepository.findByStatutCommande(statutCommande);
		return cmde;
	}

	@PutMapping("/lignecommande/{id}/{quantite}")
	public LigneCommande updateLigneCommandeQuantite(@PathVariable("id") int id,
			@PathVariable("quantite") int quantite, @RequestBody LigneCommande ligneCommande) {

		//LigneCommande ligne = ligneCommandeRepository.findById(id).get();

		if (ligneCommande != null) {
			ligneCommande.setQuantite(quantite);
			ligneCommandeRepository.save(ligneCommande);
			return ligneCommande;
		} else {
			return null;
		}
	}

	@DeleteMapping("/lignecommande/{id}")
	public void deleteLigneCommande(@PathVariable("id") int id) {
		ligneCommandeRepository.deleteById(id);
	}

	@GetMapping("/lignecommande/panier/{commande}")
	public List<LigneCommande> getAllLigneCommandeForCommande(@PathVariable("commande") Commande commande) {
		List<LigneCommande> listeLigneCommande;
		listeLigneCommande = ligneCommandeRepository.findAllByCommande(commande);
		return listeLigneCommande;
	}

	@GetMapping("/lignecommande/panier/current")
	public List<LigneCommande> getAllLigneCommandeForCurrentCommande() {
		List<LigneCommande> listeLigneCommande = new ArrayList<LigneCommande>();
		Commande cmde = getCurrentCommande();
		if(cmde != null) {
			listeLigneCommande = ligneCommandeRepository.findAllByCommande(cmde);
		}
		return listeLigneCommande;
	}
}
