//package ca.ubc.cs304.ui;
//
//import ca.ubc.cs304.database.DatabaseConnectionHandler;
//import ca.ubc.cs304.model.entity.Listing;
//
//import javax.swing.*;
//import java.awt.*;
//
//public class ListingView extends JFrame {
//    private JTextArea listingTextArea;
//    private JButton backButton;
//
//    private DatabaseConnectionHandler databaseConnectionHandler;
//
//    public ListingView(Listing[] listings) {
//        // Set up the frame
//        setTitle("Listing View");
//        setSize(600, 400);
//        setResizable(false); // Restrict resizing
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        setLocationRelativeTo(null);
//
//        databaseConnectionHandler = new DatabaseConnectionHandler();
//
//        // Create components
//        listingTextArea = createStyledTextArea(listings);
//        JScrollPane scrollPane = new JScrollPane(listingTextArea);
//        backButton = createStyledButton("Back");
//
//        // Set layout to null
//        setLayout(null);
//
//        // Add components to the frame manually
//        scrollPane.setBounds(10, 10, 500, 300);
//        add(scrollPane);
//
//        backButton.setBounds(10, 320, 80, 30);
//        add(backButton);
//
//        // Add action listener for the back button
//        backButton.addActionListener(e -> {
//            JOptionPane.showMessageDialog(null, "Going back to the Search UI");
//            setVisible(false);
//            dispose();
//        });
//    }
//
//    private JTextArea createStyledTextArea(Listing[] listings) {
//        JTextArea textArea = new JTextArea();
//        textArea.setEditable(false);
//        textArea.setForeground(Color.GREEN);
//        textArea.setFont(new Font("Arial", Font.ITALIC, 20));
//
//        int count =1;
//        // Append information about each listing to the text area
//        for (Listing listing : listings) {
//
//            if(listing.active() == 1) {
//                textArea.append("Listing" + count + " Info is below: " + "\n");
//                textArea.append("ID: " + listing.listingId() + "\n");
//                textArea.append("Address: " + listing.streetAddress() + "\n");
//                textArea.append("Province: " + listing.province() + "\n");
//                textArea.append("City: " + listing.cityName() + "\n");
//                textArea.append("Type: " + listing.type() + "\n");
//                textArea.append("Price: $" + listing.price() + "\n");
////                textArea.append("Active: " + (listing.active() == 1 ? "Yes" : "No") + "\n");
//                textArea.append("\n");
//                count++;
//            }
//        }
//
//        return textArea;
//    }
//
//    private JButton createStyledButton(String text) {
//        JButton button = new JButton(text);
//        button.setBackground(new Color(0, 102, 204)); // Dark blue background
//        button.setForeground(Color.BLACK);
//        button.setFont(new Font("Arial", Font.BOLD, 16));
//        button.setFocusPainted(false); // Remove focus border for better appearance
//        return button;
//    }
//
//    public void display() {
//        getContentPane().setBackground(new Color(51, 153, 255)); // Light blue background
//        setVisible(true);
//    }
//
//
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            DatabaseConnectionHandler connectionHandler = new DatabaseConnectionHandler();
//            Listing[] listings = connectionHandler.getListingInfo();
//
//            ListingView listingView = new ListingView(listings);
//            listingView.display();
//        });
//    }
//}
package ca.ubc.cs304.ui;

import ca.ubc.cs304.database.DatabaseConnectionHandler;
import ca.ubc.cs304.model.ListingInfo;

import javax.swing.*;
import java.awt.*;

public class ListingView extends JFrame {
    private JTextArea listingTextArea;
    private JButton backButton;

    private JButton editButton;



    private DatabaseConnectionHandler databaseConnectionHandler;

    public ListingView(DatabaseConnectionHandler databaseConnectionHandler, ListingInfo listing) {
        // Set up the frame
        setTitle("Listing View");
        setSize(600, 600); // Adjusted size
        setResizable(true); // Restrict resizing
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        this.databaseConnectionHandler = databaseConnectionHandler;

        // Create components
        listingTextArea = createStyledTextArea(listing);
        backButton = createStyledButton("Back");
        editButton = createStyledButton("Edit");

        // Set layout to null
        setLayout(null);

        // Add components to the frame manually
        listingTextArea.setLayout(new BorderLayout());
        listingTextArea.setBounds(10, 10, 380, 400);
        add(listingTextArea);

        backButton.setBounds(10, 350, 80, 30);
        listingTextArea.add(backButton,BorderLayout.SOUTH);

        editButton.setBounds(100, 350, 80, 30);
        editButton.setVisible(true);
        listingTextArea.add(editButton,BorderLayout.SOUTH);


        // Add action listener for the back button
        backButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Going back to the Search UI");
            setVisible(false);
            dispose();
        });

        // Add action listener for the editButton
        editButton.addActionListener(e -> {
            new EditListingScreen(databaseConnectionHandler,listing.listingId()).setVisible(true);
        });




    }

    private JTextArea createStyledTextArea(ListingInfo listing) {
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setForeground(Color.GREEN);
        textArea.setFont(new Font("Arial", Font.ITALIC, 16)); // Adjusted font size


            textArea.append("Listing Info is below: " + "\n");
            textArea.append("ID: " + listing.listingId() + "\n");
            textArea.append("Address: " + listing.streetAddress() + "\n");
            textArea.append("Province: " + listing.province() + "\n");
            textArea.append("City: " + listing.cityName() + "\n");
            textArea.append("Type: " + listing.type() + "\n");
            textArea.append("Price: $" + listing.price() + "\n");
            textArea.append("DeveloperLicenseID: " + listing.developerLicenseID() + "\n");
            textArea.append("Strata Id: " + listing.strataID() + "\n");
            textArea.append("Homeowner Phone: " + listing.homeownerPhone() + "\n");
            textArea.append("Real Estate Agent Phone: "+listing.realEstateAgentPhone()+"\n");
            textArea.append("Bedrooms: "+listing.bedrooms()+"\n");
            textArea.append("Bathrooms: "+listing.bathrooms()+"\n");
            textArea.append("sizeInSqft: "+listing.sizeInSqft()+"\n");
            textArea.append("Active: " + (listing.hasAC() == 1 ? "Yes" : "No") + "\n");
            // textArea.append("Active: " + (listing.active() == 1 ? "Yes" : "No") + "\n");
            textArea.append("\n");

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
}
