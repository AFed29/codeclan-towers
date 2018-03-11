import Rooms.Bedroom;
import Rooms.BedroomType;
import Rooms.ConferenceRoom;
import Rooms.DiningRoom;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class HotelTest {
    Hotel hotel;
    Bedroom bedroom1;
    Bedroom bedroom2;
    Bedroom bedroom3;
    ConferenceRoom conferenceRoom;
    DiningRoom diningRoom;

    @Before
    public void before() {
        bedroom1 = new Bedroom(BedroomType.SINGLE, 101, 50.00);
        bedroom2 = new Bedroom(BedroomType.DOUBLE, 102, 85.00);
        bedroom3 = new Bedroom(BedroomType.FAMILY, 103, 140.00);
        ArrayList<Bedroom> bedrooms = new ArrayList<>();
        bedrooms.addAll(Arrays.asList(bedroom1, bedroom2, bedroom3));

        conferenceRoom = new ConferenceRoom(40, "Castle Hill", 1400.00);
        ArrayList<ConferenceRoom> conferenceRooms = new ArrayList<>();
        conferenceRooms.add(conferenceRoom);

        diningRoom = new DiningRoom(55, "The Mound");
        ArrayList<DiningRoom> diningRooms= new ArrayList<>();
        diningRooms.add(diningRoom);

        hotel = new Hotel("CC Towers", bedrooms, conferenceRooms, diningRooms);
    }

    @Test
    public void canGetAllBedrooms() {
        assertEquals(Arrays.asList(bedroom1, bedroom2, bedroom3), hotel.getBedrooms());
    }

    @Test
    public void canGetBedroomByNumber() {
        assertEquals(bedroom2, hotel.getBedroomByRoomNumber(102));
    }

    @Test
    public void canGetAllConferenceRooms() {
        assertEquals(Arrays.asList(conferenceRoom), hotel.getConferenceRooms());
    }

    @Test
    public void canGetConferenceRoomByName() {
        assertEquals(conferenceRoom, hotel.getConferenceRoomByName("Castle Hill"));
    }

    @Test
    public void canGetAllDiningRooms() {
        assertEquals(Arrays.asList(diningRoom), hotel.getDiningRooms());
    }

    @Test
    public void canGetDiningRoomByName() {
        assertEquals(diningRoom, hotel.getDiningRoomByName("The Mound"));
    }
}
