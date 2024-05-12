import java.util.Scanner;

public class MyMenu implements Runnable{

    @Override
    public void run() {
        System.out.println("h - справка");
        Scanner scanner = new Scanner(System.in);
        final String help = "h";
        while (true){
            final String key = scanner.nextLine();
            switch (key){
                case "h":
                    help();
                    break;
                case "q":
                    Thread.currentThread().interrupt();
                    break;
                default:
                    System.out.println("Такой команды нет, \"h\" для справки");
            }


        }
    }

    private static void help() {
        System.out.println("Добавление контакта  - команда a\n\n" +
//                "Формат ввода нового контакта:\n" +
//                "Иванов Иван Иванович;+89091112233;someEmail@example.example\n\n" +
                "Удаления контакта -  команда d\n\n" +
                "Сохранения контакта в файл - команда w (src\\data.txt)\n\n" +
                "Чтение контактов из файла - команда r (src\\forReading.txt)\n\n" +
                "Вывод всех контактов на экран - команда p\n\n" +
                "Выход - команда q");
    }
}
