package com.app.Services;

import java.util.List;

import com.app.dto.Diet_dto;
import com.app.pojos.Diet_chart;

public interface DietService {
	
	List<Diet_chart> getChart();
	Diet_chart addDiet(Diet_dto diet);
//	String getDietPaln(String time);
	String getDietPalnById(Long userId,String time);

}
