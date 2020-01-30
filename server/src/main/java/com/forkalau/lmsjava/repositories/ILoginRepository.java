package com.forkalau.lmsjava.repositories;

import com.forkalau.lmsjava.domain.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILoginRepository extends CrudRepository<Admin, Long> {

    Admin findByUsername(String username);
    Admin getById(Long id);

}
