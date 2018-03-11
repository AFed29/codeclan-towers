package Rooms;

public enum BedroomType {
    SINGLE(1),
    DOUBLE(2),
    FAMILY(4);

    int capacity;

    BedroomType(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}
