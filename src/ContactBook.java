import java.io.*;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactBook {

    private Map<String,Contact> contactMap= new TreeMap<>();

    public static void main(String[] args) {
        ContactBook contactBook = new ContactBook();
        contactBook.addContact("Иванов Иван Иванович;+89091112233;someEmail@example.example");
        contactBook.addContact("Смирнов Смирн Смирнович;+89091112244;someBody@example.example");
        contactBook.readFromFile("D:\\IntelliJ IDEA Community Edition 2023.3.1\\MyProjects\\from leha\\contacts\\src\\forReading.txt");
        contactBook.printContactBook();
        contactBook.writeToFile();
    }

    public Map<String,Contact> getContactBook(){
            return contactMap;
    }

    public void printContactBook(){
        for (Map.Entry<String,Contact> pair : contactMap.entrySet()){
            System.out.println(writePair(pair));
        }
    }

    private String writePair(Map.Entry<String,Contact> pair){
        return pair.getValue().getFio() + "; " + pair.getValue().getPhoneNumber() +
                "; " + pair.getValue().getEmail() + ";";
    }

    private boolean isFio(String record){
        Pattern pattern = Pattern.compile("[A-zА-я]+\s[A-zА-я]+\s[A-zА-я]+");
        Matcher matcher = pattern.matcher(record);
        return matcher.matches();
    }
    private boolean isNumber(String record){
        Pattern pattern = Pattern.compile("\\++8\\d{10}");
        Matcher matcher = pattern.matcher(record);
        return matcher.matches();
    }
    private boolean isEmail(String record){
        Pattern pattern = Pattern.compile("[A-z0-9._%+-]+@[A-z0-9.-]+\\.[A-z]{2,}");
        Matcher matcher = pattern.matcher(record);
        return matcher.matches();
    }

    //service value for next two methods
    private String record;

    public void addContact(String oneContact){
        this.record = oneContact + ";";

        final String fio = splitter();
        final String number = splitter();
        final String email = splitter();

        if (isFio(fio) && isNumber(number) && isEmail(email)){
            Contact contact = new Contact(fio,number,email);
            contactMap.put(contact.getEmail(),contact);
        } else {
            if (!isFio(fio)) System.out.println("Не правильно указано Ф.И.О.");
            if (!isNumber(number)) System.out.println("Не правильно указан номер телефона");
            if (!isEmail(email)) System.out.println("Не правильно указан email");

        }
    }
    private String splitter(){
        String result = record.substring(0,record.indexOf(';'));
        record = record.substring(record.indexOf(';')+1);
        return result;
    }

    public void deleteContact(String email){
        if (contactMap.get(email) != null){
            contactMap.remove(email);
        } else {
            System.out.println("Не найдено контакта с таким email");
        }
    }

    public void writeToFile(){
        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter("D:\\IntelliJ IDEA Community Edition 2023.3.1\\MyProjects\\from leha\\contacts\\src\\data.txt"));)
        {
            for (Map.Entry<String,Contact> pair : contactMap.entrySet())
            {
                bufferedWriter.write(writePair(pair) + "\n");
            }
        } catch (IOException e) {
            System.out.println("Что-то пошло не так");
        }

    }

//D:\IntelliJ IDEA Community Edition 2023.3.1\MyProjects\from leha\contacts\src\data.txt\forReading.txt
    public void readFromFile(String path){
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path)))
        {
            while (bufferedReader.ready()){
                addContact(bufferedReader.readLine());
            }
        } catch (IOException e) {
            System.out.println("Что-то пошло не так2");
        }
    }
}
