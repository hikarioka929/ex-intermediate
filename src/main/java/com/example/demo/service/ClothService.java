package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Cloth;
import com.example.demo.repository.ClothRepository;

/**
 * 服関連機能の業務処理を行うサービス.
 * 
 * @author okahikari
 *
 */
@Service
@Transactional
public class ClothService {
	
	@Autowired
	private ClothRepository clothRepository;
	
	/**
	 * 服情報を取得する.
	 * @param gender 性別
	 * @param color 服の色
	 * @return 服情報
	 */
	public List<Cloth> searchByColorAndGender(Integer gender, String color){
		List<Cloth> clothList = clothRepository.searchByColorAndGender(gender, color);
		return clothList;
	}
}
