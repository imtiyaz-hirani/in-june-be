package com.springboot.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.main.model.InwardRegister;

public interface InwardRegisterRepository extends JpaRepository<InwardRegister, Integer>{

}
