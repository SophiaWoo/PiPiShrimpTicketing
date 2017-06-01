package com.ppshrimp.filmsystem.persistence.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ppshrimp.filmsystem.persistence.dao.CinemaDao;
import com.ppshrimp.filmsystem.persistence.entity.Cinema;
import com.ppshrimp.filmsystem.persistence.entity.CinemaMoviePos;


@Service("cinemaService")
@Transactional
public class CinemaService {
	@Autowired
	private CinemaDao cinemaDao;
	
	// 获取所有Cinemas
	public List<Cinema> getAllCinema() {
		return cinemaDao.getAll();
	}
	
	// 根据用户城市查找电影院
	public List<Cinema> getCinemasByAddr(String city) {
		return cinemaDao.getByAddr(city);
	}
	
	// TODO 查找用户附近电影院GPS
	
	// 查找某电影有余票的
	public List<CinemaMoviePos> getMoviesByCinemaId(long id) {
		return cinemaDao.getById(id);
	}
}