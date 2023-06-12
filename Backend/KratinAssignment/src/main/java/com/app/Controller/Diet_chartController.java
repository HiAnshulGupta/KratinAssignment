package com.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Services.DietService;
import com.app.dto.Diet_dto;
import com.app.pojos.Diet_chart;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/Diet")
public class Diet_chartController {
	
	@Autowired
	private DietService Dservice;
	
	
	@GetMapping
	public List<Diet_chart> getDiet() {
		
		return Dservice.getChart();
	}
	
	@PostMapping
	public Diet_chart addChart(@RequestBody Diet_dto ddto) {
		
		return Dservice.addDiet(ddto);
	}

}
