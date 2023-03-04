package com.boffbad.maplrsugarshack.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.boffbad.maplrsugarshack.model.TypeSirop;

@RestController
@CrossOrigin("*")

public class TypeSiropController {	

	@Autowired
	TypeSiropRepository typeSiropRepository;
	
	@GetMapping("/types")
	public List<TypeSirop> getAllProduits() {
		return (List<TypeSirop>) typeSiropRepository.findAll();
	}

	@GetMapping("/type/{id}")
	public TypeSirop getProduitById(@PathVariable("id") Integer id) {
		return typeSiropRepository.findById(id).get();
	}

	@GetMapping("/type/{nom}")
	public TypeSirop getListTypeSiropByNom(@PathVariable("nom") String nom)
	{
		return typeSiropRepository.findByNom(nom);
	}
	
}
