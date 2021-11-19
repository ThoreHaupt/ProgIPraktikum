package TryingNewThings;

import java.util.ArrayList;
import java.util.HashMap;

public class Sort {

    public static String[] firstString(String s1, String s2) {

        // returns the alphabetically higher String
        char[] s1Array = s1.toLowerCase().toCharArray();
        char[] s2Array = s2.toLowerCase().toCharArray();
        int i = 0;
        String[] returnstring = new String[2];
        do {
            //System.out.println(s1Array[i] + ": " + (int) s1Array[i] + "| " + s2Array[i] + ": " + (int) s2Array[i]);
            if ((int) s2Array[i] < (int) s1Array[i]) {
                returnstring[0] = s2;
                returnstring[1] = s1;
            }
            if ((int) s1Array[i] < (int) s2Array[i]) {
                returnstring[0] = s1;
                returnstring[1] = s2;
            }
            if ((i + 1) == Math.min(s1Array.length, s2Array.length)) {
                if (s1Array.length < s2Array.length) {
                    returnstring[0] = s1;
                    returnstring[1] = s2;
                    ;
                } else {
                    returnstring[0] = s2;
                    returnstring[1] = s1;
                }
                break;
            } else {
                i++;
            }
        } while (s1Array[i - 1] == s2Array[i - 1]);
        return returnstring;
    }

    public static boolean firstStringbool(String s1, String s2) {

        // returns the alphabetically higher String
        char[] s1Array = s1.strip().toLowerCase().toCharArray();
        char[] s2Array = s2.strip().toLowerCase().toCharArray();
        int i = 0;
        boolean returnbool = false;
        do {
            //System.out.println(s1Array[i] + ": " + (int) s1Array[i] + "| " + s2Array[i] + ": " + (int) s2Array[i]);
            if ((int) s2Array[i] < (int) s1Array[i]) {
                returnbool = false;
                break;
            }
            if ((int) s1Array[i] < (int) s2Array[i]) {
                returnbool = true;
                break;
            }
            if ((i + 1) == Math.min(s1Array.length, s2Array.length)) {
                if (s1Array.length < s2Array.length) {
                    returnbool = true;
                    break;
                } else {
                    returnbool = false;
                    break;
                }
            } else {
                i++;
            }
        } while (s1Array[i - 1] == s2Array[i - 1]);
        return returnbool;
    }

    public static String[] orderStringArray(String[] inputarray) {

        String[] outputarray = new String[inputarray.length];
        ArrayList<String> templist = new ArrayList<String>();
        templist.add(inputarray[0]);
        int c = 0;

        for (int i = 1; i < inputarray.length; i++) {
            c = 0;
            // System.out.println("index:" + i + ": --------");
            while (firstStringbool(inputarray[i], templist.get(c))) {
                // System.out.println( inputarray[i] + ": true c:" + c);
                c++;
                if ((c) == templist.size()) {
                    break;
                }
            }
            templist.add(c, inputarray[i]);
            // System.out.println("added word at index:" + c + " word: " + inputarray[i]);
        }
        for (int i = 0; i < templist.size(); i++) {
            outputarray[outputarray.length - 1 - i] = templist.get(i);
        }

        return outputarray;
    }

