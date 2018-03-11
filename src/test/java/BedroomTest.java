import Guest.Guest;
import Rooms.Bedroom;
import Rooms.BedroomType;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BedroomTest {
    Bedroom bedroom;
    Guest guest;

    @Before
    public void before() {
        bedroom = new Bedroom(BedroomType.DOUBLE, 117, 150.00);
        guest = new Guest("Alan");
    }

    @Test
    public void canGetType() {
        assertEquals(BedroomType.DOUBLE, bedroom.getType());
    }

    @Test
    public void canGetCapacity() {
        assertEquals(2, bedroom.getCapacity());
    }

    @Test
    public void roomStartsEmpty() {
        assertEquals(0, bedroom.guestCount());
    }

    @Test
    public void canAddGuest() {
        bedroom.addGuest(guest);
        assertEquals(1, bedroom.guestCount());
    }

    @Test
    public void canReturnGuests() {
        bedroom.addGuest(guest);
        assertEquals(Arrays.asList(guest), bedroom.getGuests());
    }

    @Test
    public void canRemoveGuest() {
        bedroom.addGuest(guest);
        assertEquals(1, bedroom.guestCount());
        bedroom.removeGuest(guest);
        assertEquals(0, bedroom.guestCount());
    }

    @Test
    public void canGetRoomNumber() {
        assertEquals(117, bedroom.getRoomNumber());
    }

    @Test
    public void canGetDayRate() {
        assertEquals(150.00, bedroom.getDayRate(), 0.01);
    }

    @Test
    public void roomIsFull() {
        bedroom.addGuest(guest);
        bedroom.addGuest(guest);
        assertTrue(bedroom.isRoomFull());
    }
}
