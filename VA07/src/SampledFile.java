public abstract class SampledFile extends AudioFile {

    public SampledFile() {
        super();
    }

    public SampledFile(String pathName) {
        super(pathName);
    }

    @Override
    public void play() {

    }

    @Override
    public void togglePause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public String getFormattedDuration() {
        return timeFormatter(duration);
    }

    @Override
    public String getFormattedPosition() {
        return timeFormatter(studiplayer.basic.BasicPlayer.getPosition());
    }

    //Aufgabe f
    public static String timeFormatter(long microtime) {
        long seconds = 0;
        long minutes = 0;
        long restSeconds = 0;

        // 3600000000
        if (microtime < 0) {
            throw new RuntimeException("Negativ time value provided");
        } else if (microtime >= 6000000000L) {
            throw new RuntimeException("Time value exceeds allowed format");
        } else {
            seconds = microtime / 1_000_000L;
            minutes = seconds / 60;
            restSeconds = seconds % 60;
        }

        return String.format("%02d:%02d", minutes, restSeconds);
    }

}
