import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class AttendanceSystemTest {
    private AttendanceSystem system;

    @Before
    public void setUp() {
        system = new AttendanceSystem();
        student student1 = new student("001", "John Doe");
        student student2 = new student("002", "Jane Smith");
        system.addStudent(student1);
        system.addStudent(student2);
    }

    @Test
    public void testSingleAttendance() {
        assertTrue(system.recordAttendance("001"));
        assertEquals(1, system.getAttendanceList().size());
        assertEquals(true, system.getAttendanceList().contains("John Doe"));
    }

    @Test
    public void testDuplicateAttendance() {
        system.recordAttendance("002");
        system.recordAttendance("002"); // Should not affect the outcome
        assertEquals(1, system.getAttendanceList().size());
    }

    @Test
    public void testUnknownId() {
        try {
            system.recordAttendance("003");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("No student with ID: 003", e.getMessage());
        }
    }

    
}
