package car_mybatis.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import car_mybatis.dto.CarDTO;

public interface CarMapper {
	public List<CarDTO> selectAllCar();

	public int insertCar(CarDTO dto);

	public int updateCar(CarDTO dto1);

	public int deleteCar(String no);

	public List<CarDTO> selectBrandCar(String[] arr);

	public List<Map<String, Object>> selectBrandModelCount();

	public List<CarDTO> selectYearCar(HashMap<String, Integer> map);
}
