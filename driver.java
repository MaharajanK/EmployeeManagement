import java.util.Scanner;

public class driver {

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Employee name: ");
        String name = scan.next();
        System.out.print("Enter Employee id: ");
        int id = scan.nextInt();
        manager obj = new manager(id, name);

    }
}
