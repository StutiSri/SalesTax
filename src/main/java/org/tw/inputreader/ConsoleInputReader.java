package org.tw.inputreader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

//Th
public class ConsoleInputReader implements InputReader {

    private BufferedReader bufferedReader;

    public ConsoleInputReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    @Override
    public ArrayList<String> read() {
        ArrayList<String> input = new ArrayList<>();
        try {
            String line = bufferedReader.readLine();
            if (line == null || line.length() == 0)
                return null;
            while (line.length() != 0) {
                input.add(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }
}
