package ra.run;

import ra.entity.Categories;
import ra.entity.Product;

import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;

public class ShopManagement {
    private static final Categories[] arrCategories = new Categories[100];
    private static final Product[] arrProduct = new Product[100];
    private static int index = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isExit = true;
        while(true) {
            System.out.println("******************SHOP MENU*******************");
            System.out.println("1. Quản lý danh mục sản phẩm");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Thoát");
            int choise = Integer.parseInt(scanner.nextLine());
            switch (choise){
                case 1:
                   ShopManagement.isDisplayCatalogries();
                    break;
                case 2:
                    ShopManagement.isDisplayProduct();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui lòng nhập lại 1-3");
            }
        }
    }
    public static void isDisplayCatalogries(){
        Scanner scanner = new Scanner(System.in);
        boolean isExit = true;
        do {
            System.out.println("********************CATEGORIES MENU***********");
            System.out.println("1. Nhập thông tin các danh mục");
            System.out.println("2. Hiển thị thông tin các danh mục");
            System.out.println("3. Cập nhật thông tin danh mục");
            System.out.println("4. Xóa danh mục");
            System.out.println("5. Cập nhật trạng thái danh mục");
            System.out.println("6. Thoát");
            int choise1 = Integer.parseInt(scanner.nextLine());
            switch (choise1){
                case 1:
                    if(index < arrCategories.length -1){
                        index++;
                        arrCategories[index] = new Categories();
                        arrCategories[index].inputData(scanner,arrCategories,index);
                        System.out.println("Nhập thông tin danh mục thành công");
                    } else {
                        System.out.println("Danh mục đã đầy không thế nhập thêm");
                    }
                    break;
                case 2:
                    System.out.println("Thông tin các danh mục");
                    System.out.println("Thông tin" + (index + 1) + "Danh mục");
                    for (int i = 0; i < index + 1; i++) {
                        System.out.println("Danh mục " + (i + 1) + ":");
                        arrCategories[i].displayData();

                    }
                    break;
                case 3:

                    System.out.println("3. Cập nhật thông tin danh mục");
                    System.out.println("Vui lòng nhập mã danh mục cần cập nhật");
                    int idcategories = Integer.parseInt(scanner.nextLine());
                    boolean isUpdate = true;
                    for (Categories arrCategory : arrCategories) {
                        if (arrCategory.getCatalogId() == idcategories) {
                            System.out.println("Kết nối mã thành công" + idcategories);
                            System.out.println("Nhập tên danh muc mới");
                            arrCategory.setCatalogName(scanner.nextLine());
                            System.out.println("Nhập mô tả mới");
                            arrCategory.setDescriptions(scanner.nextLine());



                            System.out.println("Danh mục đã được cập nhật");
                            isUpdate = false;
                            break;
                        } else {
                            System.out.println("Không tìm thấy sản phẩm có mã: " + idcategories);
                        }
                    }
                    if (!isUpdate) {
                        System.out.println("Không tìm thấy sản phẩm có mã: " + idcategories);
                    }
                    break;
                case 4:
                    System.out.println("Xóa danh mục");
                    System.out.print("Nhập mã hoặc tên danh mục cần xóa: ");
                    int catalogIdDel = Integer.parseInt(scanner.nextLine());
                    String catalogNameDel = scanner.nextLine();

                    for (int i = 0; i <= index; i++) {
                        if (arrCategories[i] != null) {
                            if (arrCategories[i].getCatalogId() == catalogIdDel || arrCategories[i].getCatalogName().equals(catalogNameDel)) {

                                for (int j = i; j < index; j++) {
                                    arrCategories[j] = arrCategories[j + 1];
                                }
                                // Đặt danh mục cuối cùng thành null và giảm chỉ số index
                                arrCategories[index] = null;
                                index--;
                                System.out.println("Danh mục đã được xóa.");
                                break;
                            }
                        }
                    }
                    break;
                case 5:
                    boolean isUpdateStatus = false;
                    System.out.println("5. Cập nhật trạng thái danh mục");
                    System.out.println("Vui lòng nhập mã danh mục cần cập nhật");
                    int idcategoriesStatus = Integer.parseInt(scanner.nextLine());
                    for (Categories arrCategory : arrCategories) {
                        if (arrCategory.getCatalogId() == idcategoriesStatus) {

                            boolean newStatus = !arrCategory.isCatalogStatus();
                            arrCategory.setCatalogStatus(newStatus);
                            System.out.println("Danh mục  ( Trạng thái )đã được cập nhật");
                            isUpdateStatus = true;
                            break;
                        }
                    }
                    if (!isUpdateStatus){
                        System.out.println("Không tìm thấy sản phẩm có mã: "+idcategoriesStatus);
                    }
                    break;
                case 6:
                    isExit = false;
                    break;
                default:
                    System.out.println("Chọn lại 1-6");

            }

        }while (isExit);

    }
    public static void isDisplayProduct(){
        Scanner scanner = new Scanner(System.in);
        boolean isExit = true;
        do {
            System.out.println("*******************PRODUCT MANAGEMENT*****************");
            System.out.println("1. Nhập thông tin các sản phẩm");
            System.out.println("2. Hiển thị thông tin các sản phẩm");
            System.out.println("3. Sắp xếp các sản phẩm theo giá");
            System.out.println("4. Cập nhật thông tin sản phẩm theo mã sản phẩm");
            System.out.println("5. Xóa sản phẩm theo mã sản phẩm");
            System.out.println("6. Tìm kiếm các sản phẩm theo tên sản phẩm");
            System.out.println("7. Tìm kiếm sản phẩm trong khoảng giá a – b (a,b nhập từ bàn phím)");
            System.out.println("8. Thoát");
            int choise2 = Integer.parseInt(scanner.nextLine());
            switch (choise2){
                case 1:
                    if(index < arrProduct.length -1){
                        index++;
                        arrProduct[index] = new Product();
                        arrProduct[index].inputData(scanner,arrProduct,index,arrCategories);
                        System.out.println("Nhập thông tin sản phẩm thành công");
                    } else {
                        System.out.println("Sản phẩm đã đầy không thế nhập thêm");
                    }
                    break;
                case 2:
                    System.out.println("Thông tin các sản phẩm");
                    System.out.println("Thông tin" + (index + 1) + "Sản phẩm");
                    for (int i = 0; i < index + 1; i++) {
                        System.out.println("Sản phẩm " + (i + 1) + ":");
                        arrProduct[i].displayData();
                    }
                    break;
                case 3:
                    System.out.println("3. Sắp xếp các sản phẩm theo giá");
                    for (int i = 0; i < index - 1; i++) {
                        for (int j = 0; j < index - i - 1; j++) {
                            if (arrProduct[j].getPrice() > arrProduct[j + 1].getPrice()) {
                                // Hoán đổi hai sản phẩm
                                Product temp = arrProduct[j];
                                arrProduct[j] = arrProduct[j + 1];
                                arrProduct[j + 1] = temp;
                            }
                        }
                        System.out.println("Sản phẩm đã được sắp xếp theo giá.");
                    }

                    break;
                case 4:
                    System.out.print("Nhập mã sản phẩm cần cập nhật: ");
                    String productId = scanner.nextLine();

                    for (Product product : arrProduct) {
                        if (product.getProductId().equalsIgnoreCase(productId)) {
                            product.updateData(scanner,arrProduct,index,arrCategories);
                            System.out.println("Thông tin sản phẩm đã được cập nhật.");
                            return;
                        }

                    System.out.println("Không tìm thấy sản phẩm với mã " + productId);
            }
                    break;
                case 5:
                    System.out.println("Xóa danh mục");
                    System.out.print("Nhập mã hoặc tên danh mục cần xóa: ");
                    int productIdDel = Integer.parseInt(scanner.nextLine());


                    for (int i = 0; i <= index; i++) {
                        if (arrCategories[i] != null) {
                            if (arrCategories[i].getCatalogId() == productIdDel) {

                                for (int j = i; j < index; j++) {
                                    arrCategories[j] = arrCategories[j + 1];
                                }
                                arrCategories[index] = null;
                                index--;
                                System.out.println("Danh mục đã được xóa.");
                                break;
                            }
                        }
                    }
                    break;
                case 6:
                    System.out.print("Nhập tên sản phẩm cần tìm: ");
                    String productName = scanner.nextLine();

                    boolean found = false;
                    for (Product product : arrProduct) {
                        if (product.getProductName().toLowerCase().contains(productName.toLowerCase())) {
                            product.displayData();
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Không tìm thấy sản phẩm với tên " + productName);
                    }
                    break;
                case 7:
                    System.out.print("Nhập giá thấp nhất (a): ");
                    double minPrice = Double.parseDouble(scanner.nextLine());

                    System.out.print("Nhập giá cao nhất (b): ");
                    double maxPrice = Double.parseDouble(scanner.nextLine());

                    boolean founded = false;
                    for (Product product : arrProduct) {
                        if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
                            product.displayData();
                            founded = true;
                        }
                    }

                    if (!founded) {
                        System.out.println("Không tìm thấy sản phẩm trong khoảng giá từ " + minPrice + " đến " + maxPrice);
                    }
                    break;
                case 8:
                    isExit = false;
                    break;
                default:
                    System.out.println("Vui lòng chọn lại từ 1-8");
            }
        }while (isExit);
    }
}
