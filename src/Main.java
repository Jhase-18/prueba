import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar usuario");
            System.out.println("2. Ver todos los usuarios");
            System.out.println("3. Actualizar usuario");
            System.out.println("4. Eliminar usuario");
            System.out.println("5. Salir");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Nombre: ");
                        String name = scanner.nextLine();
                        System.out.print("Email: ");
                        String email = scanner.nextLine();
                        userDAO.addUser(new User(0, name, email));
                        System.out.println("Usuario agregado.");
                        break;
                    case 2:
                        List<User> users = userDAO.getAllUsers();
                        for (User user : users) {
                            System.out.println(user);
                        }
                        break;
                    case 3:
                        System.out.print("ID del usuario a actualizar: ");
                        int updateId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nuevo nombre: ");
                        String newName = scanner.nextLine();
                        System.out.print("Nuevo email: ");
                        String newEmail = scanner.nextLine();
                        userDAO.updateUser(new User(updateId, newName, newEmail));
                        System.out.println("Usuario actualizado.");
                        break;
                    case 4:
                        System.out.print("ID del usuario a eliminar: ");
                        int deleteId = scanner.nextInt();
                        scanner.nextLine();
                        userDAO.deleteUser(deleteId);
                        System.out.println("Usuario eliminado.");
                        break;
                    case 5:
                        running = false;
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
