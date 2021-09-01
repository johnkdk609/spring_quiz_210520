package com.quiz.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson04.dao.SellerDAO;

@Service
public class SellerBO {

	@Autowired
	private SellerDAO sellerDAO;
	
	public void addSellerAsField(String nickname, String profileImage, double temperature) {
		sellerDAO.insertSellerAsField(nickname, profileImage, temperature);
	}
}
