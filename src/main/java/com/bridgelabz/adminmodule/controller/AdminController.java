package com.bridgelabz.adminmodule.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.adminmodule.dto.AdminDTO;
import com.bridgelabz.adminmodule.model.AdminModel;
import com.bridgelabz.adminmodule.service.IAdminService;
import com.bridgelabz.adminmodule.util.Response;

/**
 * Purpose:create admin controller
 * @version 4.15.1.RELEASE
 * @author Swasthik KJ
 */

@RestController
@RequestMapping("/adminmodule")
public class AdminController {
	@Autowired
	IAdminService adminService;
	/**
	 * Purpose:add admin
	 */
	@PostMapping("/addAdmin")
	public ResponseEntity<Response> addAdmin(@Valid @RequestBody AdminDTO adminDTO) {
		AdminModel adminModel = adminService.addAdmin(adminDTO);
		Response response = new Response(200, "admin added successfully", adminModel);
		return new ResponseEntity<>(response, HttpStatus.OK);		
	}
	/**
	 * Purpose:update admin
	 */
	@PutMapping("updateAdmin/{id}")
	public ResponseEntity<Response> updateAdmin(@Valid @RequestBody AdminDTO adminDTO, @PathVariable Long id, @RequestHeader String token) {
		AdminModel adminModel = adminService.updateAdmin(adminDTO, id, token);
		Response response = new Response(200, "admin updated successfully", adminModel);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	/**
	 * Purpose:get admin by id
	 */
	@GetMapping("/getAdminData/{id}")
    public ResponseEntity<Response> getAdminById(@PathVariable Long id, @RequestHeader String token) {
		Optional<AdminModel> adminModel = adminService.getAdminById(id, token);
		Response response = new Response(200, "admin fetched by id successfully", adminModel);
		return new ResponseEntity<>(response, HttpStatus.OK);
    }
	/**
	 * Purpose:get all admins
	 */
	@GetMapping("/getAllAdmins")
	public ResponseEntity<Response> getAllAdmins(@RequestHeader String token) {
		List<AdminModel> adminModel = adminService.getAllAdmins(token);
		Response response = new Response(200, "All admins fetched successfully", adminModel);
		return new ResponseEntity<>(response, HttpStatus.OK);	
	}
	/**
	 * Purpose:delete admin
	 */
	@DeleteMapping("deleteAdmin/{id}")
	public ResponseEntity<Response> deleteAdmin(@PathVariable Long id,  @RequestHeader String token) {
		AdminModel adminModel = adminService.deleteAdmin(id, token);
		Response response = new Response(200, "admin deleted successfully", adminModel);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	/**
	 * Purpose:login to generate token
	 * @Param enter email and password
	 */
	@PostMapping("/login")
    public Response login(@RequestParam String emailId, @RequestParam String password) {
        return adminService.login(emailId, password);
    }
	/**
	 * Purpose:reset admin password
	 * @Param email
	 */
	@PostMapping("/resetpassword")
    public Response resetPassword(@RequestParam String emailId) {
        return adminService.resetPassword(emailId);
    }
	/**
	 * Purpose:change admin password
	 * @Param password
	 */
    @PutMapping("/changepassword/{token}")
    public AdminModel changePassword(@PathVariable("token") String token, @RequestParam String password) {
        return adminService.changePassword(token, password);
    }
    
    @GetMapping("/validateuser/{token}")
    public Boolean validateUser(@PathVariable String token) {
    	return adminService.validateUser(token);
    }
}
