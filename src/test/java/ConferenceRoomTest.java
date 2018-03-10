import Guest.Guest;
import Rooms.ConferenceRoom;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ConferenceRoomTest {
    ConferenceRoom conferenceRoom;
    Guest guest;

    @Before
    public void before() {
        conferenceRoom = new ConferenceRoom(20, "Blackford", 1700.00);
        guest = new Guest("Steve");
    }

    @Test
    public void canGetCapacity() {
        assertEquals(20, conferenceRoom.getCapacity());
    }

    @Test
    public void roomStartsEmpty() {
        assertEquals(0, conferenceRoom.guestCount());
    }

    @Test
    public void canAddGuest() {
        conferenceRoom.addGuest(guest);
        assertEquals(1, conferenceRoom.guestCount());
    }

    @Test
    public void canReturnGuests() {
        conferenceRoom.addGuest(guest);
        assertEquals(Arrays.asList(guest), conferenceRoom.getGuests());
    }

    @Test
    public void canRemoveGuest() {
        conferenceRoom.addGuest(guest);
        assertEquals(1, conferenceRoom.guestCount());
        conferenceRoom.removeGuest(guest);
        assertEquals(0, conferenceRoom.guestCount());
    }

    @Test
    public void canGetRoomName() {
        assertEquals("Blackford", conferenceRoom.getName());
    }

    @Test
    public void canGetDayRate() {
        assertEquals(1700.00, conferenceRoom.getDayRate(), 0.01);
    }
}
