package Rooms;

public class ConferenceRoom extends Room{
    private String name;
    private double dayRate;
    
    public ConferenceRoom(int capacity, String name, double dayRate) {
        super(capacity);
        this.name = name;
        this.dayRate = dayRate;
    }

    public String getName() {
        return name;
    }

    public double getDayRate() {
        return dayRate;
    }
}
