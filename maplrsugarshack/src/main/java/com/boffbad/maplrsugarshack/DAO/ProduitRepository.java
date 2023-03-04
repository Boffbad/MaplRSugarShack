package com.boffbad.maplrsugarshack.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.boffbad.maplrsugarshack.model.Produit;
import com.boffbad.maplrsugarshack.model.TypeSirop;

public interface ProduitRepository extends CrudRepository<Produit, Integer>{

	List<Produit> findAllByTypeSirop(TypeSirop typeSirop);

}
