package com.example.demo2;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ContactsAppModificationController {

    @FXML    private ListView<Contact> booksListView;
    @FXML    private ImageView coverImageView;
    private Contact contactCurrent;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField phoneNumberTextField;


    @FXML
    void addButtonPressed(ActionEvent event) {
        try{
            if (validationFailed()){
                throw new NumberFormatException();
            }
            else{
                Contact obj1 = new Contact();
                obj1.setFirstName(firstNameTextField.getText());
                obj1.setLastName(lastNameTextField.getText());
                obj1.setEmail(emailTextField.getText());
                obj1.setPhoneNumber(phoneNumberTextField.getText());
                obj1.setImage("com/example/demo2/images/img1.png");
                contacts.add(obj1);
            }
        } catch (Exception ex){
            firstNameTextField.setText("");
            lastNameTextField.setText("");
            emailTextField.setText("");
            phoneNumberTextField.setText("");
            firstNameTextField.requestFocus();
        }
    }

    @FXML
    void deleteButtonPressed(ActionEvent event) {
        try {
            contacts.remove(contactCurrent);
        }
        catch (Exception ex){
            firstNameTextField.setText("");
            lastNameTextField.setText("");
            emailTextField.setText("");
            phoneNumberTextField.setText("");
            firstNameTextField.requestFocus();
        }
    }

    @FXML
    void updateButtonPressed(ActionEvent event) {
        try{
            if (validationFailed()){
                throw new NumberFormatException();
            }
            else{
                Contact obj1 = new Contact();
                contactCurrent.setFirstName(firstNameTextField.getText());
                contactCurrent.setLastName(lastNameTextField.getText());
                contactCurrent.setEmail(emailTextField.getText());
                contactCurrent.setPhoneNumber(phoneNumberTextField.getText());

            }
        } catch (Exception ex){
            firstNameTextField.setText("");
            lastNameTextField.setText("");
            emailTextField.setText("");
            phoneNumberTextField.setText("");
            firstNameTextField.requestFocus();
        }
    }
    public boolean validationFailed() {
        return (firstNameTextField.getText().trim().equals("") ||
                lastNameTextField.getText().trim().equals("") ||
                emailTextField.getText().trim().equals("") ||
                phoneNumberTextField.getText().trim().equals(""));
    }

    private final ObservableList<Contact> contacts = FXCollections.observableArrayList();

    public void initialize(){
        contacts.add(new Contact("Yoshida","Nao","nao.yoshida@gmail.com","+77785832723", "com/example/demo2/images/img1.png"));
        contacts.add(new Contact("Hirose ","Madoka","madoka.hirose@gmail.com","+77987235789", "com/example/demo2/images/img2.png"));
        contacts.add(new Contact("Tscuchiya","Ryota","ryotaaa@gmail.com","+77789432378", "com/example/demo2/images/img3.png"));
        contacts.add(new Contact("Hino","Tetsuo","hinoooo@gmail.com","+789782378945", "com/example/demo2/images/img4.png"));

        booksListView.setItems(contacts);

        booksListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Contact>() {
            @Override
            public void changed(ObservableValue<? extends Contact> observableValue, Contact oldValue, Contact newValue) {
                contactCurrent =newValue;
                coverImageView.setImage(new Image(newValue.getImage()));
                firstNameTextField.setText(newValue.getFirstName());
                lastNameTextField.setText(newValue.getLastName());
                emailTextField.setText(newValue.getEmail());
                phoneNumberTextField.setText(newValue.getPhoneNumber());
            }
        });
    }


}
