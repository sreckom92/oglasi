package com.srecko.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srecko.projekat.domain.Proizvod;

public interface ProizvodRepository extends JpaRepository<Proizvod, Long>{

}
