// Adaptee: HeartModel
class HeartModel {
    private int heartRate;

    public HeartModel() {
        heartRate = 72; // default beats per minute
    }

    public void pump() {
        System.out.println("Heart is pumping at " + heartRate + " beats per minute");
    }

    public void setHeartRate(int rate) {
        heartRate = rate;
    }

    public int getHeartRate() {
        return heartRate;
    }
}

// Target interface: BeatModel
interface BeatModel {
    void startBeating();
    void setRate(int rate);
    int getRate();
}

// Adapter class: HeartModel → BeatModel
class HeartAdapter implements BeatModel {
    private HeartModel heart;

    public HeartAdapter(HeartModel heart) {
        this.heart = heart;
    }

    @Override
    public void startBeating() {
        heart.pump();
    }

    @Override
    public void setRate(int rate) {
        heart.setHeartRate(rate);
    }

    @Override
    public int getRate() {
        return heart.getHeartRate();
    }
}

// Main class
public class slip11a {
    public static void main(String[] args) {

        HeartModel heart = new HeartModel();            // Adaptee
        BeatModel beatHeart = new HeartAdapter(heart);  // Adapter

        System.out.println("Initial Heart Beat:");
        beatHeart.startBeating();

        System.out.println("\nChanging Heart Rate to 90 bpm:");
        beatHeart.setRate(90);
        beatHeart.startBeating();

        System.out.println("\nCurrent Heart Rate: " + beatHeart.getRate() + " bpm");
    }
}