    public static String[] radixsort(String[] Inputarray) {

        String[] outputarray = new String[Inputarray.length];
        HashMap<Character, Integer> counterrefference = new HashMap<Character, Integer>();
        int[] counterarray = new int[27];
        // fill counter
        {
            counterrefference.put('_', 0);
            for (int i = 0; i < 26; i++) {
                counterrefference.put((char) ((int) 'a' + i), i + 1);
                counterrefference.put(Character.toUpperCase((char) ((int) 'a' + i)), i + 1);
                // System.out.println((char)((int) 'a' + i));
            }
        }
        ;
        // addspaces to front of each String
        {
            int max = 0;
            String add = "_";
            for (int i = 0; i < Inputarray.length; i++) {
                Inputarray[i].strip();
                if (Inputarray[i].length() > max) {max = Inputarray[i].length();}
            }
            System.out.println(max);
            for (int i = 0; i < Inputarray.length; i++) {
                add = "";
                for (int c = 0; c < max - Inputarray[i].length(); c++) {
                    add += "_";
                }
                Inputarray[i] = Inputarray[i] + add;
            }
        }
        // the actual sorting algorythm
        for (int m = Inputarray[0].length() - 1; m >= 0; m--) {
            //System.out.println("m = " + m);
            //Stringoperations.printStringArray(Inputarray);
            for (int i = 0; i < Inputarray.length; i++) {
                
                counterarray[counterrefference.get(Inputarray[i].charAt(m))]++;
            }
            // Indexe in counterarray berechnen
            //System.out.println(" counterarray at Index( _ ): " + 0 + " = " + counterarray[0]);
            for (int i = 1; i < counterarray.length; i++) {
                counterarray[i] += counterarray[i - 1];
                //System.out.println(" counterarray at Index( "+ (char)((int)'a' + (i - 1)) + " ): " + i + " = " + counterarray[i]);
            }
            // Elemente dem outputArray an Index ablegen, der in counterrefference gegeben wurde
            
            
            for (int index = Inputarray.length - 1; index >= 0; index--) {
                
                //System.out.println("Inputarray[" + (counterarray[counterrefference.get(Inputarray[index].charAt(m))] - 1) + "] = " + Inputarray[index]);
                //System.out.println(Inputarray[index]);
                outputarray[--counterarray[counterrefference.get(Inputarray[index].charAt(m))]] = Inputarray[index]; 
                //System.out.println("outputarray[" + (counterarray[counterrefference.get(Inputarray[index].charAt(m))]) + "] = " + outputarray[index]);
                
            }
            
            Inputarray = outputarray.clone();
            counterarray = new int[27];
            

        }

        return outputarray;
    }

    public static String[] radixsortII(String[] Inputarray) {

        String[] outputarray = new String[Inputarray.length];
        HashMap<Character, Integer> counterrefference = new HashMap<Character, Integer>();
        String[] orderinfo = Filemanager.getallLinesFromFile("TryingNewThings/CharackterOrder.txt");
        int[] counterarray = new int[orderinfo.length];
        
        // fill counterrefferenceHashMap 
        {
            for (int i = 0; i < orderinfo.length; i++){
                for(char charakter : orderinfo[i].toCharArray()){
                    //System.out.println("matched charakter:" + charakter + " with Index:" + i);
                    counterrefference.put(charakter, i);
                }
            }   
        };
        
        // addspaces to front of each String, so that they all have the same lenght
        {
            int max = 0;
            String add = orderinfo[0];
            //finding the longest String in Inputarray
            for (int i = 0; i < Inputarray.length; i++) {
                Inputarray[i].strip();
                if (Inputarray[i].length() > max) {
                    max = Inputarray[i].length();
                }
            }
            //adding the first charakter from orderinfofile to fill all strings to same lenght
            for (int i = 0; i < Inputarray.length; i++) {
                add = "";
                for (int c = 0; c < max - Inputarray[i].length(); c++) {
                    add += orderinfo[0];
                }
                Inputarray[i] = Inputarray[i] + add;
            }
        };

        // the actual radixsort sorting algorythm
        for (int m = Inputarray[0].length() - 1; m >= 0; m--) {
            
            for (int i = 0; i < Inputarray.length; i++) {
                counterarray[counterrefference.get(Inputarray[i].charAt(m))]++;
            }
            // Indexe in counterarray berechnen
            for (int i = 1; i < counterarray.length; i++) {
                counterarray[i] += counterarray[i - 1];
            }
            // Elemente dem outputArray an Index ablegen, der in counterrefference gegeben
            // wurde

            for (int index = Inputarray.length - 1; index >= 0; index--) {

                // System.out.println("Inputarray[" +
                // (counterarray[counterrefference.get(Inputarray[index].charAt(m))] - 1) + "] =
                // " + Inputarray[index]);
                // System.out.println(Inputarray[index]);
                outputarray[--counterarray[counterrefference.get(Inputarray[index].charAt(m))]] = Inputarray[index];
                // System.out.println("outputarray[" +
                // (counterarray[counterrefference.get(Inputarray[index].charAt(m))]) + "] = " +
                // outputarray[index]);

            }

            Inputarray = outputarray.clone();
            counterarray = new int[orderinfo.length];

        }
        
        // removeing the temporary charakters
        {
            for (int i = 0; i< outputarray.length; i++) {
                outputarray[i] = outputarray[i].split(orderinfo[0])[0];
            }
        }
        return outputarray;
    }
}
