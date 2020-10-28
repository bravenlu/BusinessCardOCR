package asymmetrik;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ContactInfo {

    public String name;
    public String number;
    public String address;

    public ContactInfo() {
        //default constructor
    }
    //Finds the phone number by searching for a '(' or a '-' in the line
    //It also will ignore any fax numbers that may appear before the telephone number.
    public void getPhoneNumber(ArrayList<String> document) {
        String line = "";
        for(int i = 0; i < document.size(); i++)
        {
            if(document.get(i).contains("Fax:"))
            {
                continue;
            }
            if(document.get(i).contains("(") || document.get(i).contains("-"))
            {
                line = document.get(i);
                break;
            }
        }
        number = line.replaceAll("[^\\d]", "");
    }
    //Finds a line with the '@' symbol and returns the line
    public void getEmailAddress(ArrayList<String> document) {
        for(int i = 0; i < document.size(); i++)
        {
            if(document.get(i).contains("@"))
            {
                address = document.get(i);
                break;
            }
        }
    }
    //Returns the name of the business card holder by using the previous getEmailAddress() function.
    //Using the function it takes the username from the front of the email and finds a line that has a word that is included in the username. 
    public void getName(ArrayList<String> document) {
        name = "";
        int atIndex = address.indexOf('@');
        String username = address.substring(0, atIndex);
        for(int i = 0; i < document.size(); i++)
        {
            String[] words = document.get(i).split(" ");
            for(int j = 0; j < words.length; j++)
            {
                if(username.contains(words[j].toLowerCase()))
                {
                    name = document.get(i);
                    break;
                }
            }
            if(!name.equals(""))
            {
                break;
            }
        } 
    }
}