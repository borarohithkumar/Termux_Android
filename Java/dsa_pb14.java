import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;
class CaTrans {
	public static void main(String[] args) {
		Map<String, Double> transAmountMap = new LinkedHashMap<String, Double>();
		transAmountMap.put("T1", 800.0);
		transAmountMap.put("T2", 75000.0);
		transAmountMap.put("T3", 60000.0);
		transAmountMap.put("T4", 90000.0);
		transAmountMap.put("T5", 500.0);
		Set<String> flaggedTransactions = new HashSet<String>();
		flaggedTransactions.add("T2");
		flaggedTransactions.add("T4");
		List<String> tempDatastructure = new ArrayList<String>();
		Deque<String> alertQueue = new ArrayDeque<String>();
		for (String transaction : transAmountMap.keySet()) {
			if (flaggedTransactions.contains(transaction)) {
				alertQueue.offer(transaction + "_FRAUD");
			}
			else {
				if (transAmountMap.get(transaction) > 999.0) {
					tempDatastructure.add(transaction + "_VALID_ABOVE_MINBAL");
				}
				else {
					tempDatastructure.add(transaction + "_VALID_BELOW_MINBAL");
				}
			}
		}
		for (String transaction : tempDatastructure) {
			alertQueue.offer(transaction);
		}
		while (!alertQueue.isEmpty()) {
			System.out.println(alertQueue.poll());
		}	
	}
}
