package TryingNewThings;

import java.util.ArrayList;

public class Stringoperations {
    
    public static void printStringArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Index: " + i + " Wert: " + array[i]);
        }
    }

    public static String[] randomStringlist() {
        return new String[] { "hallo", "tag", "mein", "Mutter", "Anke", "HAupt", "Stephan", "Thore", "Jan", "Tobias" };
    }

    public static String[] splitStringsIntoWordArray(String[] inputArray){
        ArrayList<String> returntemp = new ArrayList<String>();
        String[] tempSubString; 
        for (int i = 0; i < inputArray.length; i++){
            tempSubString = inputArray[i].strip().split(" ", -1);
            for (int c = 0; c < tempSubString.length; c++){
                returntemp.add(tempSubString[c]);
            }

        }
        String[] outputarray = new String[returntemp.size()];
        for (int i = 0; i < returntemp.size(); i++){
            outputarray[i] = returntemp.get(i);
        }
        return outputarray;
    }

    public static String[] convertArrayListtoArray(ArrayList<String> inputArrayList){
        String[] output = new String[inputArrayList.size()];
        for(int i = 0; i < inputArrayList.size(); i++){
            output[i] = inputArrayList.get(i);
        }
        return output;
    }

    public static String[] removeSemantics(String[] inputArray){
        ArrayList<String> outputList = new ArrayList<String>();
        for(int i = 0; i < inputArray.length; i++){
            String string = inputArray[i].replaceAll(",", "").replaceAll(".", "");
            if(!string.equals("")) outputList.add(string);
        }
        
        return inputArray;
    }

}
