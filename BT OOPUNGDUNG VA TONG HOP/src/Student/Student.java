package Student;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
    private String studentId;
    private String studentName;
    private int age;
    private String email;
    private String phone;
    private boolean sex;
    private float javascore;

    public Student() {
    }

    public Student(String studentId, String studentName, int age, String email, String phone, boolean sex, float javascore) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.sex = sex;
        this.javascore = javascore;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public float getJavascore() {
        return javascore;
    }

    public void setJavascore(float javascore) {
        this.javascore = javascore;
    }

    public void inputData(Scanner scanner, Student[] arrStudent, int currentIndex) {
        // Thực hiện nhập thông tin sinh viên và kiểm tra tính hợp lệ theo yêu cầu
        // Các phần nhập thông tin khác ở đây

        // Kiểm tra và nhập studentId
        System.out.println("Nhập mã học sinh (Pxxxx, không trùng lặp):");
        String id = scanner.nextLine();
        while (!validateStudentId(id, arrStudent, currentIndex)) {
            System.out.println("Mã học sinh không hợp lệ hoặc đã tồn tại. Vui lòng nhập lại:");
            id = scanner.nextLine();
        }
        this.studentId = id;

        // Kiểm tra và nhập studentName
        System.out.println("Nhập tên học sinh (10-50 ký tự):");
        String name = scanner.nextLine();
        while (!validateStudentName(name)) {
            System.out.println("Tên học sinh không hợp lệ. Vui lòng nhập lại:");
            name = scanner.nextLine();
        }
        this.studentName = name;

        // Kiểm tra và nhập age
        System.out.println("Nhập tuổi (lớn hơn 0):");
        int age = Integer.parseInt(scanner.nextLine());
        while (!validateAge(age)) {
            System.out.println("Tuổi không hợp lệ. Vui lòng nhập lại:");
            age = scanner.nextInt();
        }
        this.age = age;

        // Kiểm tra và nhập email
        System.out.println("Nhập địa chỉ email:");
        String email = scanner.nextLine();
        while (!validateEmail(email)) {
            System.out.println("Email không hợp lệ. Vui lòng nhập lại:");
            email = scanner.nextLine();
        }
        this.email = email;

        // Kiểm tra và nhập phone
        System.out.println("Nhập số điện thoại di động (091, 092, 098, 035, 090):");
        String phone = scanner.nextLine();
        while (!validatePhone(phone)) {
            System.out.println("Số điện thoại không hợp lệ. Vui lòng nhập lại:");
            phone = scanner.nextLine();
        }
        this.phone = phone;

        // Kiểm tra và nhập sex
        System.out.println("Nhập giới tính (true|false):");
        boolean sex = Boolean.parseBoolean(scanner.nextLine());
        this.sex = sex;

        // Kiểm tra và nhập javascore
        System.out.println("Nhập điểm Java (0-10):");
        float javascore = Float.parseFloat(scanner.nextLine());
        while (!validateJavaScore(javascore)) {
            System.out.println("Điểm Java không hợp lệ. Vui lòng nhập lại:");
            javascore = scanner.nextFloat();
        }
        this.javascore = javascore;
    }

    // ... Các phương thức kiểm tra tính hợp lệ

    private boolean validateStudentId(String studentId, Student[] arrStudent, int currentIndex) {
        String regex = "^P(?!.*P).{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(studentId);

        if (!matcher.matches()) {
            return false;
        }

        // Kiểm tra xem studentId đã tồn tại trong danh sách sinh viên hay chưa
        for (int i = 0; i <= currentIndex; i++) {
            if (i != currentIndex && arrStudent[i].getStudentId().equals(studentId)) {
                return false;
            }
        }

        return true;
    }

    private boolean validateStudentName(String studentName) {
        String regex = "^.{10,50}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(studentName);
        return matcher.matches();
    }

    private boolean validateAge(int age) {
        String regex = "^[1-9][0-9]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(String.valueOf(age));
        return matcher.matches();
    }

    private boolean validateEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean validatePhone(String phone) {
        String regex = "^(09[0-2]|098|035|090)\\d{7}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    private boolean validateJavaScore(float javascore) {
        String regex =  "^(\\d|10)(\\.\\d+)?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(Float.toString(javascore));
        return matcher.matches();
    }
    public void displayData() {
        // Hiển thị thông tin sinh viên
        System.out.println("Mã học sinh: " + studentId);
        System.out.println("Tên học sinh: " + studentName);
        System.out.println("Tuổi: " + age);
        System.out.println("Email: " + email);
        System.out.println("Số điện thoại: " + phone);
        System.out.println("Giới tính: " + (sex ? "Nam" : "Nữ"));
        System.out.println("Điểm javascore: " + javascore);
    }
}
