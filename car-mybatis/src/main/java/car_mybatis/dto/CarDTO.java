package car_mybatis.dto;

import java.text.DecimalFormat;

public class CarDTO {
	private int car_id;
	private String brand;
	private String model;
	private int year;
	private int maileage;
	private int price;
	private String registered_at;
	
	public CarDTO(int car_id, String brand, String model, int year, int maileage, int price,
			String registered_at) {
		this.car_id = car_id;
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.maileage = maileage;
		this.price = price;
		this.registered_at = registered_at;
	}
	public int getCar_id() {
		return car_id;
	}
	public void setCar_id(int car_id) {
		this.car_id = car_id;
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
		return maileage;
	}
	public void setMaileage(int maileage) {
		this.maileage = maileage;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getRegistered_at() {
		return registered_at;
	}
	public void setRegistered_at(String registered_at) {
		this.registered_at = registered_at;
	}
	@Override
	public String toString() {
		return "CarDTO [car_id=" + car_id + ", brand=" + brand + ", model=" + model + ", year=" + year + ", maileage="
				+ maileage + ", price=" + price + ", registered_at=" + registered_at + "]";
	}
	
	

	
}
