package demol.student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class StudentManagement {
    private final ArrayList<Student> students;
    private final Scanner scanner;

    public StudentManagement() {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void editStudentById(int id) {
        for (Student student : students) {
            if (student.id() == id) {
                // Prompt for new student information
                // Update the student object accordingly
                // For simplicity, let's assume we only update the name and GPA
                System.out.print("Nhập tên mới cho sinh viên: ");
                scanner.nextLine();
                student.setName();

                System.out.print("Nhập GPA mới cho sinh viên: ");
                scanner.nextDouble();
                student.setGpa();

                System.out.println("Cập nhật thông tin sinh viên thành công.");
                return;
            }
        }

        System.out.println("Không tìm thấy sinh viên với ID đã cho.");
    }

    public void deleteStudentById(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).id() == id) {
                students.remove(i);
                System.out.println("Xóa sinh viên thành công.");
                return;
            }
        }

        System.out.println("Không tìm thấy sinh viên với ID đã cho.");
    }

    public void sortStudentsByGpa() {
        students.sort(Comparator.comparingDouble(Student::gpa));
        System.out.println("Sinh viên đã được sắp xếp theo GPA.");
    }

    public void sortStudentsByName() {
        students.sort(Comparator.comparing(Student::name));
        System.out.println("Sinh viên đã được sắp xếp theo tên.");
    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("Không tìm thấy sinh viên nào.");
            return;
        }

        System.out.println("Student List:");
        for (Student student : students) {
            System.out.println("ID: " + student.id());
            System.out.println("Name: " + student.name());
            System.out.println("Date of Birth: " + student.dateOfBirth());
            System.out.println("Address: " + student.address());
            System.out.println("GPA: " + student.gpa());
            System.out.println("------------------");
        }
    }
}