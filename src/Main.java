import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AccountManage accountManage = new AccountManage();
        accountManage.loadAccountsFromFile("Accounts.txt");

        do {
            System.out.println("---Menu---");
            System.out.println("1: Đăng nhập");
            System.out.println("2: Đăng ký");
            System.out.println("3: Thoát");
            System.out.println("----------------------");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > 3) {
                    throw new IndexOutOfBoundsException("Lựa chọn không hợp lệ, vui lòng chọn lại: ");
                }

                switch (choice) {
                    case 1:
                        accountManage.loginAccount();
                        break;
                    case 2:
                        accountManage.creatNewAccount();
                        break;
                    case 3:
                        System.exit(0);
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi. Nhập menu phải là số nguyên. Vui lòng nhập lại.");
            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }
}