package ca.ubc.cs304.ui;

import ca.ubc.cs304.database.DatabaseConnectionHandler;
import ca.ubc.cs304.model.Listing;
<<<<<<< HEAD
=======
import ca.ubc.cs304.model.enums.ListingType;
import ca.ubc.cs304.model.enums.Province;
>>>>>>> 32d6cdbd087072e94376811cfdda7119f78abe7b

import javax.swing.*;
import java.awt.*;

public class ListingView extends JFrame {
    private JTextArea listingTextArea;
    private JButton backButton;

    private DatabaseConnectionHandler databaseConnectionHandler;

    public ListingView(Listing[] listings) {
        // Set up the frame
        setTitle("Listing View");
<<<<<<< HEAD
        setSize(600, 400);
        setResizable(false); // Restrict resizing
=======
        setSize(400, 400); // Set a more reasonable size
>>>>>>> 32d6cdbd087072e94376811cfdda7119f78abe7b
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        databaseConnectionHandler = new DatabaseConnectionHandler();

<<<<<<< HEAD
        // Create components
        listingTextArea = createStyledTextArea(listings);
        JScrollPane scrollPane = new JScrollPane(listingTextArea);
        backButton = createStyledButton("Back");

        // Set layout to null
        setLayout(null);

        // Add components to the frame manually
        scrollPane.setBounds(10, 10, 500, 300);
        add(scrollPane);

        backButton.setBounds(10, 320, 80, 30);
        add(backButton);
=======

        // Create components
        listingTextArea = createStyledTextArea(listings);
        listingTextArea.setBounds(800,1500,500,800);
        listingTextArea.setBackground(new Color(51, 153, 255));
        add(listingTextArea);
        backButton = createStyledButton("Back");

        JScrollPane scrollPane = new JScrollPane(listingTextArea);
        scrollPane.setBounds(0, 0, 1000, 1000);
        add(scrollPane);


        // Set layout manager
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 10, 10, 10); // Padding

        // Add components to the frame using GridBagConstraints
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 200;
        gbc.weighty = 0.0; // Allocate extra vertical space to the text area
        gbc.fill = GridBagConstraints.BOTH;
        add(listingTextArea, gbc);

        gbc.gridy = 1;
        gbc.weighty = 0.0; // Reset weighty for the button
        gbc.gridwidth = 1000;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(backButton, gbc);
        backButton.setSize(1000, 200); // Adjust the width and height according to your preference

>>>>>>> 32d6cdbd087072e94376811cfdda7119f78abe7b

        // Add action listener for the back button
        backButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Going back to the Search UI");
            setVisible(false);
            dispose();
        });
    }

    private JTextArea createStyledTextArea(Listing[] listings) {
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setForeground(Color.GREEN);
        textArea.setFont(new Font("Arial", Font.ITALIC, 20));

<<<<<<< HEAD
        int count =1;
        // Append information about each listing to the text area
        for (Listing listing : listings) {

            if(listing.active() == 1) {
                textArea.append("Listing" + count + " Info is below: " + "\n");
                textArea.append("ID: " + listing.listingID() + "\n");
                textArea.append("Address: " + listing.streetAddress() + "\n");
                textArea.append("Province: " + listing.province() + "\n");
                textArea.append("City: " + listing.cityName() + "\n");
                textArea.append("Type: " + listing.type() + "\n");
                textArea.append("Price: $" + listing.price() + "\n");
//                textArea.append("Active: " + (listing.active() == 1 ? "Yes" : "No") + "\n");
                textArea.append("\n");
                count++;
            }
=======
        listings = new Listing[1];
        Province province = Province.BRITISH_COLUMBIA;

        Listing dummylisting = new Listing(
                1,                  // listingID
                "123 Main St",      // streetAddress
                province,        // province
                "Vancouver",        // cityName
                ListingType.SALE,   // type
                500000,             // price
                1                   // active
        );

        listings[0] = dummylisting;

        int count =1;
        // Append information about each listing to the text area
        for (Listing listing : listings) {
            textArea.append("Listing"+count+" Info is below: "+"\n");
            textArea.append("ID: " + listing.listingID() + "\n");
            textArea.append("Address: " + listing.streetAddress() + "\n");
            textArea.append("Province: " + listing.province() + "\n");
            textArea.append("City: " + listing.cityName() + "\n");
            textArea.append("Type: " + listing.type() + "\n");
            textArea.append("Price: $" + listing.price() + "\n");
            textArea.append("Active: " + (listing.active() == 1 ? "Yes" : "No") + "\n");
            textArea.append("\n");
            count++;
>>>>>>> 32d6cdbd087072e94376811cfdda7119f78abe7b
        }

        return textArea;
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(0, 102, 204)); // Dark blue background
        button.setForeground(Color.BLACK);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setFocusPainted(false); // Remove focus border for better appearance
        return button;
    }

    public void display() {
        getContentPane().setBackground(new Color(51, 153, 255)); // Light blue background
        setVisible(true);
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DatabaseConnectionHandler connectionHandler = new DatabaseConnectionHandler();
            Listing[] listings = connectionHandler.getListingInfo();

            ListingView listingView = new ListingView(listings);
            listingView.display();
        });
    }
}

