package campus;

//enum mit der Klasse "Studiengang"
enum Studiengang {
    WINF("Wirtschaftsinformatik"),
    INF("Informatik"),
    BW("Betriebswirtschaftslehre"),
    MT("Mechatronik");

    //Methode mit String "name"
    private String name;

    Studiengang(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

}



