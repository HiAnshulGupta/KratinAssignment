package com.app.Services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Repository.DietRepository;
import com.app.Repository.UserRepository;
import com.app.dto.Diet_dto;
import com.app.pojos.Diet_chart;
import com.app.pojos.User;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

@Service
@Transactional
public class DietServiceImpl implements DietService {

	@Autowired
	private DietRepository DRepo;

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private UserRepository UserRepo;

	@Override
	public List<Diet_chart> getChart() {

		return DRepo.findAll();
	}

	@Override
	public Diet_chart addDiet(Diet_dto diet) {

		Diet_chart dc = mapper.map(diet, Diet_chart.class);

		return DRepo.save(dc);
	}

	@Override
	public String getDietPalnById(Long UserId,String time) {
		
		Optional<User> user=UserRepo.findById(UserId);
		
		if(user.isPresent()) {
			switch (time) {
			case "earlyMorinig(600-700Hrs)":
				return "Tea/Coffee/Green Tea (1 Cup) + Almonds (4) + Walnuts (2)";
			case "breakFast(800-900Hrs)":
				return "\r\n" + "    Vegetable Omelette (1) + Bread (2)\r\n"
						+ "    Dalia with veggies (1 bowl) + skimmed milk (1 glass)\r\n"
						+ "    Poha (1 bowl) + skimmed milk (1 glass)\r\n"
						+ "    Stuffed Roti (vegetable/dal) (2 medium) + raita (1 bowl)\r\n"
						+ "    Cheela (besan/moong dal) (2 medium) + curd (1 bowl)\r\n"
						+ "    Bread (2 slice) + boiled egg white (2)\r\n" + "";
			case "MidMorning (1100Hrs.)":
				return "Fruit (seasonal): 150 – 200gm";
			case "breakFast":
				return "";
			case "Lunch (1300 – 1400Hrs.)":
				return "Roti (2) + Vegetable (1 bowl) + Chicken/Fish (2-3 pcs) + Rice (1 bowl) + Curd (1/2 bowl) + Salad (1 quarter plate)";
			case "Evening (1600 – 1700Hrs.)":
				return "Buttermilk / Lemon Water (1 glass) along with any one of the following items.\r\n" + "\r\n"
						+ "    Roasted peanuts ( 25gm )\r\n" + "    Chicken sausage (3 – 4 pcs )\r\n"
						+ "    Scrambled egg/Poached egg/Boiled egg (2)\r\n" + "    Chicken Salad (1 quarter plate)\r\n"
						+ "";
			case "Dinner (1930 – 2030Hrs.)":
				return "Roti (2)/ Rice (2 bowl) + Vegetable (1 bowl) + Grilled or Roasted Chicken/Fish (2-3 pcs) + Salad (1 quarter plate)";
			case "Bed Time (2130 – 2200Hrs.)":
				return "Milk (Skimmed): 1 Cup";

			default:
				return null;
			}
		}
		else {
			return null;
		}
		
		
	}

}
