class VehicleRental {
    private Customer customer;
    private int noOfKms;
    private int journeyDays;

    public VehicleRental(Customer customer, int noOfKms) {
        this.customer = customer;
        this.noOfKms = noOfKms;
        this.journeyDays = 0;
    }

    public int getJourneyDays() {
        return this.journeyDays;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public int identifyJourneyDays() {
        this.journeyDays = this.noOfKms / 300;
        return this.noOfKms % 300;
    }

    public double calculateFinalAmount() {
        return 0.0;
    }
}

class Customer {
    public static String[] memberCustIdArr = {"1001P", "1051R", "1072P", "2019R", "2913R", "2931P"};
    public static int[] memberBillAmountArr = {2050, 5345, 6896, 9100, 4500, 3234};

    private String custId;
    private String custName;

    public Customer(String custId, String custName) {
        this.custId = custId;
        this.custName = custName;
    }

    public String getCustId() {
        return this.custId;
    }
    public String getCustName() {
        return this.custName;
    }

    //To_Trainee
    public float calculateDiscount(float rentalAmount) {
		for(String id : memberCustIdArr){
			if (this.custId.equals(id)) {
				this.upgradeCustomer(rentalAmount);
				char lastChar = this.custId.charAt(this.custId.length() - 1);
				if (lastChar == 'R') {
					return 0.1f * rentalAmount;
				}
				if (lastChar == 'P') {
					return 0.15f * rentalAmount;
				}
			}
		}
        return -1.0f;
    }

    public void upgradeCustomer(float rentalAmount) {
        if (rentalAmount >= 15000) {
            int index = 0;
            for (int ind = 0; ind < Customer.memberCustIdArr.length; ind++) {
                if (Customer.memberCustIdArr[ind].equals(this.custId)) {
                    index = ind;
                    break;
                }
            }
            this.custId = this.custId.substring(0, 4) + "P";
            Customer.memberCustIdArr[index] = this.custId;
        }
    }
}

class CarRental extends VehicleRental {
    private String carType;

    public CarRental(Customer customer, int noOfKms, String carType) {
        super(customer, noOfKms);
        this.carType = carType;
    }

    //To_Trainee
    @Override
    public double calculateFinalAmount() {
		int rentPerDay = CarDetails.identifyPerDayRent(this.carType);
		int excessKms = this.identifyJourneyDays();
		int journeyDays = this.getJourneyDays();
		if (rentPerDay <= 0 || excessKms < 0 || journeyDays < 0){
			return -1.0;
		}
		float rentalAmount = rentPerDay * journeyDays;
		int excessKmsAmount = 12 * excessKms;
		rentalAmount += excessKmsAmount;
		float discountAmount = this.getCustomer().calculateDiscount(rentalAmount);
		if (discountAmount < 0){
			return -1.0;
		}
		double finalAmount = rentalAmount - discountAmount;
		for(int i = 0; i < Customer.memberCustIdArr.length; i++){
			if (Customer.memberCustIdArr[i].equals(this.getCustomer().getCustId())) {
                Customer.memberBillAmountArr[i] += (int) finalAmount;
                break;
            }
        }
        return finalAmount;
    }
}

class CarDetails {
    private static String[] carTypesArr = {"Hatch-back", "Sedan", "SUV"};
    private static int[] perDayRentsArr = {3500, 5000, 6000};

    //To_Trainee
    public static int identifyPerDayRent(String carType) {
        int rentPerDay = 0;
		for(int i = 0; i < carTypesArr.length; i++){
			if (carTypesArr[i].equalsIgnoreCase(carType)){
				return perDayRentsArr[i];
			}
		}
        return -1;
    }
}

class Tester {
    public static void main(String[] args) {
        Customer custObj = new Customer("1051R", "Wilch");

        CarRental carRentalObj = new CarRental(custObj, 10, "SUV");
        for (int ind = 0; ind < Customer.memberCustIdArr.length; ind++) {
            System.out.print(Customer.memberCustIdArr[ind] + ":" + Customer.memberBillAmountArr[ind] + " ");
        }

        System.out.println();

        double finalAmount = carRentalObj.calculateFinalAmount();
        System.out.println("Final bill amount: " + finalAmount);
        for (int ind = 0; ind < Customer.memberCustIdArr.length; ind++) {
            System.out.print(Customer.memberCustIdArr[ind] + ":" + Customer.memberBillAmountArr[ind] + " ");
        }
    }
}
