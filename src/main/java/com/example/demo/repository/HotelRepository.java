package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Hotel;

/**
 * hotelsテーブルを操作するリポジトリ(Dao).
 * 
 * @author okahikari
 *
 */
@Repository
public class HotelRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Hotel> HOTEL_ROW_MAPPER
	= new BeanPropertyRowMapper<>(Hotel.class);
	
	/**
	 * 料金からホテル情報を取得する.
	 * (もし料金が入力されなかったら、全件検索される)
	 * @param price 料金
	 * @return ホテル情報
	 */
	public List<Hotel> searchByLessThanPrice(Integer price) {
		if( price != null ) {
			String sql = "SELECT id, area_name, hotel_name, address, nearest_station, price, parking FROM hotels WHERE price <= :price;";
			SqlParameterSource param = new MapSqlParameterSource().addValue("price", price);
			List<Hotel> hotelList = template.query(sql, param, HOTEL_ROW_MAPPER);
			return hotelList;
		} else {
			String sql = "SELECT id, area_name, hotel_name, address, nearest_station, price, parking FROM hotels ORDER BY id;";
			List<Hotel> hotelList = template.query(sql, HOTEL_ROW_MAPPER);
			return hotelList;
		}
	}
}
