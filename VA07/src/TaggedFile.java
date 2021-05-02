import java.util.Map;

import studiplayer.basic.TagReader;

public class TaggedFile extends SampledFile {

    public TaggedFile(String audiofile) {
        super(audiofile);
        readAndStoreTags(audiofile);
    }
    
    //Aufgabe i (1)
    private String album;

    public String getAlbum() {
        return album;
    }

    //Aufgabe g
    public void readAndStoreTags(String audiofile) {
        parsePathname(audiofile);
        parseFilename(getFilename());
        Map<String, Object> tags = TagReader.readTags(getPathname());

        String title = (String) tags.get("title");
        if (!(title == null || title.equals(""))) {
            this.title = title.trim();
        }

        String author = (String) tags.get("author");
        if (!(author == null || author.equals(""))) {
            this.author = author.trim();
        }

        String album = (String) tags.get("album");
        if (!(album == null || album.equals(""))) {
            this.album = album.trim();
        }

        Long duration = (Long) tags.get("duration");
        if (!(duration == null || duration.equals(0L))) {
            this.duration = duration;
        }
    }

    //Aufgabe i (2)
    public String toString() {
        if (getAlbum() == null || getAlbum().equals("")) {
            //return author + " - " + title + " - " + timeFormatter(duration);
            return super.toString() + " - " + SampledFile.timeFormatter(duration);
        } else {
            return author + " - " + title + " - " + album + " - " + SampledFile.timeFormatter(duration);
        }
    }

    public String[] fields() {
        String[] felder = new String[4];
        if (getAuthor() == null || getAuthor().isEmpty()) {
            felder[0] = "";
        } else {
            felder[0] = getAuthor();
        }
        if (getTitle() == null || getTitle().isEmpty()) {
            felder[1] = "";
        } else {
            felder[1] = getTitle();
        }
        if (getAlbum() == null || getTitle().isEmpty()) {
            felder[2] = "";
        } else {
            felder[2] = getAlbum();
        }
        if (getFormattedDuration() == null || getFormattedDuration().isEmpty()) {
            felder[3] = "";
        } else {
            felder[3] = getFormattedDuration();
        }
        return felder;
    }

}
