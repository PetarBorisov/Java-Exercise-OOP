package BirthdayCelebrations;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<Birthable> list = new ArrayList<>();

        while (!"End".equals(input)) {
           String[] commands = input.split(" ");
           String type = commands[0];
           switch (type) {
               case "Citizen" :
                   String personName = commands[1];
                   int agePerson = Integer.parseInt(commands[2]);
                   String personId = commands[3];
                   String birthDate = commands[4];
                   Citizen citizen = new Citizen(personName,agePerson,personId,birthDate);
                   list.add(citizen);
                   break;
               case "Pet":
                   String name = commands[1];
                   String birthday = commands[2];
                   Pet pet = new Pet(name,birthday);
                   list.add(pet);
                   break;
               case "Robot" :
                   break;
           }


            input = scanner.nextLine();
        }
        String year = scanner.nextLine();

        boolean isFound = false;
        for (Birthable birthable : list) {
            if (birthable.getBirthDate().endsWith(year)) {
                System.out.println(birthable.getBirthDate());
                isFound = true;
        }

        }
        if (!isFound) {
            System.out.println("<no output>");
        }
    }

}
