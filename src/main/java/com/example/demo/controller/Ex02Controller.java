package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Hotel;
import com.example.demo.service.HotelService;

/**
* ホテル関連機能の処理の制御を行うコントローラ.
* 
* @author okahikari
*
*/
@Controller
@RequestMapping("/ex02")
public class Ex02Controller {
	
	@Autowired
	private HotelService hotelService;
	
	/**
	 * ホテル検索画面を出力する.
	 * @return ホテル検索画面
	 */
	@RequestMapping("")
	public String index() {
		return "ex02/search";
	}
	
	/**
	 * 入力された料金以下のホテルを出力する.
	 * @param price 料金
	 * @param model requestスコープ
	 * @return 検索結果画面
	 */
	@RequestMapping("/result")
	public String result(Integer price, Model model) {
		List<Hotel> hotelList = hotelService.searchByLessThanPrice(price);
		model.addAttribute("hotelList", hotelList);
		return "ex02/result";
	}
}
