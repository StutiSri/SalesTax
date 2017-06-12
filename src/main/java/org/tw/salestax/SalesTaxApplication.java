package org.tw.salestax;

import org.tw.inputreader.ConsoleInputReader;
import org.tw.inputreader.InputReader;
import org.tw.outputwriter.ConsoleOutputWriter;
import org.tw.outputwriter.OutputWriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SalesTaxApplication {
    public static void main(String[] args) {
        InputReader inputReader = new ConsoleInputReader(new BufferedReader(new InputStreamReader(System.in)));
        OutputWriter outputWriter = new ConsoleOutputWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        new ReceiptGenerator().start(inputReader, outputWriter);
    }

}
