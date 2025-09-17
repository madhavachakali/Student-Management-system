import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();
                    System.out.print("Enter Fee: ");
                    double fee = sc.nextDouble();
                    Student s = new Student(name, email, course, fee);
                    dao.addStudent(s);
                    break;

                case 2:
                    List<Student> students = dao.getAllStudents();
                    System.out.println("\nID | Name | Email | Course | Fee");
                    for (Student st : students) {
                        System.out.println(st.getId() + " | " + st.getName() + " | " +
                                st.getEmail() + " | " + st.getCourse() + " | " + st.getFee());
                    }
                    break;

                case 3:
                    System.out.print("Enter Student ID to update: ");
                    int upId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String upName = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String upEmail = sc.nextLine();
                    System.out.print("Enter Course: ");
                    String upCourse = sc.nextLine();
                    System.out.print("Enter Fee: ");
                    double upFee = sc.nextDouble();
                    dao.updateStudent(upId, upName, upEmail, upCourse, upFee);
                    break;

                case 4:
                    System.out.print("Enter Student ID to delete: ");
                    int delId = sc.nextInt();
                    dao.deleteStudent(delId);
                    break;

                case 5:
                    System.out.println(" Exiting...");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println(" Invalid choice! Try again.");
            }
        }
    }
}
