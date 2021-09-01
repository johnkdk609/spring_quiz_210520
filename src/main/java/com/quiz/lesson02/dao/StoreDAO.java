package com.quiz.lesson02.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quiz.lesson02.model.Store;

@Repository
public interface StoreDAO {

	// Too many result => 쿠리의 결과는 여러 행인데 리턴되는 타입은 단건이다. (Error)
	public List<Store> selectStoreList();
	
}
