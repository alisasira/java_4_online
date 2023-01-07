package hw.unit1.level2;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        Student student1 = new Student();
        student.setName("A");
        System.out.println("student "+ student.getName());
        List<Student> students = StudentStorage.getStudents();
        student.setName("Alisa Sira");


    }


}





