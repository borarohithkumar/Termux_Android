import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.List;
class CatogEmps {
	public static boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        switch (ch) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
    }	
	public static ArrayDeque<String> categorizeEmployeesByVowel(ArrayList<String> inStrList) {
		List<String> tempData1 = new ArrayList<>();
		List<String> tempData2 = new ArrayList<>();
		ArrayDeque<String> outStrList = new ArrayDeque<>();
		if (inStrList == null || inStrList.isEmpty()) {
			return new ArrayDeque<>();
		}
		for(String i : inStrList) {
			if(!(i == null) && !(i.isEmpty())) {
				if (isVowel(i.charAt(0))) {
					tempData1.add(i);
				} else {
					tempData2.add(i);
				}
			}
		}
		for (String i : tempData1) {
			outStrList.offer(i);
		}
		for (String i : tempData2) {
			outStrList.offer(i);
		}
		return outStrList;
	}
	public static void main(String[] args) {
			ArrayList<String> inStrList = new ArrayList<>();
			inStrList.add("Oscar:D1");
			inStrList.add("Eve:D3");
			inStrList.add("Alice:D1");
			inStrList.add("Charlie:D2");
			inStrList.add("Bob:D2");
			System.out.println(categorizeEmployeesByVowel(inStrList));
	}	
}
