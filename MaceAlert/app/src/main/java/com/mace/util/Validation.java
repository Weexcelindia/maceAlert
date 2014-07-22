package com.mace.util;

import java.util.regex.Pattern;

import android.widget.EditText;

import hugo.weaving.DebugLog;

public class Validation {

    // Regular Expression
    // you can change the expression based on your need
    private static final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String PHONE_REGEX = "\\d{3}\\d{7}";
    private static final String USERNAME_REGEX = "^[a-z0-9_-]{3,25}$";
    private static final String PASSWORD_REGEX="((?=.*\\d)(?=.*[a-z]).{6,20})";
    //(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}
    // Error Messages
    private static final String REQUIRED_MSG = "required";
    private static final String EMAIL_MSG = "invalid email";
    private static final String PHONE_MSG = "##########";
    private static final String PASSWORD_MSG = "Must contain 1 digit and 1 lowercase letter";

    // call this method when you need to check email validation

    /**
     *
     * @param editText
     * @param required true if this field should not be empty
     * @return
     */
    public static boolean isEmailAddress(EditText editText, boolean required) {
        return isValid(editText, EMAIL_REGEX, EMAIL_MSG, required);
    }

    // call this method when you need to check phone number validation
    public static boolean isPhoneNumber(EditText editText, boolean required) {
        return isValid(editText, PHONE_REGEX, PHONE_MSG, required);
    }

    // return true if the input field is valid, based on the parameter passed
    public static boolean isValid(EditText editText, String regex, String errMsg, boolean required) {

        String text = editText.getText().toString().trim();
        // clearing the error, if it was previously set by some other values
        editText.setError(null);

        if(!regex.equals(PASSWORD_REGEX))
        {// text required and editText is blank, so return false
            if ( required && !hasText(editText) ) return false;
        }else
        {
            if ( required && !hasTextna(editText) ) return false;
        }
        // pattern doesn't match so returning false
        if (required && !Pattern.matches(regex, text)) {
            editText.setError(errMsg);
            editText.requestFocus();
            return false;
        };

        return true;
    }

    // check the input field has any text or not
    // return true if it contains text otherwise false
    @DebugLog
    public static boolean hasText(EditText editText) {

        String text = editText.getText().toString().trim();
        editText.setError(null);
        // length 0 means there is no text
        if (text.length() == 0)
        {
                editText.setError(REQUIRED_MSG);
                editText.requestFocus();
                return false;
        }
        return true;
    }

    public static boolean hasTextna(EditText editText) {

        String text = editText.getText().toString().trim();
        editText.setError(null);

        // length 0 means there is no text
        if (text.length() == 0){
            editText.setError(REQUIRED_MSG);
            return false;
        }else if(text.length()<6)
        {
            editText.setError("Minimum 6 characters");
            return false;
        }else if( editText.getText().toString().contains(" "))
        {
            editText.setError("No spaces");
            return false;
        }

        return true;
    }

    /**Checks whether it has text or not
     * @param editText
     * @return
     */


    public static boolean hasTextusrname(EditText editText) {

        String text = editText.getText().toString().trim();
        editText.setError(null);

        // length 0 means there is no text
        if (text.length() == 0){
            editText.setError(REQUIRED_MSG);
            return false;
        }else if(editText.getText().toString().contains(" "))
        {
            editText.setError("No spaces");
            return false;
        }else if(!(Pattern.matches(USERNAME_REGEX,editText.getText().toString())))
        {
            editText.setError("Minimum 3 alpha numeric characters");
            return false;
        }

        return true;
    }

    public static boolean isPassword(EditText editText, boolean required) {
        return isValid(editText, PASSWORD_REGEX, PASSWORD_MSG, required);
    }

}