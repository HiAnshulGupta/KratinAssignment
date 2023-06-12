package com.app.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.Services.DietService;
import com.app.Services.UserService;
import com.app.dto.Diet_dto;
import com.app.dto.Userdto;
import com.app.pojos.Diet_chart;
import com.app.pojos.User;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/User")
public class UserController {

	@Autowired
	private UserService Uservice;
	@Autowired
	private DietService dservice;

	@PostMapping
	public User addUser(@RequestBody Userdto user) {

		return Uservice.AddUser(user);
	}
	
	@GetMapping("/login/{id}")
	public Optional<User> show(@RequestParam("Id") Long Id){
		return Uservice.showUser(Id);
	}

	@PostMapping("/login")
	public ResponseEntity<User> Login(@RequestParam("email") String email, @RequestParam("password") String password) {

		Optional<User> optionalUser = Uservice.findUser(email, password);

		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			
			return ResponseEntity.ok(user);
		} else {
			
			return ResponseEntity.notFound().<User>build();
		}

	}

//	@PostMapping("/Diet")
//	public ResponseEntity<String> addDietData(Authentication auth, @RequestBody Diet_dto dChart) {
//
//		if (auth != null) {
//			String userEm = auth.getUsername();
//			boolean res = Uservice.addDiet(userEm, dChart);
//			if (res) {
//				return ResponseEntity.ok("Diet added");
//			} else {
//				return ResponseEntity.badRequest().body("failed");
//			}
//		}
//		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User  not authenticated");
//	}

	@GetMapping("diet-plan")
	public ResponseEntity<String> getDietPlanByTime(@RequestParam("userID") Long userID, @RequestParam("time") String time) {
		String dplan=dservice.getDietPalnById(userID, time);
		if(dplan!=null) {
			return ResponseEntity.ok(dplan);
		}
		return ResponseEntity.notFound().build();
	}

}
