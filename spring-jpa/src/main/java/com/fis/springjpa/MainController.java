package com.fis.springjpa;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/demo")
public class MainController {
	@Autowired
	private UserRepository userRepository;

	@PostMapping(path = "/add") // Map ONLY POST Requests
	public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email) {
		User n = new User();
		n.setName(name);
		n.setEmail(email);
		userRepository.save(n);
		return "Saved";
	}

	@PutMapping
	public String updateUser(@RequestBody User user) {
		Optional<User> p = userRepository.findById(user.getId());
		if (p.isPresent()) {
			userRepository.save(user);
			return "Updated";
		} else {
			return "User Not Found!!";
		}
	}

	@DeleteMapping
	public String deleteUser(@RequestParam int id) {
		Optional<User> p = userRepository.findById(id);
		if (p.isPresent()) {
			userRepository.delete(p.get());
			return "Deleted";
		} else {
			return "User Not Found!!";
		}
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}
}