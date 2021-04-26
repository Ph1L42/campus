import java.io.File;

public abstract class AudioFile {

    //private static char sep;
    //private static String root = "/";

    public static final String PATH_SEPARATOR = "\\\\";

    //Variablen
    protected String pathname, filename, author, title;
    protected Long duration;

    private final char separatorChar = System.getProperty("file.separator").charAt(0);

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public Long getDuration(){
        return duration;
    }

    public AudioFile() {
    }

    public AudioFile(String pathname) {
        this.pathname = pathname;
        parsePathname(pathname);

        File file = new File(getPathname());
        if (!file.canRead()){
            throw new RuntimeException("Fehler: Datei existiert nicht " + pathname);
        }

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
                title = pathName.split("\\.")[0];
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

    public abstract void play();
    public abstract void togglePause();
    public abstract void stop();
    public abstract String getFormattedDuration();
    public abstract String getFormattedPosition();
    public abstract String[] fields();



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

    }

}

