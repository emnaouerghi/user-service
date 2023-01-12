package com.example.demo;

import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {
	
	@Autowired  
	UserService usersService; 

	public UserController( ) {}
	
	@GetMapping("/users")
	List<User> allUsers() {
	  return (List<User>) usersService.getAllUsers();
	}
	@GetMapping("/users/find-user/{user_id}")
	@ResponseBody
	User findUser(@PathVariable("user_id") Long userId) {
	  return usersService.getUser(userId);
	}
	  
	@DeleteMapping("/users/{id}")
	void deleteUser(@PathVariable Long id) {
		usersService.deleteUserById(id); 
}
	
	@PostMapping("/users/add-user")
	@ResponseBody User newUser(@RequestBody User newUser) {
	  return usersService.saveUser(newUser);
	}
	   
	   @PutMapping("/users/{id}")
	    public User updateUser(@PathVariable(value = "id") Long userId, @RequestBody User userDetails)  {
	        User user = usersService.getUser(userId); 
	       if(userDetails.getAdresse()!=null)
	       user.setAdresse(userDetails.getAdresse());
	      if(userDetails.getDateInscri()!=null)
	       user.setDateInscri(userDetails.getDateInscri());
	       if(userDetails.getEmail()!=null)
	       user.setEmail(userDetails.getEmail());
	       if(userDetails.getNom()!=null)
	       user.setNom(userDetails.getNom());
	       if(userDetails.getPrenom()!=null)
	       user.setPrenom(userDetails.getPrenom());
	       if(userDetails.getRole()!=null)
	       user.setRole(userDetails.getRole());
	       
	   
	        final User updatedUser = usersService.saveUser(user);
	        return usersService.updateUser(updatedUser);
	    }
   

}

