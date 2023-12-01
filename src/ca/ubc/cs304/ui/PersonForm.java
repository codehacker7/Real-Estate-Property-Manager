package ca.ubc.cs304.ui;

import ca.ubc.cs304.database.DatabaseConnectionHandler;
import ca.ubc.cs304.model.entity.EntityModel;
import ca.ubc.cs304.model.entity.Person;

import javax.swing.*;
import java.awt.*;

public class PersonForm extends JFrame {
    private JTextField phoneTextField;
    private JTextField nameTextField;
    private JTextField emailTextField;

    public PersonForm() {
        // Set up the JFrame
        setTitle("Person Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLayout(new GridLayout(4, 2));

        // Create and add components
        add(new JLabel("Phone:"));
        phoneTextField = new JTextField();
        add(phoneTextField);

        add(new JLabel("Name:"));
        nameTextField = new JTextField();
        add(nameTextField);

        add(new JLabel("Email:"));
        emailTextField = new JTextField();
        add(emailTextField);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> savePerson());
        add(saveButton);

        // Display the form
        setVisible(true);
    }
    public String validate(String input) {
        if (input == null || (!input.contains(".") && !input.contains("@"))) {
            return input;
        } else {
            return null; // Invalid string
        }
    }


    public String validateEmail(String input){
        if (input == null || (input.contains(".") && input.contains("@"))) {
            return input;
        }else {
            return null;
        }
    }


    private void savePerson() {
        // Get values from the form
        String phone = validate(phoneTextField.getText());
        String name = validate(nameTextField.getText());
        String email = validateEmail(emailTextField.getText());

        if(phone == null || name == null || email == null){
            JOptionPane.showMessageDialog(this, "please do not use . or @");
            return;

        }

        // Create a Person object
        EntityModel person = new Person(phone, name, email);
        DatabaseConnectionHandler databaseConnectionHandler = new DatabaseConnectionHandler();
        databaseConnectionHandler.insertData(person, null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PersonForm());
    }
}
