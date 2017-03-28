package com.girnarsoft.carparking;

public class Parking {

	private Car[][] parking = new Car[4][4];

	public void showParking() {
		Integer slotNumber = 1;
		Boolean isEmpty = true;
		for (int floor = 0; floor < 4; floor++) {
			
			for (int slot = 0; slot < 4; slot++) {
				
				if (parking[floor][slot] != null) {
					isEmpty = false;
					Integer parkingNo = slotNumber + slot;
					System.out.println("Parking No. :" + parkingNo + " | Car Name : "
							+ parking[floor][slot].name + " | Car No. : " + parking[floor][slot].number);
				}
			}
			slotNumber = slotNumber + parking[floor].length;
		}
		if(isEmpty)
		{
			System.out.println("Their is no car avaiable in parking .");
		}
	}
	
	public Boolean exitCarFromParking(Integer parkingNo)
	{
		if(parkingNo != null && parkingNo > 0 && parkingNo <= 16 )
		{
			Integer floor = (parkingNo / this.parking.length) ;
			Integer slot  = (parkingNo % this.parking.length)-1 ;
			if(this.parking[floor][slot]  != null)
			{
				Car car = this.parking[floor][slot];
				System.out.println("Thanks for coming : " + car.number);
				this.parking[floor][slot] = null;
				return true;
			}
			
			else{
				
				System.out.println("oop's their is no car at this parking no , please contact security.");
				return false;
			}
		}
		else{
			
			System.out.println("Please enter valide parking no . ");
			return false;
		}
		
	}
	
	public Integer parkCar(Car car){
		
		Integer slotNumber = 1;
		for (int floor = 0; floor < 4; floor++) {
			
			for (int slot = 0; slot < 4; slot++) {
				
				if (parking[floor][slot] == null) {
					
					Integer emptyParkingNo = slotNumber + slot;
					parking[floor][slot] = car;
					return emptyParkingNo;
					
				}
			}
			
			slotNumber = slotNumber + parking[floor].length;
		}
		
		return null;
	}

}
