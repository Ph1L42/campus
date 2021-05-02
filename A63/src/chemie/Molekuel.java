package chemie;

import chemie.Atom;

import java.util.LinkedList;

public class Molekuel {

    private String nameMolekuel;

    //Array mit 10.000 Atomen
    private Atom[] molekuelArray = new Atom[10000];

    //LinkedList der Klasse Atom mit Parametern atome
    private LinkedList<Atom> atome = new LinkedList<>();

    //Konstruktor Molekuel
    public Molekuel(String nameMolekuel) {
        this.nameMolekuel = nameMolekuel;
    }

    //Methode die Atom a in das molekuel Array an Stelle 0 setzt
    void addAtom(Atom a){
        molekuelArray[0] = a;
        atome.add(a);
    }


    void addAtom(Atom bindungsstelle, Atom a){
        if (this.atome.size() > 1000){

        }else{
            this.atome.add(a);
            a.addBindungen(bindungsstelle);
        }

    }


     public String summenformel(){

        int[]anzahl = new int[Element.values().length];

        for(int i = 0; i < anzahl.length; i++){
            anzahl [i] = 0;
        }
        for (Atom a : atome){
            int index = a.getElement().ordinal();
            anzahl[index]++;
        }
        String result = "";

        for(int i = 0; i < anzahl.length; i++){
            if(anzahl[i] > 0){
                result = result + Element.values()[i] + anzahl[i];
            }

        }
         return result;

    }

    public static void main(String[]args){
        Molekuel wasser = new Molekuel("Wasser");
        Atom o = new Atom(Element.O);

        wasser.addAtom(o);

        wasser.addAtom(o, new Atom(Element.H));
        wasser.addAtom(o, new Atom(Element.H));

        System.out.println(wasser.summenformel());
    }

}
