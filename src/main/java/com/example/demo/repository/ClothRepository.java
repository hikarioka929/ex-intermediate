package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Cloth;

/**
 * clothesテーブルを操作するリポジトリ(Dao).
 * 
 * @author okahikari
 *
 */
@Repository
public class ClothRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Cloth> CLOTH_ROW_MAPPER
	= new BeanPropertyRowMapper<>(Cloth.class);
	
	/**
	 * 性別と服の色から服情報を取得する.
	 * (服が存在しない場合はサイズ0件の服一覧を返す)。
	 * @param gender 性別
	 * @param color 服の色
	 * @return 服情報
	 */
	public List<Cloth> searchByColorAndGender(Integer gender, String color){
		String sql = "SELECT id, category, genre, gender, color, price, size FROM clothes WHERE gender = :gender AND color = :color ORDER BY id;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("gender", gender).addValue("color", color);
		List<Cloth> clothList = template.query(sql, param, CLOTH_ROW_MAPPER);
		return clothList;
	}
}
