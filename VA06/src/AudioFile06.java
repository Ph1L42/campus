public class AudioFile06 {


    private static char sep;

    private static String root = "/";

    public static final String PATH_SEPARATOR = "\\\\";

    //Variablen
    private String pathname, filename, author, title;

    private final char separatorChar = System.getProperty("file.separator").charAt(0);

    //Methode um zu bestimmen ob das Betriebssystem Windows ist
    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public AudioFile06() {
    }

    public AudioFile06(String pathname) {
        this.pathname = pathname;
        parsePathname(pathname);
        this.filename = getFilename();
        parseFilename(filename);
    }

    private boolean isWindows() {
        String os = System.getProperty("os.name").toLowerCase();
        //System.out.println("Betriebssystem: " + os);

        return os.contains("win");

    }

    //Pfadnamen bestimmen

    public void parsePathname(String pathName) {


        //Wenn pathName nach trennung leer ist wird pathName (ohne leerzeichen) zurückgegeben


        if (pathName.trim().isEmpty()) {
            pathname = pathName;
        }
        //Pfad für Windows
        else {
            if (isWindows()) {
                pathName = pathName.replace('/', '\\');

                while (pathName.contains(PATH_SEPARATOR)) {
                    pathName = pathName.replace(PATH_SEPARATOR, "\\");
                }
                String[] parts = pathName.split(PATH_SEPARATOR);
                if (parts.length > 1 && parts[1].length() == 1) {
                    parts[1] = parts[1] + ": ";
                    // Hi my name e jeff
                    pathName = String.join("\\", parts);
                    pathName = pathName.replaceFirst(PATH_SEPARATOR, "");
                }

                this.pathname = pathName;
            }
            //Pfad für Linux
            else {
                pathName = pathName.replace('\\', '/');

                // Wenn ein Windows Pfad als Eingabe kommt
                if (pathName.contains(":")) {
                    String laufwerk = pathName.split(":")[0];
                    String restPfad = pathName.split(":")[1];

                    laufwerk = "/" + laufwerk;
                    pathName = laufwerk + restPfad;
                    pathname = pathName;
                }

                while (pathName.contains("//")) {
                    pathName = pathName.replace("//", "/");
                }

                //?????
/*                String[] parts2 = pathName.split("/");
                if (parts2.length > 1 && parts2[1].length() == 1) {
                    parts2[1] = parts2[1];
                    pathName = String.join("/", parts2);
                    pathName = pathName.replaceFirst("/", "");

                *//*if (pathName.charAt(1) == ':') {
                    pathName = pathName.replace(":", "/");
                    pathName = "/" + pathName;

                 *//*
                }*/
                pathname = pathName;
            }
        }
        // d:\\\\part1///file.mp3
        // Linux: /d/part1/file.mp3
        // Windows: d:\part1\file.mp3
    }

    public String getPathname() {
        return pathname;
    }
    //Teilt den Pfad zwischen den / auf und gibt den letzten Teil als Filename zurück

    public String getFilename() {
        if (pathname.length() < 1)
            return "";

        String fn;
        if (isWindows()) {
            if (pathname.charAt(pathname.length() - 1) == '\\') {
                fn = "";
                return fn;
            } else {
                String[] teil = pathname.split(PATH_SEPARATOR);
                fn = teil[teil.length - 1];
                return fn;
            }
        } else {
            String[] teil = pathname.split("/");
            if (pathname.charAt(pathname.length() - 1) == '/') {
                fn = "";
                return fn;
            }
            fn = teil[teil.length - 1];
            return fn;
        }

    }

    // parse title and author from pathName
    public void parseFilename(String pathName) {

        if (pathName.contains("-")) {
            String[] pathAndTitle = pathName.split(" - ");
            //System.out.println(Arrays.toString(pathAndTitle));
            //String[] pathParts = pathName.split(LINE_SEPARATOR);

            //System.out.println(Arrays.toString(pathAndTitle));
            if (pathAndTitle.length == 1 && pathAndTitle[0].equals(pathName)) {
                author = "";
                title = pathName;
            } else {
                //String fileName = pathParts[pathParts.length - 1].trim();

                author = pathAndTitle[0].trim();
                title = pathAndTitle[1].trim();

                if (title.contains(".")) {
                    String[] egal2 = title.split("\\.");
                    if (egal2.length == 1) {
                        title = egal2[0];
                    } else {
                        egal2[egal2.length - 1] = "";
                        title = String.join(".", egal2);
                        title = title.substring(0, title.length() - 1).trim();
                    }
                }
            }
        } else {
            author = "";
            title = "";
            if (pathName.contains(".")) {
                String[] egal2 = pathName.split("\\.");
                if (egal2.length == 0) {
                    author = "";
                    title = "";
                } else {
                    //System.out.println(Arrays.toString(egal2));
                    egal2[egal2.length - 1] = "";
                    title = String.join(".", egal2);
                    title = title.substring(0, title.length() - 1).trim();
                }
            }
        }
    }


    @Override
    public String toString() {

        if ((getAuthor() == null || getAuthor().isEmpty()) && (getTitle() == null || getTitle().isEmpty())) {
            return "";
        } else if (getAuthor().isEmpty() && getTitle().length() > 0) {
            return title;
        } else if (author.length() > 0 && getTitle().isEmpty()) {
            return author;
        } else {
            return author + " - " + title;
        }
    }


    public static void main(String[] args) {
    /*
        sep = System.getProperty("file.separator").charAt(0);
        String osname = System.getProperty("os.name");
        if (osname.toLowerCase().indexOf("win") >= 0)
            root = "C:" + sep;
        String[] pathNames = new String[]{
                "home" + sep + "meier" + sep + "Musik" + sep + "Falco - Rock Me Amadeus.mp3",
                "home" + sep + "db-admin" + sep + "Frankie Goes To Hollywood - The Power Of Love.ogg",
                root + "tmp" + sep + "Deep Purple - Smoke On The Water.wav",
                root + "my-tmp" + sep + "file.mp3",
                "Falco - Rock Me Amadeus.mp3",
                "file.mp3",
                ".." + sep + "music" + sep + "audiofile.au",
                "   A.U.T.O.R   -   T.I.T.E.L   .EXTENSION",
                "Hans-Georg Sonstwas - Blue-eyed boy-friend.mp3",
                // Some more ugly test cases.
                // Note that arbitrary combinations of / and \ are provided.
                // Consecutive occurrences of these are to be squeezed and
                // replaced by a single separator that corresponds to
                // the platform running the application (use System.getProperty("file.separator").charAt(0)).
                // Further note that spaces and tabs (white space) are not
                // altered by this normalization.
                "",
                " ",
                "//your-tmp/part1//file.mp3/",
                "../your-tmp/..//part1//file.mp3/",
                "\\file.mp3",
                "\\part1\\\\file.mp3\\",
                "\\part1///file.mp3",
                "/MP3-Archiv/.nox",
                "/MP3-Archiv/Falco - Rock me Amadeus.",
                "-",
                " -  "
        };

        for (int i = 0; i < pathNames.length; i++) {
            AudioFile af = new AudioFile(pathNames[i]);
            //System.out.print(i);
            System.out.println(af.getTitle());
        }

        AudioFile af = new AudioFile("C:\\Users\\phili\\Desktop\\MusikFürDenPlayer\\Hans-Georg Sonstwas -  Blue-eyed boy-friend.mp3\\");
        AudioFile af2 = new AudioFile("//my-tmp////part1//file.mp3/");
       /* System.out.println(af.separatorChar);

        if (af.isWindows())
            System.out.println("unter windows!");
        String path = " Falco  -  Rock me    Amadeus .mp3  ";
        String path = "   A.U.T.O.R   -  T.I.T.E.L  .EXTENSION";
        String path = "   A.U.T.O.R   -  T.I.T.E.L  .EXTENSION";
        af.parsePathname(path);
        af.parseFilename(path);
        System.out.println(af.getPathname());
        System.out.println(af.getFilename());

        af.parseFilename(path);
        System.out.println(af.getAuthor());
        System.out.println(af.getTitle());

        //System.out.println(Arrays.toString("-".split("-")));
        //System.out.println(Arrays.toString(" - ".split("-")));


        System.out.println(af);
        System.out.println(af2.getFilename());
        */
    }

}
