package com.today.offers.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.today.offers.dto.RoleDTO;
import com.today.offers.dto.UserDTO;
import com.today.offers.model.Role;
import com.today.offers.model.User;
import com.today.offers.repo.RoleRepository;
import com.today.offers.serviceI.UserServiceI;
import com.today.offers.utils.OffersResponse;

@Controller
public class HomeController {
	
	@Autowired
	UserServiceI userServiceI;
	
	@Autowired
	RoleRepository roleRepository;
	
	@ResponseBody
	@GetMapping("/hello")
	public String hi(Model model) {
		/*Role role = new Role();
		User user = new User();
		user.setUserName("test user2");
		user.setPassword("password2");
		List<User> users = new ArrayList<User>();
		users.add(user);
		role.setRoleName("test role2");
		user.setRole(role);
		
		
		role.setUsers(users);*/
		
	//	roleRepository.save(role);
		
		return "hi";
	}
	//testas
	@GetMapping("/")
	public String home() {
	
		return "welcome";
		
	}
	
	
	@GetMapping("/login")
	public String login() {
		
		return "login";
	}
	
	@PostMapping("/login")
	public String submit(@RequestParam String userName,@RequestParam String password) {
		UserDTO userDTO = new UserDTO();
		userDTO.setUserName(userName);
		userDTO.setPassword(password);
		OffersResponse response = userServiceI.getUserByUserNameAndPassword(userDTO);
		if(response.getStatus() == 200) {
			return "home";
		}
		return "login";
	}
	
	
	@GetMapping("/register")
	public String register(Map<String, Object> model) {
	//	List<Role> roles = roleRepository.findAll();
	//	List<String> roleNames = roles.stream().map(Role::getRoleName).collect(Collectors.toList());
		
		List<String> roleNames = new ArrayList<>();
		roleNames.add("customer");
		roleNames.add("user");
		roleNames.add("owner");
		System.out.println(roleNames);
		model.put("roles", roleNames);
		
		return "register";
	}
	
	@PostMapping(value="/signUp", consumes = "application/x-www-form-urlencoded")
	public String signUp(@RequestParam String userName,@RequestParam String password,@RequestParam String role) {
		System.out.println("Inside Method SignUp Harish");
		UserDTO userDTO = new UserDTO();
		userDTO.setUserName(userName);
		userDTO.setPassword(password);
		RoleDTO roleDTO = new RoleDTO();
		roleDTO.setRoleName(role);
		userDTO.setRoleDTO(roleDTO);
		OffersResponse response = userServiceI.saveUser(userDTO);
		System.out.println(response);
		
		if(response.getStatus() == 200) {
			return "login";
		}
	//	model.addAttribute("errMessage", "There is a Problem with register");
		return "register";
	}

}
