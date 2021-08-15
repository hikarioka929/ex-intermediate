package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Hotel;
import com.example.demo.repository.HotelRepository;

/**
 * ホテル関連機能の業務処理を行うサービス.
 * 
 * @author okahikari
 *
 */
@Service
@Transactional
public class HotelService {
	
	@Autowired
	private HotelRepository hotelRepository;
	
	/**
	 * ホテル情報を取得する.
	 * @param price 料金
	 * @return ホテル情報
	 */
	public List<Hotel> searchByLessThanPrice(Integer price){
		List<Hotel> hotelList = hotelRepository.searchByLessThanPrice(price);
		return hotelList;
	}
}
