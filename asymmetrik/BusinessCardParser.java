package asymmetrik;
import java.util.ArrayList;

public class BusinessCardParser {   
    public ContactInfo contact;

    //Creates a ContactInfo object to be printed
    public void getContactInfo(ArrayList<String> document) {
        this.contact = new ContactInfo();
        contact.getPhoneNumber(document);
        contact.getEmailAddress(document);
        contact.getName(document);
    }
}