package car_mybatis.mapper;

import java.util.List;
import java.util.Map;

import car_mybatis.dto.CarDTO;

public interface CarMapper {
	public List<CarDTO> selectAllCar();

	public int insertCar(CarDTO dto);

	public int updateCar(CarDTO dto1);

	public int deleteCar(int no);

	public List<CarDTO> selectForBrand(String brand);

	public List<Map<String, Object>> selectBrandCount();

	public List<CarDTO> selectBetweenYear(int param1, int param2);
}
