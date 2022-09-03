package com.bridgelabz.adminmodule.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.adminmodule.model.AdminModel;
@Repository
public interface AdminRepository extends JpaRepository<AdminModel, Long> {
	Optional<AdminModel> findByEmailId(String emailId);
}
