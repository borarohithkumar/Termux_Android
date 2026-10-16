class AvgSal {
	static double[] findDetails(double[] salary) {
		double sum = 0.0;
		for (int i = 0; i < salary.length; i++) {
			sum += salary[i];
		}
		double avg = sum / salary.length;
		double more = 0;
		double less = 0;
		for (int i = 0; i < salary.length; i++) {
			if (salary[i] > avg) {
				more++;
			}
			if (salary[i] < avg) {
				less++;
			}
		}
		return new double[] {avg, more, less};
	}
	public static void main(String[] args) {
		double[] salary = {23500.0, 25080.0, 28760.0, 22340.0, 19890.0};
		double[] details = findDetails(salary);
		System.out.println("Average salary: " + details[0]);
		System.out.println("Number of salaries more than the average salary: " + details[1]);
		System.out.println("Number of salaries less than the average salary: " + details[2]);
	}
}
