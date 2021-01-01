package campus;

enum Note {
    N1_0("1,0", 1.0),
    N1_3("1,3", 1.3),
    N1_7("1,7", 1.7),
    N2_0("2,0", 2.0),
    N2_3("2,3", 2.3),
    N2_7("2,7", 2.7),
    N3_0("3,0", 3.0),
    N3_3("3,3", 3.3),
    N3_7("3,7", 3.7),
    N4_0("4,0", 4.0),
    N5_0("5,0", 5.0);


    private String name;
    private double wert;

    Note(String name, double wert) {
        this.name = name;
        this.wert = wert;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name;
    }


    public double getWert() {
        return wert;
    }

    public static void main(String[] args) {
        System.out.print(Note.N1_7.getWert());
    }
}
