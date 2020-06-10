import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;

public class SimpleFileIO
{
    //private fields
    private DLCList<String> list;
    
    /**
     * Default constructor, reads the default input.txt file
     */
    public SimpleFileIO() {
        list = read("input.txt");
    }
    
    /**
     * Construcor for other files
     * @param Name of file to be read
     */
    public SimpleFileIO(String filename) {
        list = read(filename);
    }
    
    /**
     * Reads the specified file, and adds each line as a new element
     * Used in both constructors
     * @param Name of file to be read
     */
    private DLCList<String> read(String filename) {
        DLCList<String> returnList = new DLCList<String>();
        Charset charset = Charset.forName("US-ASCII");
        Path path = Paths.get(filename);
        try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
            String input = reader.readLine();
            while(input != null) {
                returnList.addLast(input);
                input = reader.readLine();
            }
        }
        catch(FileNotFoundException e) {
            System.err.println("File " + filename + " not found");
        }   
        catch(IOException e) {
            System.err.println("A problem was encountered while reading " +
                               filename);
        }
        return returnList;
    }
    
    /**
     * Modifies a list of integers, doubling each number
     * Used in createFile
     * @param The list of numbers, in String form, to be doubled
     */
    private DLCList<String> modify(DLCList<String> list) {
        DLCList<String> newList = new DLCList<String>();
        try{
            for(int i = 0; i < list.size(); i += 1) {
                String s = list.get(i);
                newList.addLast("" + (Integer.valueOf(s) * 2));
            }
        }
        catch(NumberFormatException e) {
            System.out.println(e);
        }
        return newList;
    }
    
    /**
     * Creates a new file of modified integers in String form
     * Returns a boolean, signifys success
     * @param The name of the new file to be created
     */
    public boolean createFile(String filename) {
        boolean success = false;
        list = modify(list);
        try(FileWriter writer = new FileWriter(filename)) {
            for(int i = 0; i < list.size(); i += 1) {
                String s = list.get(i);
                writer.write(s);
                writer.write('\n');
            }
            success = true;
        }
        catch(IOException e) {
            System.err.println(e);
        }
        return success;
    }
    
    /**
     * Prints the list, which contains the current file
     */
    public void seeFile() {
        System.out.println(list);
    }
}