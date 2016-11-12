package cm.ioc.model;

@Component("car")
public class car {
	private String carId="001";
	private String carColor="red";
	
    public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public String getCarColor() {
		return carColor;
	}

	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}

	public String tostring() {
		// TODO Auto-generated method stub
		return "the car is" +carColor+"with" +carId;
		//return null;
	}
}
