public static void main(String[] args) {
        ArrayList<String> inStrList = new ArrayList<>();
        inStrList.add("Oscar:D1");
        inStrList.add("Eve:D3");
        inStrList.add("Alice:D1");
        inStrList.add("Charlie:D2");
        inStrList.add("Bob:D2");

        ArrayDeque<String> result = categorizeEmployeesByVowel(inStrList);

        System.out.println("outStrQueue = " + result);
    }
}
