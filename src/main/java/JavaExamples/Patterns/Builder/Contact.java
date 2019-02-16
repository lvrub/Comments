package JavaExamples.Patterns.Builder;

public class Contact {
    private final String name;
    private final String surname;
    private final String mail;
    private final String phone;
    private final String address;

    Contact(ContactBuilder contactBuilder) {
        this.name = contactBuilder.getName();
        this.surname = contactBuilder.getSurname();
        this.mail = contactBuilder.getMail();
        this.phone = contactBuilder.getPhone();
        this.address = contactBuilder.getAddress();
        System.out.println(contactBuilder.getName());
    }

}
