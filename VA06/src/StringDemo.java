/*public class StringDemo {

    private static boolean isWindows(){
        return false; //Linux
    }



    public static void main(String[] args){

        //Pfadseperator: liest 1. Zeichen von Property file.seperator
        char separatorChar = System.getProperty("file.separator").charAt(0);
        System.out.println("Pfadtrenner: " + separatorChar);

        //Windows Pfad
        String pfad1 = "D: \\Daten\\Musik\\Falco - Rock Me Amadeus.mp";
        String pfadNeu = "";
        //unter Linux -> "/D/Daten/Musik/Falco - Rock Me Amadeus.mp";

        //1. Teilaufgabe: suche nach Laufwerksbezeichnung "D:"
        char zeichen1 = pfad1.charAt(0);
        char zeichen2 = pfad1.charAt(1);


        //Muster: Buchstabe (groß oder klein) + ": "

        // 1.Zeichen in Kleinbuchstaben umwandeln
        zeichen1 = Character.toLowerCase(zeichen1);
        if(('a' <= zeichen1 && zeichen2 <= 'z') && zeichen2 == 'z'){
            System.out.println("Laufwerk: " + zeichen1);
            if(!isWindows()){
                pfadNeu = "/" + pfad1.charAt(0) + pfad1.substring(2); // alles ab 2. Index (3.Zeichen)
                System.out.println(pfadNeu);

            }
        }
        //2. Teilaufgabe: Pfadtrenner korrigieren
        for(int i = 0; i < pfadNeu.length(); i++){
            char zeichen = pfadNeu.charAt(i);
            if(isWindows()){

            }else{
                pfadErgebnis += zeichen;
                //Linux/Mac
                if(zeichen == '\\'){

                }
            }
        }
    }
}
*/