import java.util.Scanner;
class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("acc no.: ");
        int accNo = sc.nextInt();
        System.out.print("min bal: ");
        float minBal = sc.nextFloat();
        System.out.print("salary: ");
        float salary = sc.nextFloat();
        System.out.print("loan type: ");
        String loanType = sc.next();
        System.out.print("emis: ");
        int xpectEmis = sc.nextInt();
        System.out.print("loan: ");
        float xpectLoan = sc.nextFloat();

        if (accNo < 1000 || accNo > 1999) {
            System.out.println("Invalid Acc No.");
            return;
        }
        if (minBal < 1000.0f) {
            System.out.println("Invalid Acc");
            return;
        }
        if (salary > 25000.0f && loanType.equalsIgnoreCase("car") && xpectLoan <= 500000.0f && xpectEmis <= 36) {
            System.out.println("eligibleLoanAmt = 500000");
            System.out.println("eligibleEmis  = 36");
        } else if (salary > 50000.0f && loanType.equalsIgnoreCase("house") && xpectLoan <= 6000000.0f && xpectEmis <= 60) {
            System.out.println("eligibleLoanAmt = 6000000");
            System.out.println("eligibleEmis  = 60");
        } else if (salary > 75000.0f && loanType.equalsIgnoreCase("business") && xpectLoan <= 7500000.0f && xpectEmis <= 84) {
            System.out.println("eligibleLoanAmt = 7500000");
            System.out.println("eligibleEmis  = 84");
        } else {
            System.out.println("ineligible for loan & emi");
        }
        sc.close();
    }
}
