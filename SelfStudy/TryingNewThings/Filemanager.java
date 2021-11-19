package TryingNewThings;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Filemanager {

    public static String returnLineFromFile(String path, int line) {

        String returnString = "";
        int currentline = 1;

        try {
            File file = new File(path);
            Scanner filereader = new Scanner(file);

            while (filereader.hasNextLine() && currentline < line) {
                filereader.nextLine();
                currentline++;
            }

            if (filereader.hasNextLine()) {
                returnString = filereader.nextLine();
            } else {
                System.out.println("Error, file does not have this many lines. \n returned an empty String");
            }

            filereader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return returnString;
    }

    public static String[] getLinesFromFile(String path, int[] lines) {

        String[] returnlines = new String[lines.length];

        ArrayList<Integer> linesAL = new ArrayList<Integer>();
        ArrayList<Integer> linestemp = new ArrayList<Integer>();;
        ArrayList<int[]> multilines = new ArrayList<int[]>();;
        for (int line : lines) {
            linesAL.add(line);
        }
        linesAL.sort(null);
        int prevint = linesAL.get(0);
        linestemp.add(linesAL.get(0));
        for (int i = 1; i < linesAL.size(); i++) {
            if (prevint == linesAL.get(i)-1) {
                linestemp.add(linesAL.get(i));
                prevint = linesAL.get(i);
            }else{
                multilines.add(new int[]{linestemp.get(0),(linestemp.size())});
                linestemp.clear();
                linestemp.add(linesAL.get(i));
                prevint = linesAL.get(i);
            }
        }
        multilines.add(new int[] { linestemp.get(0), (linestemp.size()) });

        int currentline = 1;
        int currentindex = 0;
        int currentoutputline = 0;
        int line;
        try {
            File file = new File(path);
            Scanner filereader = new Scanner(file);
            while (currentindex < multilines.size()){
                line = multilines.get(currentindex)[0];
                
                while (filereader.hasNextLine() && currentline < line) {
                    filereader.nextLine();
                    currentline++;
                }

                for(int i = 0; i <multilines.get(currentindex)[1]; i++ ){
                    if (filereader.hasNextLine()) {
                        returnlines[currentoutputline] = filereader.nextLine();
                        currentoutputline++;
                        currentline++;
                    } else {
                        System.out.println("Error, file does not have this many lines. \n returned an empty String");
                    }
                }
                currentindex++;
            }
            filereader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        return returnlines;
    }

    public static String[] getLinesFromFile(String path, int line1, int line2) {

        String[] returnlines = new String[line2-line1];
        
        int currentline = 1;
        try {
            File file = new File(path);
            Scanner filereader = new Scanner(file);
            
            while (filereader.hasNextLine() && currentline < line1) {
                filereader.nextLine();
                currentline++;
            }

            for (int i = 0; i < (line2 - line1); i++) {
                if (filereader.hasNextLine()) {
                    returnlines[i] = filereader.nextLine();
                    currentline++;
                } else {
                    System.out.println("Error, file does not have this many lines. \n returned an empty String");
                }
            }
            filereader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return returnlines;
    }

    public static String[] getallLinesFromFile(String path){
        ArrayList<String> returnlines = new ArrayList<String>();
        String line;
        try {
            File file = new File(path);
            Scanner filereader = new Scanner(file);
            while (filereader.hasNextLine()) {
                line = filereader.nextLine();
                if(!line.equals("")) returnlines.add(line);
            }
            filereader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        String[] returnlinesArray = Stringoperations.convertArrayListtoArray(returnlines);

        return returnlinesArray;
    }

    public static boolean createFile(String path){
        try {
            File file = new File(path);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
            
            return true;
        }catch(IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
            return false;
        }
        
    }

    public static boolean writeToFile(String path, String input){
        try{
            FileWriter myWriter = new FileWriter(path);
            myWriter.write(input);
            myWriter.close();
        }catch(IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return true;
    }

    public static boolean writeToFile(String path, String[] inputarray, boolean newline){
        try {
            FileWriter myWriter = new FileWriter(path);
            
            for(String string : inputarray){
                if (newline) string += "\n";
                myWriter.write(string);
                
            }

            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return true;

    }

}


