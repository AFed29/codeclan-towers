import Guest.Guest;
import Rooms.DiningRoom;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class DiningRoomTest {
    DiningRoom diningRoom;
    Guest guest;

    @Before
    public void before() {
        diningRoom = new DiningRoom(50, "Blackbird");
        guest = new Guest("Bob");
    }

    @Test
    public void canGetCapacity() {
        assertEquals(50, diningRoom.getCapacity());
    }

    @Test
    public void roomStartsEmpty() {
        assertEquals(0, diningRoom.guestCount());
    }

    @Test
    public void canAddGuest() {
        diningRoom.addGuest(guest);
        assertEquals(1, diningRoom.guestCount());
    }

    @Test
    public void canReturnGuests() {
        diningRoom.addGuest(guest);
        assertEquals(Arrays.asList(guest), diningRoom.getGuests());
    }

    @Test
    public void canRemoveGuest() {
        diningRoom.addGuest(guest);
        assertEquals(1, diningRoom.guestCount());
        diningRoom.removeGuest(guest);
        assertEquals(0, diningRoom.guestCount());
    }

    @Test

    public void canGetRoomName() {
        assertEquals("Blackbird", diningRoom.getName());
    }
}
