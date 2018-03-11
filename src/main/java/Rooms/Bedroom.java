package Rooms;

public class Bedroom extends Room {
    BedroomType type;
    private int roomNumber;
    private double dayRate;


    public Bedroom(BedroomType type, int roomNumber, double dayRate) {
        super(type.getCapacity());
        this.type = type;
        this.roomNumber = roomNumber;
        this.dayRate = dayRate;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public BedroomType getType() {
        return type;
    }

    public double getDayRate() {
        return dayRate;
    }
}
