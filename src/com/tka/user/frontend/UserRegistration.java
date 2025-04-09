package com.tka.user.frontend;

import java.util.Scanner;
import com.tka.user.controller.RegisterController;
import com.tka.user.entity.User;

public class UserRegistration {

    public static void main(String[] args) {

        RegisterController controller = new RegisterController();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== USER MENU =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Reset Password");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Register
                    User regUser = new User();
                    System.out.print("Enter Name: ");
                    regUser.setName(sc.nextLine());
                    System.out.print("Enter Email: ");
                    regUser.setEmail(sc.nextLine());
                    System.out.print("Enter Username: ");
                    regUser.setUsername(sc.nextLine());
                    System.out.print("Enter Password: ");
                    regUser.setPassword(sc.nextLine());

                    String regMsg = controller.registerUser(regUser);
                    System.out.println(regMsg);
                    break;

                case 2:
                    // Login
                    User loginUser = new User();
                    System.out.print("Enter Email: ");
                    loginUser.setEmail(sc.nextLine());
                    System.out.print("Enter Password: ");
                    loginUser.setPassword(sc.nextLine());

                    String loginMsg = controller.loginUser(loginUser);
                    System.out.println(loginMsg);
                    break;

                case 3:
                    // Reset Password
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter New Password: ");
                    String newPassword = sc.nextLine();

                    String resetMsg = controller.resetPassword(email, newPassword);
                    System.out.println(resetMsg);
                    break;

                case 4:
                    System.out.println("Exiting... Thank you!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
