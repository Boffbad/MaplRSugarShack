package com.boffbad.maplrsugarshack.DAO;

import org.springframework.data.repository.CrudRepository;

import com.boffbad.maplrsugarshack.model.TypeSirop;

public interface TypeSiropRepository extends CrudRepository<TypeSirop, Integer>{

	TypeSirop findByNom(String type);

}
