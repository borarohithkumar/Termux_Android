import java.util.Arrays;

class BuildingForRent {
    private int buildingDimensions;
    private float advanceAmount;

    public BuildingForRent(int buildingDimensions) {
        this.buildingDimensions = buildingDimensions;
    }

    public float getAdvanceAmount() {
        return this.advanceAmount;
    }

    public void setAdvanceAmount(float advanceAmount) {
        this.advanceAmount = advanceAmount;
    }

    public int getBuildingDimensions() {
        return this.buildingDimensions;
    }

    public void calculateAdvanceAmount() {
        float advanceAmount = -1.0f;
        if (this.buildingDimensions > 0) {
            advanceAmount = this.buildingDimensions * 10;
        }
        this.advanceAmount = advanceAmount;
    }

    @Override
    public String toString() {
        return "BuildingForRent (buildingDimensions=" + this.buildingDimensions
                + ")";
    }
}

class HouseForRent extends BuildingForRent {
    private static String[][] facilitiesDetailsArr = {{"Security", "Parking", "Amusement-Park"}, {"2000", "3400", "2900"}};
    private String[] facilities;
    private int noOfBedrooms;

    public HouseForRent(int buildingDimensions, int noOfBedrooms, String[] facilities) {
        super(buildingDimensions);
        this.noOfBedrooms = noOfBedrooms;
        this.facilities = facilities;
    }

    public int getNoOfBedrooms() {
        return this.noOfBedrooms;
    }

    public String[] getFacilities() {
        return this.facilities;
    }

    //To_Trainee
    public Boolean validateNoOfBedrooms() {
        if (0 < this.noOfBedrooms < 6) {
			return true;
		}
        return false;
    }

    //To_Trainee
    @Override
    public void calculateAdvanceAmount() {
        super.calculateAdvanceAmount();
		float basicAmount = this.getAdvanceAmount();
		this.validateNoOfBedrooms();
		if (basicAmount <= -1 || !this.validateNoOfBedrooms() || this.facilities == null || this.facilities.length == 0) {
			this.setAdvanceAmount(-1.0f);
			return;
		}
		float totalFacilityCharge = 0.0f;
		for(String facility : facilities) {
			for(int i = 0; i < facilitiesDetailsArr[0].length; i++) {
				if (facilitiesDetailsArr[0][i].equalsIgnoreCase(facility)) {
					totalFacilityCharge += Float.parseFloat(facilitiesDetailsArr[1][i]);
				}
			}
		}
		if (totalFacilityCharge <= 0.0f) {
			this.setAdvanceAmount(-1.0f);
			return;
		}
		int bedroomCharges = 20000 * this.noOfBedrooms;
		this.setAdvanceAmount(basicAmount + totalFacilityCharge + bedroomCharges);
    }

    @Override
    public String toString() {
        return "HouseForRent (BuildingForRent (buildingDimensions=" + this.getBuildingDimensions()
                + ")facilities=" + Arrays.toString(this.facilities)
                + ", noOfBedrooms=" + this.noOfBedrooms + ")";
    }
}

class ShopForRent extends BuildingForRent {
    char shopType;

    public ShopForRent(int buildingDimensions, char shopType) {
        super(buildingDimensions);
        this.shopType = shopType;
    }

    //To_Trainee
    public int identifyShopRent() {
		char type = Character.toUpperCase(this.shopType);
		if (type == 'A') {
			return 45000;
		}
		if (type == 'B') {
			return 30000;
		}
		if (type == 'C') {
			return 25000;
		}
        return -1;
    }

    //To_Trainee
    @Override
    public void calculateAdvanceAmount() {
		super.calculateAdvanceAmount();
		float basicAmount = this.getAdvanceAmount();
		int shopRent = this.identifyShopRent();
		if (basicAmount <= -1 || shopRent <= -1) {
			this.setAdvanceAmount(-1.0f);
			return;
		}
		this.setAdvanceAmount(basicAmount + shopRent);
    }

    @Override
    public String toString() {
        return "ShopForRent (BuildingForRent (buildingDimensions=" + this.getBuildingDimensions()
                + ")shopType=" + this.shopType + ")";
    }
}

class Tester {
    public static void main(String[] args) {
        String[] facilities = {"PArking", "SecUrity"};
        HouseForRent obj1 = new HouseForRent(2000, 5, facilities);
        obj1.calculateAdvanceAmount();
        System.out.println("House Rent Amount:" + obj1.getAdvanceAmount());

        ShopForRent obj2 = new ShopForRent(10000, 'A');
        obj2.calculateAdvanceAmount();
        System.out.println("Shop Rent Amount:" + obj2.getAdvanceAmount());
    }
}

