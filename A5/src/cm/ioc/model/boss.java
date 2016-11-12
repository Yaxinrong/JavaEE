package cm.ioc.model;
public class boss {
	  private office office;
	  private car car;
	  
	@Autowired
	 
	public void getBoss(){
		  System.out.println("this boss has the car is red with 001 and in "); 
	  }

	public office getoffice() {
		return office;
	}

	public void setoffice(office office) {
		this.office = office;
	}

	public car getcar() {
		return car;
	}

	public void setcar(car car) {
		this.car = car;
	}
	}
