package com.example.CRMProject.Controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.CRMProject.User;
import com.example.CRMProject.UserRepository;


import jakarta.validation.Valid;

@Controller
public class HomeController 
{
	
@Autowired
private UserRepository userRepository;

@GetMapping("/login")
public String showloginForm(User user,BindingResult result) {
	
    return "/html/login";
}
@PostMapping("/login")
 public String loginAuth(@ModelAttribute User user,BindingResult result,Model model) throws Exception {
	System.out.println(user.getName() +user.getPassword());
	User u = userRepository.findByNameAndPassword(user.getName(),user.getPassword());
	if (u == null) {
        model.addAttribute("errorMessage", "Bad credentials");

		  return "/html/login";
	}
	else
		return "/html/index"; 
 }
@GetMapping("/register")
public String showRegisterForm(User user,BindingResult result) {
	
    return "/html/register";
}

@PostMapping("/register")
public String registerUser(@Valid User user, BindingResult result, Model model) {
	 User role = userRepository.findByNameAndPassword("name", "password");
     user.setRole("user");
     userRepository.save(user);
 	System.out.println(user.getName() +user.getPassword() +user.getEmail() +user.getMobNo() +user.getRole() );

//        if (result.hasErrors()) {
//            model.addAttribute("errorMessage", "Bad credentials");
//
//            return "/html/register";
//        }
        userRepository.save(user);
        return "/html/login";
}

	
    @GetMapping("/adduser")
	    public String showSignUpForm(User user) {
	        return "/html/add-user";
	    }
	    
	    @PostMapping("/adduser")
	    public String addUser(@Valid User user, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	        	System.out.println("bad credential");
	            return "/html/add-user";
	        }
	         userRepository.save(user);
	        return "/html/index";
	    }
	    
	   
	    
	    
	    @GetMapping("/index")
	    public String showUserList(Model model) {
        return "/html/index";
	    }
	    
	    @GetMapping("/edit/{id}")
	    public String showUpdateForm(@PathVariable("id") long id, Model model) {
	        User user = userRepository.findById(id)
	          .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	        
	        model.addAttribute("user", user);
	        return "update-user";
	    }
	    
	    @PostMapping("/update/{id}")
	    public String updateUser(@PathVariable("id") long id, @Valid User user, 
	      BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            user.setId(id);
	            return "update-user";
	        }
	            
	        userRepository.save(user);
	        return "redirect:/index";
	    }
	        
	    @GetMapping("/delete/{id}")
	    public String deleteUser(@PathVariable("id") long id, Model model) {
	        User user = userRepository.findById(id)
	          .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	        userRepository.delete(user);
	        return "redirect:/index";
	    }

}
