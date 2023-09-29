package Student;



import java.util.Scanner;

public class StudentManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student[] arrStudent = new Student[100];
        int currentIndex = -1;

        while (true) {
            System.out.println("************************************MENU****************************");
            System.out.println("1. Nhập thông tin n sinh viên");
            System.out.println("2. Hiển thị thông tin tất cả sinh viên");
            System.out.println("3. Thoát");
            System.out.print("Chọn chức năng (1/2/3): ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    if (currentIndex < arrStudent.length - 1) {
                        currentIndex++;
                        arrStudent[currentIndex] = new Student();
                        arrStudent[currentIndex].inputData(scanner, arrStudent, currentIndex);
                        System.out.println("Nhập thông tin sinh viên thành công.");
                    } else {
                        System.out.println("Danh sách sinh viên đã đầy.");
                    }
                    break;
                case 2:
                    System.out.println("Thông tin " + (currentIndex + 1) + " sinh viên:");
                    for (int i = 0; i <= currentIndex; i++) {
                        System.out.println("Sinh viên " + (i + 1) + ":");
                        arrStudent[i].displayData();
                    }
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Chức năng không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }
}

