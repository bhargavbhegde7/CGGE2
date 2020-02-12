package de.cg.cgge.files;

import java.util.ArrayList;
import java.util.Arrays;

public class FileContents {

    private String splitter = ";";

    private ArrayList<String> contents = new ArrayList<>(); 

    /**
     * Creates a container for the contents, which makes it easy
     * @param contents The lines of the file
     */
    public FileContents(ArrayList<String> contents) {
        this.contents = contents; 
    }

    /**
     * 
     * @return Returns every line of the file as a String array
     */
    public String[] get() {
        return this.contents.toArray(new String[contents.size()]); 
    }

    /**
     * 
     * @return Returns every line of the file as an ArrayList of type string
     */
    public ArrayList<String> getArrayList() {
        return this.contents;
    }

    /**
     * Sets the lines of the file
     * @param contents A string array
     */
    public void set(String[] contents) {
       this.contents = (ArrayList<String>) Arrays.asList(contents);
    }

    /**
     * Sets the lines of the file
     * @param contents An ArrayList of type String
     */
    public void set(ArrayList<String> contents) {
        this.contents = contents; 
    }

    /**
     * Prints every line of the file
     */
    public void print() {
        for (String str : contents) {
            System.out.println(str);
        }
    }

    /**
     * Edit a specific line
     * @param line The line index
     * @param newString The new string, that should be applied to the line
     */
    public void edit(int line, String newString) {
        contents.set(line, newString);
    }

    /**
     * Append a line to the current contents
     * @param str The line to be appended
     */
    public void append(String str) {
        contents.add(str); 
    }

    public void setTableSplitter(String splitter) {
        this.splitter = splitter; 
    }

    public String getFromTableSection(int row, int column) {
        row--;
        column--;
        return get()[row].split(splitter)[column];
    }

    public String[] getFromTableRow(int row) {
        return get()[row].split(splitter);
    }

    public String getFromKeyword(String keyword) {

        for (String row : get()) {
            String[] columns = row.split(": ");
            if (columns[0].equals(keyword)) {
                return columns[1];
            }
        }

        return null; 
    }
}