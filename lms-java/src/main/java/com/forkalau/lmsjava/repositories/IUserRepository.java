package com.forkalau.lmsjava.repositories;


import com.forkalau.lmsjava.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends CrudRepository<User, Long> {

    User findByBarcode(String barcode);
    @Override
    List<User> findAll();
}
