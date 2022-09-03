package com.bridgelabz.adminmodule.service;

import java.util.List;
import java.util.Optional;

import com.bridgelabz.adminmodule.dto.AdminDTO;
import com.bridgelabz.adminmodule.model.AdminModel;
import com.bridgelabz.adminmodule.util.Response;

public interface IAdminService {
	AdminModel addAdmin(AdminDTO adminDTO);

	AdminModel updateAdmin(AdminDTO adminDTO, Long id, String token);
	
	AdminModel deleteAdmin(Long id,  String token);

	Response login(String emailId, String password);

	Optional<AdminModel> getAdminById(Long id, String token);

	List<AdminModel> getAllAdmins(String token);

	AdminModel changePassword(String token, String password);

	Response resetPassword(String emailId);
	
}
