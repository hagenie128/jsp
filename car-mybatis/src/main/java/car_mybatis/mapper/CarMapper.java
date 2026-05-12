package car_mybatis.mapper;

import java.util.List;

import car_mybatis.dto.CarDTO;

public interface CarMapper {
	public List<CarDTO> selectAllCar();

	public int insertCar();
}
