package at.ac.fhcampuswien.unittesting.password_validator_example;

import java.util.ArrayList;

public class PasswordValidator {
    private ArrayList<String> passwords = new ArrayList<>();


    public boolean isValid(String password){
        if(password == null){
            throw new IllegalArgumentException("Password cannot be null.");
        }
        return password.length() >= 5 && password.length() <= 10;
    }

    public String showMessage(boolean passwordIsValid){
        if(passwordIsValid){
            return "Login successful!";
        } else {
            return "Login failed. Password not valid.";
        }
    }

    public void savePassword(String password){
        passwords.add(password);
    }

    public ArrayList<String> getSavedPasswords(){
        return passwords;
    }

    public String findPasswordAtPosition(int index){
        if(index >= 0 && index < getSavedPasswords().size()){
            return getSavedPasswords().get(index);
        }
        return "";
    }
}
