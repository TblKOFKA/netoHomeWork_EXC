import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        PasswordChecker passwordChecker = new PasswordChecker();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите мин. длину пароля: ");
            String input = scanner.nextLine();
            passwordChecker.setMinLength(Integer.parseInt(input));

            System.out.print("Введите макс. допустимое количество повторений символа подряд: ");
            input = scanner.nextLine();
            passwordChecker.setMaxRepeats(Integer.parseInt(input));
        } catch (IllegalArgumentException e){
            System.out.println("Не корректно введены настройки!");
            System.out.println(e.getMessage());
            System.out.println("Работа программы будет завершена!");
            System.exit(1);
        }


        while(true){
            System.out.print("Введите пароль или end:");
            String input = scanner.nextLine();

            if (input.equals("end")){

                System.out.println("Программа завершена");
                break;
            }
            try{

            if (passwordChecker.verify(input)) {
                System.out.println("Подходит!");
            } else {
                System.out.println("Не подходит!");

            }
            } catch (IllegalStateException e){
                System.out.println("Не корректно введены настройки!");
                System.out.println("Работа программы будет завершена!");
                break;
            }



        }

    }
}