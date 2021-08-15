package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Team;
import com.example.demo.repository.TeamRepository;

/**
 * 野球チーム関連機能の業務処理を行うサービス.
 * 
 * @author okahikari
 *
 */
@Service
@Transactional
public class TeamService {
	
	@Autowired
	private TeamRepository teamRepository;
	
	/**
	 * 野球チーム情報を全件取得する.
	 * @return 全野球チーム情報
	 */
	public List<Team> showList(){
		List<Team> teamList = teamRepository.findAll();
		return teamList;
	}
	
	/**
	 * 野球チーム情報を取得する.
	 * @param id ID
	 * @return 取得した野球チーム情報
	 */
	public Team showDetail(Integer id) {
		Team team = teamRepository.load(id);
		return team;
	}
}
