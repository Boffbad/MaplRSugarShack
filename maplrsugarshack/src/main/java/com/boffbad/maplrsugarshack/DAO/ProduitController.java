package com.boffbad.maplrsugarshack.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.boffbad.maplrsugarshack.model.Produit;
import com.boffbad.maplrsugarshack.model.TypeSirop;

@RestController
public class ProduitController {

	@Autowired
	ProduitRepository produitRepository;
	@Autowired
	TypeSiropRepository typeRepository;
	
	@GetMapping("/produits")
	public List<Produit> getAllProduits() {
		return (List<Produit>) produitRepository.findAll();
	}

	@GetMapping("/produit/{id}")
	public Produit getProduitById(@PathVariable("id") Integer id) {
		return produitRepository.findById(id).get();
	}

	@GetMapping("/produit/type/{type}")
	public List<Produit> getListProduitsByTypeSirop(@PathVariable("type") String type)
	{
		List<Produit> listeProduits= new ArrayList<>();
		TypeSirop typeSirop = typeRepository.findByNom(type);
		listeProduits = produitRepository.findAllByTypeSirop(typeSirop);
		return listeProduits;
	}
	
}
