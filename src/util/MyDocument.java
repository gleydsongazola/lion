/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Gleydson Israel
 */
public class MyDocument extends PlainDocument {

    private int maxLength = -1;

    public MyDocument(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        if (str.length() > this.maxLength) {
            str = str.substring(0, this.maxLength);
        }
        int size = this.getLength() + str.length();
        if (size <= this.maxLength) {
            super.insertString(offs, str, a);
        }
    }
}
