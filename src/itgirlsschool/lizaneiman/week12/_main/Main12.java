package _main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main12 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        try ( FileReader fileReader = new FileReader("src/itgirlsschool/lizaneiman/week12/data/file1.txt");
        FileWriter fileWriter = new FileWriter("src/itgirlsschool/lizaneiman/week12/data/file2.txt")) {
            int inChar = fileReader.read();
            while(inChar != -1) {
                sb.append((char) inChar);
                inChar = fileReader.read();
            }
            fileWriter.write(String.valueOf(sb));
        } catch (FileNotFoundException e){
            System.err.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
