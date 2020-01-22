package com.forkalau.lmsjava.repositories;

import com.forkalau.lmsjava.domain.Loan;
import org.springframework.data.repository.CrudRepository;

public interface ILoanRepository extends CrudRepository<Loan, Long> {
}
