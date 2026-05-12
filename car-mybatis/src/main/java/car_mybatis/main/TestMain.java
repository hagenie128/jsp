package car_mybatis.main;

import java.util.List;
import java.util.Map;

import car_mybatis.config.DBManager;
import car_mybatis.dto.CarDTO;
import car_mybatis.mapper.CarMapper;

public class TestMain {
	public static void main(String[] args) {
		CarMapper mapper = DBManager.getInstance().getSession().getMapper(CarMapper.class);

		// 전체 조회
		List<CarDTO> list = mapper.selectAllCar();
		for (CarDTO dto : list) {
			System.out.println(dto);
		}
		System.out.println("전체 조회 완료");
		// 추가
		CarDTO dto = new CarDTO(500, "현대", "제네시스", 2026, 14000, 86000000, "2026-01-01 12:12:12");
		int count = mapper.insertCar(dto);
		System.out.println("결과 : " + count);
		System.out.println("추가 완료");

		// 수정
		CarDTO dto1 = new CarDTO(500, "현대", "제네시스 g80", 2026, 14000, 86000000, "2026-01-01 12:12:12");
		count = mapper.updateCar(dto1);
		System.out.println("결과 : " + count);
		System.out.println("수정 완료");
		
		// 삭제
		int no = 500;
		count = mapper.deleteCar(no);
		System.out.println("결과 : " + count);
		System.out.println("삭제 완료");

		// 제조사명으로 검색
		String brand = "Kia";
		list = mapper.selectForBrand(brand);
		for (CarDTO dto2 : list) {
			System.out.println(dto2);
		}
		System.out.println("제조사명 조회 완료");

		// 제조사별 자동차 모델 개수
		System.out.println("제조사별 모델 개수 조회 완료");

		// 2022~2025 자동차 데이터 조회
		System.out.println("2022~2025 자동차 데이터 조회 완료");

	}
}
