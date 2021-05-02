import studiplayer.basic.BasicPlayer;

public abstract class SampledFile extends AudioFile {

    public SampledFile() {
        super();
    }

    public SampledFile(String pathName) {
        super(pathName);
    }

    //Aufgabe d
    @Override
    public void play() {
        BasicPlayer.play(getPathname());
    }

    @Override
    public void togglePause() {
        BasicPlayer.togglePause();
    }

    @Override
    public void stop() {
        BasicPlayer.stop();
    }

    //Aufgabe h
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
