package com.po.ssais.data.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.po.ssais.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
