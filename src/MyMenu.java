import java.util.Scanner;

public class MyMenu implements Runnable{

    @Override
    public void run() {
        ContactBook contactBook = new ContactBook();
        System.out.println("h - справка");
        Scanner scanner = new Scanner(System.in);
        while (!Thread.currentThread().isInterrupted()){
            final String key = scanner.nextLine();
            switch (key){
                case "h":
                    help();
                    break;
                case "q":
                    Thread.currentThread().interrupt();
                    break;
                case "a":
                    System.out.println("Формат ввода нового контакта:\n" +
                            "Иванов Иван Иванович;+89091112233;someEmail@example.example\n\n");
                    contactBook.addContact(scanner.nextLine());
                    break;
                case "d":
                    System.out.println("Введите email удаляемого контакта");
                    contactBook.deleteContact(scanner.nextLine());
                    break;
                case "w":
                    contactBook.writeToFile();
                    System.out.println("Контакты сохранены в файл (src\\data.txt)");
                    break;
                case "r":
                    System.out.println("Контакты прочитанны из файла (src\\forReading.txt)");
                    contactBook.readFromFile("D:\\IntelliJ IDEA Community Edition 2023.3.1\\MyProjects\\from leha\\contacts\\src\\forReading.txt");
                    break;
                case "p":
                    contactBook.printContactBook();
                    break;
                default:
                    System.out.println("Такой команды нет, \"h\" для справки");
            }
        }
    }

    private void help() {
        System.out.println("Добавление контакта  - команда a\n\n" +
                "Удаления контакта -  команда d\n\n" +
                "Сохранения контакта в файл - команда w (src\\data.txt)\n\n" +
                "Чтение контактов из файла - команда r (src\\forReading.txt)\n\n" +
                "Вывод всех контактов на экран - команда p\n\n" +
                "Выход - команда q");
    }

}
