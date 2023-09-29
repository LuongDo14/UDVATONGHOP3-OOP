package ra.entity;

import java.util.Scanner;

public class Categories {
    private int catalogId;
    private String catalogName;
    private String descriptions;
    private boolean catalogStatus;

    public Categories() {
    }

    public Categories(int catalogId, String catalogName, String descriptions, boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.descriptions = descriptions;
        this.catalogStatus = catalogStatus;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }
    public void inputData(Scanner scanner, Categories[] arrCategories, int index){
        boolean isExit = true;
        System.out.println("Nhập thông tin cửa hàng");
        this.catalogId = index;
        System.out.println();

        System.out.println("Nhập tên cửa hàng");
        do {
            this.catalogName = scanner.nextLine();
            if (this.catalogName.length()<= 50){
                isExit = false;
            } else {
                System.out.println("Tên cửa hàng không hợp lệ , vui long nhập lại ");
            }
        }while (isExit);

        System.out.println("Nhập mô tả danh mục");
        this.descriptions = scanner.nextLine();
        System.out.println("Nhập trạng thái danh mục (True - hoạt động , false - không hoạt động)");
        this.catalogStatus = Boolean.parseBoolean(scanner.nextLine());
//        Categories newCategory = new Categories();
//        newCategory.setCatalogName(this.catalogName);
//        newCategory.setDescriptions(this.descriptions);
//        newCategory.setCatalogStatus(this.catalogStatus);
//
//        // Gán mã danh mục tự tăng
//        newCategory.setCatalogId(getNextCatalogId(arrCategories));
//
//        // Lưu danh mục vào mảng danh mục
//        arrCategories[index] = newCategory;
//
//        System.out.println("Danh mục đã được thêm vào với mã danh mục: " + newCategory.getCatalogId());
    }
    public static void updateCatalogries(Scanner scanner, Categories[] arrCategories, int index){
        for (int i = 0; i < arrCategories.length; i++) {

        }
    }

    public static int getNextCatalogId(Categories[] arrCategories) {
        int maxCatalogId = 0;

        for (Categories category : arrCategories) {
            if (category != null && category.getCatalogId() > maxCatalogId) {
                maxCatalogId = category.getCatalogId();
            }
        }

        return maxCatalogId + 1;
    }

    public void displayData() {
        System.out.println("Mã danh mục: " + this.catalogId);
        System.out.println("Tên danh mục: " + this.catalogName);
        System.out.println("Mô tả danh mục: " + this.descriptions);
        System.out.println("Trạng thái danh mục: " + (this.catalogStatus ? "Hoạt động" : "Không hoạt động"));
    }
}

//    Xây dựng các lớp sau:
//        a. Lớp Categories trong package ra.entity chứa các thông tin về danh mục đồ
//        uống (ví dụ: Danh mục cafe, danh mục đồ ăn nhanh, danh mục sinh tố…)
//        của cửa hàng gồm các thông tin sau:
//        ➢ Các thuộc tính
//        • catalogId – int: mã danh mục, tự tăng – Khi tạo danh mục mới mã
//        danh mục lấy mã danh mục lớn nhất + 1
//        • catalogName – String: tên danh mục, có độ dài tối đa 50 ký tự,
//        không trùng lặp
//        • descriptions – String: mô tả danh mục
//        • catalogStatus – Boolean: chỉ nhận khi nhập 1 trong 2 giá trị true
//        hoặc false (true – hoạt động, false – không hoạt động)
//        ➢ Các constructor
//        ➢ Các phương thức getter/setter
//        ➢ Xây dựng các phương thức:
//        • inputData(Scanner scanner, Categories[] arrCategories, int index):
//        Cho phép nhập thông tin các danh mục theo đúng các yêu cầu dữ
//        liệu đầu vào
//        • displayData(): Hiển thỉ đầy đủ thông tin danh mục
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