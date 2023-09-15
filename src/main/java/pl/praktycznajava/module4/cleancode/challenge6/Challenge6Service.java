package pl.praktycznajava.module4.cleancode.challenge6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Challenge6Service {

    // ---------------------------------------------------------------------------------------------
    // Challenge 6. Zrefaktoryzuj ciało poniższej metody w taki sposób, aby była jasna i czytelna.
    //              Zwróć uwagę na to, aby rozdzielić obsługę błędów od zwykłego przetwarzania.
    // --------------------------------------------------------------------------------------

    public void readFile() {
        String filePath = "path/to/your/file.txt";
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

}
