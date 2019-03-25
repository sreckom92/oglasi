package com.srecko.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srecko.projekat.domain.Korisnik;

public interface KorisniciRepository extends JpaRepository<Korisnik, Long>{

}
