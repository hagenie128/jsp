package car_mybatis.dto;

public class CarDTO {
	private String carId;
	private String brand;
	private String model;
	private int year;
	private int mileage;
	private int price;
	private String registeredAt;
	
	public CarDTO(String carId, String brand, String model, int year, int mileage, int price,
			String registeredAt) {
		this.carId = carId;
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.mileage = mileage;
		this.price = price;
		this.registeredAt = registeredAt;
	}
	public String getCarId() {
		return carId;
	}
	public void setCarId(String carId) {
		this.carId = carId;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMaileage() {
		return mileage;
	}
	public void setMaileage(int maileage) {
		this.mileage = maileage;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getRegisteredAt() {
		return registeredAt;
	}
	public void setRegisteredAt(String registeredAt) {
		this.registeredAt = registeredAt;
	}
	@Override
	public String toString() {
		return "CarDTO [carId=" + carId + ", brand=" + brand + ", model=" + model + ", year=" + year + ", mileage="
				+ mileage + ", price=" + price + ", registeredAt=" + registeredAt + "]";
	}
	
	

	
}
