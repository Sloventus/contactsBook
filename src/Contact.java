public class Contact {

    private String fio;
    private String phoneNumber;
    private String email;

    public String getFio() {
        return fio;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public Contact(String fio, String phoneNumber, String email) {
        this.fio = fio;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
