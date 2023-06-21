import java.util.ArrayDeque;
import java.util.Scanner;

public class P05PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command  =  scanner.nextLine();
        ArrayDeque<String> queue = new ArrayDeque<>();

        while (!command.equals("print")) {


         if (command.equals("cancel")) {
             String output = queue.isEmpty()
                     ? "Printer is on standby"
                     : "Canceled " + queue.poll();

             System.out.println(output);
         }else{
             queue.offer(command);
         }


            command = scanner.nextLine();
        }
        for (String file : queue
             ) {
            System.out.println(file);

        }
    }
}
