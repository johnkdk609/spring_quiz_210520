package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;
import com.quiz.lesson04.model.Seller;

@RequestMapping("/lesson04")
@Controller
public class SellerController {

	@Autowired
	private SellerBO sellerBO;
	
	// 요청 URL : http://localhost/lesson04/quiz01/1
	@RequestMapping("/quiz01/1")
	public String quiz01_1() {
		return "lesson04/addSeller";
	}
	
	
	// 요청 URL : http://localhost/lesson04/quiz01/add_seller
	@PostMapping("/quiz01/add_seller")
	public String addSeller(
			@RequestParam("nickname") String nickname,
			@RequestParam(value="profileImage", required=false) String profileImage,
			@RequestParam("temperature") double temperature) {
		
		// 데이터들을 DB에 insert
		sellerBO.addSeller(nickname, profileImage, temperature);
		
		return "lesson04/afterAddSeller";
	}
	
	// 요청 URL : http://localhost/lesson04/quiz01/seller_info
	// 요청 URL : http://localhost/lesson04/quiz01/seller_info?id=1
	@RequestMapping("/seller_info")
	public String sellerInfo(
			@RequestParam(value = "id", required=false) Integer id,
			Model model) {
		
		Seller seller = null;
		if (id == null) {
			// select DB -> 가장 최신에 추가된 판매자 정보
			seller = sellerBO.getLatestSeller();			
		} else {
			// select DB -> id에 해당하는 판매자 정보
			seller = sellerBO.getSellerById(id);
		}
		
		model.addAttribute("seller", seller);
		
		return "lesson04/sellerInfo";
	}	
}
