import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class AttendanceSystem {
    private HashMap<String, String> students;
    private Set<String> attendanceSet;

    public AttendanceSystem() {
        students = new HashMap<>();
        attendanceSet = new HashSet<>();
    }

    public void addStudent(student student) {               
        students.put(student.getStudentId(), student.getName());
    }

    public boolean recordAttendance(String studentId) {
        String studentName = students.get(studentId);
        if (studentName == null) {
            throw new IllegalArgumentException("No student with ID: " + studentId);
        }

        if (students.containsKey(studentId)) {
            attendanceSet.add(students.get(studentId));
            return true;
        }
        return false;
    }

    public HashSet<String> getAttendanceList() {
        return new HashSet<>(attendanceSet);
    }
}
