package com.example.google.journal_app.helpers;

import android.app.Activity;
import android.content.Context;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class InputValidation {
    // 1.
    private Context context;

    public InputValidation(Context context) {
        this.context = context;
    }

    public boolean isETFilledPassword(EditText editText,  EditText etPassword, String message) {
        String value = editText.getText().toString().trim();
        if (value.isEmpty()) {
            editText.setError(message);
            hideKeyboardFrom(editText);
            return false;
        } else {
            etPassword.setError(message);
        }

        return true;
    }

    public boolean isETFilledEmail(EditText editText, EditText etEmail, String message) {
        String value = editText.getText().toString().trim();
        if (value.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(value).matches()) {
            editText.setError(message);
            hideKeyboardFrom(editText);
            return false;
        } else {
            etEmail.setError(message);
        }
        return true;
    }

    public boolean isInputEditTextMatches(EditText EditText1, EditText EditText2, EditText EditText, String message) {
        String value1 = EditText1.getText().toString().trim();
        String value2 = EditText2.getText().toString().trim();
        if (!value1.contentEquals(value2)) {
            EditText.setError(message);
            hideKeyboardFrom(EditText2);
            return false;
        } else {
            EditText.setError(message);
        }
        return true;
    }

    private void hideKeyboardFrom(View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }
}