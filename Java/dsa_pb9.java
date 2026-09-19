import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.List;
class VehIDs {
	public static ArrayDeque<String> getVehicleRegistrationIds(ArrayList<String> inStrList, ArrayDeque<String> inStrQueue) {
		String elem1, elem2;
		ArrayDeque<String> outStrQueue = new ArrayDeque<>();
		List<String> tempData = new ArrayList<>();
		int i = 0;
		while (i < inStrList.size() && inStrList.size() > 0 && inStrQueue.size() > 0) {
			elem1 = inStrList.get(i++);
			elem2 = inStrQueue.poll();
			if (elem2.charAt(0) == 'K') {
				outStrQueue.offer(elem1 + "-" + elem2);
			} 
			if (elem2.charAt(0) == 'D') {
				tempData.add(0, elem1 + "-" + elem2);
			}
		}
		for (String s : tempData) {
			outStrQueue.offer(s);
		}
		return outStrQueue;
	}
	public static void main(String[] args) {
		ArrayList<String> inStrList = new ArrayList<>();
		inStrList.add("JK-18");
		inStrList.add("MH-23");
		inStrList.add("WB-56");
		inStrList.add("TN-01");
		inStrList.add("KA-87");
		ArrayDeque<String> inStrQueue = new ArrayDeque<>();
		inStrQueue.offer("D-2570");
		inStrQueue.offer("K-8635");
		inStrQueue.offer("K-1255");
		inStrQueue.offer("D-4583");
		inStrQueue.offer("D-1246");
		System.out.println(getVehicleRegistrationIds(inStrList, inStrQueue));
	}
}
