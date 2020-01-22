package com.forkalau.lmsjava.repositories;


import com.forkalau.lmsjava.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Repository
@Transactional
public interface IUserRepository extends CrudRepository<User, Long> {

    User findByBarcode(String barcode);

    Set<User>  findByBarcodeContainingOrNameContaining(String barcode, String name);
}
