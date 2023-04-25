import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountManage {
    static List<Account> accounts = new ArrayList<>();
    public void creatNewAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Tên đăng nhập: ");
        String userName = scanner.nextLine();
        System.out.println(" Mật khẩu: ");
        String password = scanner.nextLine();
        System.out.println(" Họ và tên: ");
        String fullName = scanner.nextLine();
        System.out.println(" số điện thoại: ");
        String phoneNumber = scanner.nextLine();
        System.out.println(" Địa chỉ của bạn: ");
        String address = scanner.nextLine();
        boolean flag = false;
        for (int i = 0; i < accounts.size();i++){
            if (accounts.get(i).getUserName().equals(userName)){
                System.out.println(" Tài khoản đã tồn tại.");
                flag = true;
                break;
            }
        }
        if (flag == false){
            System.out.println(" Tạo tài khoản thành công.");
            Account account = new Account(userName, password, fullName, phoneNumber, address);
            accounts.add(account);
            saveAccountsToFile("Accounts.txt");
        }
    }

    public void saveAccountsToFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Account account : accounts) {
                String line = String.format("%s,%s,%s,%s,%s",
                        account.getUserName(), account.getPassword(),
                        account.getFullName(), account.getPhoneNumber(),
                        account.getAddress());
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("đã xảy ra lỗi khi lưu tài khoản vào tệp: " + e.getMessage());
        }
    }

    public void loginAccount() {
        Scanner scanner = new Scanner(System.in);
        boolean check = false;
        while (!check) {
            System.out.println(" Tên tên đăng nhập: ");
            String userName = scanner.nextLine();
            System.out.println(" Mật khẩu: ");
            String password = scanner.nextLine();
            for (Account account : accounts) {
                if (userName.equals(account.getUserName()) && password.equals(account.getPassword())) {
                    System.out.println("Hello " + account.getFullName());
                    check = true;
                    break;
                }
            }
            if (!check) {
                System.out.println(" Đăng nhập thất bại, tên đăng nhập hoặc mật khẩu không chính xác.");
            }
        }

    }

    public void loadAccountsFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String userName = parts[0];
                String password = parts[1];
                String fullName = parts[2];
                String phoneNumber = parts[3];
                String address = parts[4];
                accounts.add(new Account(userName, password, fullName, phoneNumber, address));
            }
        } catch (IOException e) {
            System.err.println("Đã xảy ra lỗi khi đọc danh sách tài khoản từ tệp tin: " + e.getMessage());
        }
    }
}

