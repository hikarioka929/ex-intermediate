package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Team;
import com.example.demo.service.TeamService;

/**
 * 野球チーム関連機能の処理の制御を行うコントローラ.
 * 
 * @author okahikari
 *
 */
@Controller
@RequestMapping("/ex01")
public class Ex01Controller {
	
	@Autowired
	private TeamService teamService;
	
	/**
	 * 野球チーム一覧を出力する.
	 * @param model requestスコープ
	 * @return 野球チーム一覧画面
	 */
	@RequestMapping("/showList")
	public String showList(Model model) {
		List<Team> teamList = teamService.showList();
		model.addAttribute("teamList", teamList);
		return "ex01/list";
	}
	
	/**
	 * 野球チーム詳細を出力する.
	 * @param id ID
	 * @param model requestスコープ
	 * @return 野球チーム詳細画面
	 */
	@RequestMapping("/showDetail")
	public String showDetail(Integer id, Model model) {
		Team team = teamService.showDetail(id);
		model.addAttribute("team", team);
		return "ex01/detail";
	}
}
