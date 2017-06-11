package org.tw.outputwriter;

import org.tw.inputreader.ConsoleInputReader;

import java.io.BufferedWriter;
import java.io.IOException;

public class ConsoleOutputWriter implements OutputWriter {

    private final BufferedWriter bufferedWriter;

    public ConsoleOutputWriter(BufferedWriter bufferedWriter){
        this.bufferedWriter = bufferedWriter;
    }

    @Override
    public void write(String output) {
        try {
            bufferedWriter.write(output);
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
