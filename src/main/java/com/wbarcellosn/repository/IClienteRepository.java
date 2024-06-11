package com.wbarcellosn.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wbarcellosn.entities.Cliente;

@Repository
public interface IClienteRepository extends CrudRepository<Cliente, Long>{

}
