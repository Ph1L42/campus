import studiplayer.basic.WavParamReader;

public class WavFile extends SampledFile {

    public WavFile(String pathname) {
        super(pathname);
        readAndSetDurationFromFile(getPathname());
    }

    public static long computeDuration(long numberOfFrames, float frameRate) {
        float durationInSeconds = (numberOfFrames / frameRate);
        long durationInMicroseconds = (long) (durationInSeconds * 1000000L);
        return durationInMicroseconds;
    }

    public void readAndSetDurationFromFile(String pathname) {
        WavParamReader.readParams(pathname);
        float frameRate = WavParamReader.getFrameRate();
        long numberOfFrames = WavParamReader.getNumberOfFrames();
        this.duration = computeDuration(numberOfFrames, frameRate);
    }

    public String toString() {
        return super.toString() + " - " + getFormattedDuration();
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
//Siehste dat, dat sind arrays
        felder[2] = "";

        if (getFormattedDuration() == null || getFormattedDuration().isEmpty()) {
            felder[3] = "";
        } else {
            felder[3] = getFormattedDuration();
        }
        return felder;
    }

    public static void main(String[] args) {

    }
}
