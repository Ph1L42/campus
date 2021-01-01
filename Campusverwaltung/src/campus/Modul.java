package campus;

//Enum der Klasse "Modul" mit den Fächern
enum Modul {
    PJ1("Programmierung in Java 1"),
    GWI("Grundlagen der Wirtschaftsinformatik"),
    GPI("Grundlagen der Informatik"),
    MATH("Mathematik"),
    IM1("Ingenieurmathematik 1"),
    IM2("Ingenieurmathematik 2"),
    KON("Konstruktion"),
    BS("Betriebssysteme");

    //Methode mit einem String und dem Namen "namen"
    private String name;

    //Referenz auf String "name"
    Modul(String name) {
        this.name = name;
    }

    //toString Methode die "name" ausgibt
    public String toString() {
        return name;
    }


}

