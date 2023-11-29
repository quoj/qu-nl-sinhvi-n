package demol.student;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManagement studentManagement = new StudentManagement();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Chỉnh sửa thông tin sinh viên theo ID");
            System.out.println("3. Xóa sinh viên theo ID");
            System.out.println("4. Sắp xếp sinh viên theo điểm trung bình");
            System.out.println("5. Sắp xếp sinh viên theo tên");
            System.out.println("6. Hiển thị danh sách sinh viên");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Nhập ID sinh viên: ");
                    int id = scanner.nextInt();
                    System.out.print("Nhập tên sinh viên: ");
                    scanner.nextLine(); // Xóa bộ nhớ đệm đầu vào
                    String name = scanner.nextLine();
                    System.out.print("Nhập ngày sinh của sinh viên: ");
                    String dateOfBirth = scanner.nextLine();
                    System.out.print("Nhập địa chỉ của sinh viên: ");
                    String address = scanner.nextLine();
                    System.out.print("Nhập điểm trung bình của sinh viên: ");
                    double gpa = scanner.nextDouble();
                    Student student = new Student(id, name, dateOfBirth, address, gpa);
                    studentManagement.addStudent(student);
                    System.out.println("Sinh viên đã được thêm thành công.");
                    break;
                case 2:
                    System.out.print("Nhập ID sinh viên để chỉnh sửa: ");
                    int editId = scanner.nextInt();
                    studentManagement.editStudentById(editId);
                    break;
                case 3:
                    System.out.print("Nhập ID sinh viên để xóa: ");
                    int deleteId = scanner.nextInt();
                    studentManagement.deleteStudentById(deleteId);
                    break;
                case 4:
                    studentManagement.sortStudentsByGpa();
                    break;
                case 5:
                    studentManagement.sortStudentsByName();
                    break;
                case 6:
                    studentManagement.displayStudents();
                    break;
                case 0:
                    System.out.println("Đang thoát chương trình...");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
                    break;
            }
            System.out.println();
        } while (choice != 0);
    }
}