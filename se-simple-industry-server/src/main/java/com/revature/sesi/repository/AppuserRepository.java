package com.revature.sesi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.sesi.model.Appuser;

@Repository("appuserRepository")
public interface AppuserRepository extends JpaRepository<Appuser, Long> {

	Appuser findByEmail(String email);

}
