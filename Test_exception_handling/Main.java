import java.util.Scanner;
public class Main {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try{
            System.out.println("Enter age : ");
            int age  = sc.nextInt();
            sc.nextLine();
            StudentValidator.validateAge(age);

            System.out.println("Enter department : ");
            String dept = sc.nextLine();
            StudentValidator.validateDept(dept);
            System.out.println("Student validate successfully.");
        }
        catch(StudentException e){
            System.out.println("\n Error: "+ e.getMessage());

        }
    }
}
