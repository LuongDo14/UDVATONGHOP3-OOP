package ra.entity;

import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Product {
    private String productId;
    private String productName;
    private float price;
    private String description;
    private String created;
    private int catalogId;
    private int productStatus;

    public Product() {
    }

    public Product(String productId, String productName, float price, String description, String created, int catalogId, int productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.created = created;
        this.catalogId = catalogId;
        this.productStatus = productStatus;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public int getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }

    public void inputData(Scanner scanner, Product[] arrProduct, int index, Categories[] arrCategories) {
        System.out.println("Nhập thông tin sản phẩm ");
        System.out.println("Nhập mã sản phẩm (4 ký tự bắt đầu bằng C = cafe, S - Sinh tố hoặc A - Đồ ăn nhanh):");
        String inputProductId;
        boolean validProductId = false;
        boolean isDuplicate = false;
        do {
            inputProductId = scanner.nextLine();
            if (inputProductId.matches("[CSA][0-9]{3}")) {
                for (int i = 0; i < index; i++) {
                    if (arrProduct[i].getProductId().equals(inputProductId)) {
                        isDuplicate = true;
                        break;
                    }
                }
                if (!isDuplicate) {
                    validProductId = true;
                } else {
                    System.out.println("Mã sản phẩm đã tồn tài - Hãy nhập lại");
                }
            } else {
                System.out.println("Mã sản phẩm không hợp lệ - Hãy nhập lại");
            }
        } while (!validProductId);

        this.productId = inputProductId;

        System.out.println("Nhập tên sản phẩm (Nhập 10~50 kí tự)");
        String inputProductName;
        boolean validProductName = false;

        do {
            inputProductName = scanner.nextLine();

            if (inputProductName.length() >= 10 && inputProductName.length() <= 50) {

                for (int i = 0; i < index; i++) {
                    if (arrProduct[i].getProductName().equals(inputProductName)) {
                        isDuplicate = true;
                        break;
                    }
                }
                if (!isDuplicate) {
                    validProductName = true;
                } else {
                    System.out.println("Tên sản phẩm đã tồn tại - Hãy nhập lại");
                }
            } else {
                System.out.println("Tên sản phẩm không hợp lệ - Hãy nhập lại");
            }
        } while (!validProductName);

        this.productName = inputProductName;

        System.out.println("Nhập giá sản phẩm ( Có giá trị lớn hơn 0 )");
        boolean validPrice = false;

        do {
            if (scanner.hasNextFloat()) {
                this.price = Float.parseFloat(scanner.nextLine());
                if (this.price > 0) {
                    validPrice = true;
                } else {
                    System.out.println("Giá sản phẩm phải lớn hơn 0. Vui lòng nhập lại.");
                }
            } else {
                System.out.println("Giá sản phẩm không hợp lệ. Vui lòng nhập lại.");
                System.out.println();
            }
        } while (!validPrice);

        System.out.println("Nhập mô tả của sản phẩm");
        this.description = scanner.nextLine();

        System.out.println("Nhập ngày nhập sản phẩm có định dạng ( dd/mm/yyyy )");
        String inputCreated;
        boolean isValidDate = false;

        do {
            inputCreated = scanner.nextLine();

            // Biểu thức regex để kiểm tra định dạng ngày
            String regex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(inputCreated);

            if (matcher.matches()) {
                isValidDate = true;
            } else {
                System.out.println("Ngày nhập không hợp lệ. Vui lòng nhập lại.");
            }
        } while (!isValidDate);

        this.created = inputCreated;

//        System.out.println("Nhập mã danh mục mà sản phầm thuộc về");
//        this.catalogId = Integer.parseInt(scanner.nextLine());
//        for (int i = 0; i < arrCategories.length; i++) {
//            if(arrCategories[i].getCatalogId()== this.catalogId){
//                for (int j = 0; j < arrProduct.length; j++) {
//
//                }
//            }
//        }

        System.out.println("Nhập trạng thái sản phẩm (0: Đang bán – 1: Hết hàng – 2: Không bán)");
        int inputProductStatus;
        boolean exitStatus = true;
        do {
            inputProductStatus = Integer.parseInt(scanner.nextLine());
            if (isValidProductStatus(inputProductStatus)) {
                switch (inputProductStatus) {
                    case 0:
                        System.out.println("Đang bán");
                        exitStatus = false;
                        break;
                    case 1:
                        System.out.println("Hết hàng");
                        exitStatus = false;
                        break;
                    case 2:
                        System.out.println("Không bán");
                        exitStatus = false;
                        break;
                    default:
                        System.out.println("Mã trạng thái không hợp lệ. Vui lòng nhập lại.");
                        break;
                }
            } else {
                System.out.println("Mã trạng thái không hợp lệ. Vui lòng nhập lại.");
            }
        } while (exitStatus);

        // Các bước nhập thông tin khác tương tự như trong ví dụ trước
    }

    public void updateData(Scanner scanner, Product[] arrProduct, int index, Categories[] arrCategories) {
        System.out.println("Nhập mã sản phẩm (4 ký tự bắt đầu bằng C = cafe, S - Sinh tố hoặc A - Đồ ăn nhanh):");
        String inputProductId;
        boolean validProductId = false;
        boolean isDuplicate = false;
        do {
            inputProductId = scanner.nextLine();
            if (inputProductId.matches("[CSA][0-9]{3}")) {
                for (int i = 0; i < index; i++) {
                    if (arrProduct[i].getProductId().equals(inputProductId)) {
                        isDuplicate = true;
                        break;
                    }
                }
                if (!isDuplicate) {
                    validProductId = true;
                } else {
                    System.out.println("Mã sản phẩm đã tồn tài - Hãy nhập lại");
                }
            } else {
                System.out.println("Mã sản phẩm không hợp lệ - Hãy nhập lại");
            }
        } while (!validProductId);

        this.productId = inputProductId;

        System.out.println("Nhập tên sản phẩm (Nhập 10~50 kí tự)");
        String inputProductName;
        boolean validProductName = false;

        do {
            inputProductName = scanner.nextLine();

            if (inputProductName.length() >= 10 && inputProductName.length() <= 50) {

                for (int i = 0; i < index; i++) {
                    if (arrProduct[i].getProductName().equals(inputProductName)) {
                        isDuplicate = true;
                        break;
                    }
                }
                if (!isDuplicate) {
                    validProductName = true;
                } else {
                    System.out.println("Tên sản phẩm đã tồn tại - Hãy nhập lại");
                }
            } else {
                System.out.println("Tên sản phẩm không hợp lệ - Hãy nhập lại");
            }
        } while (!validProductName);

        this.productName = inputProductName;

        System.out.println("Nhập giá sản phẩm ( Có giá trị lớn hơn 0 )");
        boolean validPrice = false;

        do {
            if (scanner.hasNextFloat()) {
                this.price = Float.parseFloat(scanner.nextLine());
                if (this.price > 0) {
                    validPrice = true;
                } else {
                    System.out.println("Giá sản phẩm phải lớn hơn 0. Vui lòng nhập lại.");
                }
            } else {
                System.out.println("Giá sản phẩm không hợp lệ. Vui lòng nhập lại.");
                System.out.println();
            }
        } while (!validPrice);

        System.out.println("Nhập mô tả của sản phẩm");
        this.description = scanner.nextLine();

        System.out.println("Nhập ngày nhập sản phẩm có định dạng ( dd/mm/yyyy )");
        String inputCreated;
        boolean isValidDate = false;

        do {
            inputCreated = scanner.nextLine();

            // Biểu thức regex để kiểm tra định dạng ngày
            String regex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(inputCreated);

            if (matcher.matches()) {
                isValidDate = true;
            } else {
                System.out.println("Ngày nhập không hợp lệ. Vui lòng nhập lại.");
            }
        } while (!isValidDate);

        this.created = inputCreated;

//        System.out.println("Nhập mã danh mục mà sản phầm thuộc về");
//        this.catalogId = Integer.parseInt(scanner.nextLine());
//        for (int i = 0; i < arrCategories.length; i++) {
//            if(arrCategories[i].getCatalogId()== this.catalogId){
//                for (int j = 0; j < arrProduct.length; j++) {
//
//                }
//            }
//        }

        System.out.println("Nhập trạng thái sản phẩm (0: Đang bán – 1: Hết hàng – 2: Không bán)");
        int inputProductStatus;
        boolean exitStatus = true;
        do {
            inputProductStatus = Integer.parseInt(scanner.nextLine());
            if (isValidProductStatus(inputProductStatus)) {
                switch (inputProductStatus) {
                    case 0:
                        System.out.println("Đang bán");
                        exitStatus = false;
                        break;
                    case 1:
                        System.out.println("Hết hàng");
                        exitStatus = false;
                        break;
                    case 2:
                        System.out.println("Không bán");
                        exitStatus = false;
                        break;
                    default:
                        System.out.println("Mã trạng thái không hợp lệ. Vui lòng nhập lại.");
                        break;
                }
            } else {
                System.out.println("Mã trạng thái không hợp lệ. Vui lòng nhập lại.");
            }
        } while (exitStatus);
    }

    public boolean isValidProductStatus(int status) {
        return status >= 0 && status <= 2;
    }
    public void displayData(){
        System.out.printf("Mã sản phẩm: %s - Tên sản phẩm: %s - Giá sản phẩm: %f " , this.productId , this.productName, this.price);
        System.out.println();
        System.out.printf("Mô tả sản phẩm: %s - Ngày nhập sản phẩm: %s - Mã danh mục sản phẩm: %d - Trạng thái sản phẩm: %d " , this.description,this.created,this.catalogId,this.productStatus);
        System.out.println();
    }
}
//    Xây dựng các lớp sau:
//
//        b. Lớp Product trong package ra.entity chứa các thông tin về các sản phẩm đồ
//        uống của cửa hàng gồm các thông tin sau:
//        ➢ Các thuộc tính:
//        • productid – String: mã sản phẩm đồ uống, gồm 4 ký tự bắt đầu là
//        một trong 3 ký tự (C: các đồ uống là café, S: các đồ uống là sinh
//        tố, A: các đồ ăn nhanh), không được trùng lặp
//        • productName – String: tên sản phẩm đồ uống, có từ 10-50 ký tự,
//        không được trùng lặp
//        • price – float: giá sản phẩm có giá trị lớn hơn 0
//        • description – String: mô tả sản phẩm
//        • created – date: ngày nhập sản phẩm có định dạng dd/mm/yyyy
//        • catalogId – int: Mã danh mục mà sản phẩm thuộc về
//        • productStatus – int: trạng thái sản phẩm, chỉ nhận 1 trong các trạng
//        thái sau (0: Đang bán – 1: Hết hàng – 2: Không bán)
//Các constructor
//➢ Các phương thức getter/setter
//        ➢ Xây dựng các phương thức:
//        • inputData(Scanner scanner, Product[] arrProduct, int index,
//        Categories[] arrCategories): cho phép nhập thông tin của sản phẩm
//        Lưu ý:khi nhập mã danh mục sản phẩm, hiển thị các danh mục sản
//        phẩm đang có của cửa hàng theo menu cho người dùng lựa chọn
//        • displayData(): Cho phép hiển thị thông tin sản phẩm