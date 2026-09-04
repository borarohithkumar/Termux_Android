class Handshake {
    public static void main(String[] args) {
		String[][] l = {
            {"IND", "AUS", "IND", "RUS", "CHI", "AUS", "JAP"},
            {"Rohit", "Ricky", "Virat", "John", "Chang", "Travis", "Wong"}
        };
        for (int i = 0; i < l[1].length; i++) {
            for (int j = 0; j < l[1].length; j++) {
                if (i != j && !l[0][i].equals(l[0][j])) {
                    System.out.println(l[1][i] + " - " + l[1][j]);
                }
            }
        }
    }
}
