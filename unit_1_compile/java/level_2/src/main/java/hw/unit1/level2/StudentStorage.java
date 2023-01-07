package hw.unit1.level2;

import java.util.ArrayList;
import java.util.List;

public class StudentStorage {
    private static List<Student> students = new ArrayList<>();
    private StudentStorage(){
    }

    public static List<Student> getStudents() {
        return students;
    }
    public static void addStudent(Student student){
        students.add(student);
    }
    public static void deleteStudent(String email){
        students.removeIf(student -> student.getEmail().equals(email));
    }
    public static Student getStudent (String email) {
        return students.stream().filter(student -> student.getEmail().equals(email)).findFirst().orElse(null);
    }
}
