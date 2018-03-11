import Guest.Guest;
import Rooms.Bedroom;
import Rooms.BedroomType;
import Rooms.ConferenceRoom;
import Rooms.DiningRoom;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class HotelTest {
    Hotel hotel;
    Bedroom bedroom1;
    Bedroom bedroom2;
    Bedroom bedroom3;
    ConferenceRoom conferenceRoom;
    DiningRoom diningRoom;
    Guest guest;

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

        guest = new Guest("Jeff");
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

    @Test
    public void canCheckGuestIntoBedroomNotFull() {
        hotel.checkGuestIntoBedroom(guest, 101);
        assertEquals(1, hotel.getBedroomByRoomNumber(101).guestCount());
    }

    @Test
    public void canCheckGuestIntoBedroomIsFull() {
        hotel.checkGuestIntoBedroom(guest, 101);
        hotel.checkGuestIntoBedroom(guest, 101);
        assertEquals(1, hotel.getBedroomByRoomNumber(101).guestCount());
    }

    @Test
    public void canCheckGuestIntoConferenceRoomNotFull() {
        hotel.checkGuestIntoConferenceRoom(guest, "Castle Hill");
        assertEquals(1, hotel.getConferenceRoomByName("Castle Hill").guestCount());
    }

    @Test
    public void canCheckGuestIntoConferenceRoomIsFull() {
        for (int i = 0; i < 50; i++) {
            hotel.checkGuestIntoConferenceRoom(guest, "Castle Hill");
        }
        assertEquals(40, hotel.getConferenceRoomByName("Castle Hill").guestCount());
    }

    @Test
    public void canCheckGuestIntoDiningRoomNotFull() {
        hotel.checkGuestIntoDiningRoom(guest, "The Mound");
        assertEquals(1, hotel.getDiningRoomByName("The Mound").guestCount());
    }

    @Test
    public void canCheckGuestIntoDiningRoomIsFull() {
        for (int i = 0; i < 60; i++) {
            hotel.checkGuestIntoDiningRoom(guest, "The Mound");
        }
        assertEquals(55, hotel.getDiningRoomByName("The Mound").guestCount());
    }

    @Test
    public void canCheckGuestOutOfBedroom() {
        hotel.checkGuestIntoBedroom(guest, 102);
        assertEquals(1, hotel.getBedroomByRoomNumber(102).guestCount());
        hotel.checkGuestOut(guest);
        assertEquals(0, hotel.getBedroomByRoomNumber(102).guestCount());
    }

    @Test
    public void canCheckGuestOutOfConferenceRoom() {
        hotel.checkGuestIntoConferenceRoom(guest, "Castle Hill");
        assertEquals(1, hotel.getConferenceRoomByName("Castle Hill").guestCount());
        hotel.checkGuestOut(guest);
        assertEquals(0, hotel.getConferenceRoomByName("Castle Hill").guestCount());
    }

    @Test
    public void canCheckGuestOutOfDiningRoom() {
        hotel.checkGuestIntoDiningRoom(guest, "The Mound");
        assertEquals(1, hotel.getDiningRoomByName("The Mound").guestCount());
        hotel.checkGuestOut(guest);
        assertEquals(0, hotel.getDiningRoomByName("The Mound").guestCount());
    }
}
