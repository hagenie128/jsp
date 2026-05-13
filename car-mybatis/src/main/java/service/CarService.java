package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.PersistenceException;

import car_mybatis.config.DBManager;
import car_mybatis.dto.CarDTO;
import car_mybatis.mapper.CarMapper;

public class CarService {
	private static CarService instance = new CarService();
	private CarMapper mapper;
	
	private CarService() {	
		mapper = DBManager.getInstance().openSession().getMapper(CarMapper.class);		
	}
	
	public static CarService getInstance() {
		if(instance == null)
			instance = new CarService();
		return instance;
	}
	
	public List<CarDTO> selectAllCar() {
		return mapper.selectAllCar();
	}

	public int insertCar(CarDTO newCar) throws PersistenceException{
		return mapper.insertCar(newCar);
	}

	public int deleteCar(String no) {
		return mapper.deleteCar(no);
	}

	public int updateCar(CarDTO newCar) {
		return mapper.updateCar(newCar);
	}

	public List<CarDTO> selectBrandCar(String[] arr) {
		return mapper.selectBrandCar(arr);
	}

	public List<Map<String, Object>> selectBrandModelCount() {
		return mapper.selectBrandModelCount();
	}

	public List<CarDTO> selectYearCar(HashMap<String, Integer> map) {
		return mapper.selectYearCar(map);
	}


}