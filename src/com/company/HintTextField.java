package com.company;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Objects;

// klasa pozwalająca na tworzenie pól tekstowych z podpowiedzią

public class HintTextField extends JTextField implements FocusListener {

    public String hint; // zmienna zawierająca podpowiedź

    public HintTextField(final String hint) {
        super(hint);
        this.hint = hint;
        super.addFocusListener(this);
    }

    // metoda usuwająca podpowiedź kiedy pole jest zaznaczone
    @Override
    public void focusGained(FocusEvent e) {
        if(Objects.equals(this.getText(), hint)) {
            super.setText("");
        }
    }

    // metoda ustawiająca podpowiedź kiedy pole nie jest zaznaczone
    @Override
    public void focusLost(FocusEvent e) {
        if (this.getText().length() == 0) {
            super.setText(hint);
        }
    }
}
