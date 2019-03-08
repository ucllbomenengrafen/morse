package ui;

import domain.Morse;

public class MorseMain {


    public static void main(String[] args) {
        Morse morse = new Morse();
        try {
            System.out.println(morse.decodeSequence("....."));
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
