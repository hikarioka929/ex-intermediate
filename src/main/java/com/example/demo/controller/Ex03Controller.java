package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Cloth;
import com.example.demo.service.ClothService;

/**
* 服関連機能の処理の制御を行うコントローラ.
* 
* @author okahikari
*
*/
@Controller
@RequestMapping("/ex03")
public class Ex03Controller {
	
	@Autowired
	private ClothService clothService;
	
	/**
	 * 服検索画面を出力する.
	 * @return 服検索画面
	 */
	@RequestMapping("")
	public String index() {
		return "ex03/search";
	}
	
	/**
	 * 服検索結果画面を出力する.
	 * @param gender 性別
	 * @param color 服の色
	 * @param model requestスコープ
	 * @return 服検索結果画面
	 */
	@RequestMapping("/result")
	public String result(Integer gender, String color, Model model) {
		List<Cloth> clothList = clothService.searchByColorAndGender(gender, color);
		model.addAttribute("clothList", clothList);
		return "ex03/result";
	}
}
