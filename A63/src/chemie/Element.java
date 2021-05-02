package chemie;

//Enum mit Elementen
public enum Element {
    H("Wasserstoff"),
    He("Helium"),
    Li("Lithium"),
    Be("Berylium"),
    B("Bor"),
    C("Kohlenstoff"),
    N("Stickstoff"),
    O("Sauerstoff"),
    F("Fluor"),
    Ne("Neon"),
    Na("Natrium"),
    Mg("Magnesium"),
    Al("Aluminium"),
    Si("Silizium"),
    P("Phosphor"),
    S("Schwefel"),
    Cl("Chlorid"),
    Ar("Argon");


    private String fullname;

    //Konstruktor die den String full name zum Enum hinzufügt
    private Element(String fullname) {
        this.fullname = fullname;
    }

    //getter für den Elementnamen
    public String getFullname() {
        return fullname;
    }

    //setter für den Elementnamen
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    //toString Methode die fullname zurückgibt
    public String toString(){
        return fullname;
    }


}

