import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные через пробел: ");
        String[] data = scanner.nextLine().split("\\s");
        if (data.length != 6) {
            throw new RuntimeException(
                    "Некорректный ввод! Вы ввели " +
                            data.length + " значений. Необходимо ввести 6.");
        }
        Person person = new Person(data);
        try (FileWriter writer = new FileWriter(person.getLastName() + ".txt", true)) {
            writer.write(person.toString());

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}