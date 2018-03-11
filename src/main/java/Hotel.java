import Rooms.Bedroom;
import Rooms.ConferenceRoom;
import Rooms.DiningRoom;

import java.util.ArrayList;

public class Hotel {
    private String name;
    private ArrayList<Bedroom> bedrooms;
    private ArrayList<ConferenceRoom> conferenceRooms;
    private ArrayList<DiningRoom> diningRooms;

    public Hotel(String name, ArrayList<Bedroom> bedrooms, ArrayList<ConferenceRoom> conferenceRooms, ArrayList<DiningRoom> diningRooms) {
        this.name = name;
        this.bedrooms = bedrooms;
        this.conferenceRooms = conferenceRooms;
        this.diningRooms = diningRooms;
    }

    public ArrayList<Bedroom> getBedrooms() {
        return this.bedrooms;
    }

    public Bedroom getBedroomByRoomNumber(int roomNumber) {
        for (Bedroom bedroom: this.bedrooms) {
            if (bedroom.getRoomNumber() == roomNumber) {
                return bedroom;
            }
        }
        return null;
    }

    public ArrayList<ConferenceRoom> getConferenceRooms() {
        return this.conferenceRooms;
    }

    public ConferenceRoom getConferenceRoomByName(String name) {
        for (ConferenceRoom conferenceRoom: this.conferenceRooms) {
            if (name.equals(conferenceRoom.getName())) {
                return conferenceRoom;
            }
        }
        return null;
    }

    public ArrayList<DiningRoom> getDiningRooms() {
        return diningRooms;
    }

    public DiningRoom getDiningRoomByName(String name) {
        for (DiningRoom diningRoom : diningRooms) {
            if (name.equals(diningRoom.getName())) {
                return diningRoom;
            }
        }
        return null;
    }
}
