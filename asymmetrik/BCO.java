package asymmetrik;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;


public class BCO {
    
    public static void main(String[] args) throws FileNotFoundException{
        
        //Creates the GUI for the application
        JFrame frame = new JFrame("Business Card OCR"); 
        JButton submit = new JButton("Submit");    
        submit.setBounds(150,300,140, 40);    
        JLabel label = new JLabel();        
        label.setText("Paste business card info to be parsed, then press submit: ");
        label.setBounds(10, 10, 700, 100);
        JLabel label1 = new JLabel();
        label1.setBounds(140, 275, 500, 200);
        JTextArea textarea = new JTextArea(15, 1);
        textarea.setBounds(10, 85, 400, 200);
        frame.add(label1);
        frame.add(textarea);
        frame.add(label);
        frame.add(submit);    
        frame.setSize(500,500);    
        frame.setLayout(null);    
        frame.setVisible(true);    
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        
        submit.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    //Reads in the input and places the lines in a list
                    //After running the functions on the lists it will generate an output.
                    Scanner reader = new Scanner(textarea.getText());
                    ArrayList<String> document = new ArrayList<String>();
                    String info = "";
                    while(reader.hasNextLine()) {
                        info = reader.nextLine();
                        document.add(info);
                    }
                    BusinessCardParser bcp = new BusinessCardParser();
                    bcp.getContactInfo(document);
        
                    label1.setText("<html>Name: " + bcp.contact.name + "<br>" + "Phone: " + bcp.contact.number + "<br>" + "Email: " + bcp.contact.address + "</html>");
                }
                catch (Exception e) {
                    System.out.println(e.toString());
                }              
            }          
          });
        }      
    }
