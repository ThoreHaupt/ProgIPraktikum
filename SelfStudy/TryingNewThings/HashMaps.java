package TryingNewThings;

import java.util.HashMap;

public class HashMaps {
    
    public static HashMap<String, Person> peopleHash = new HashMap<String,Person>();

    public static void main(String[] args){
        HashMap<Integer, String> map = new HashMap<Integer, String>(); 

        map.put(3,"GutenTag!");
        Person[] people = new Person[4];
        people[0] = new Person();
        //String[] name1 = {"Herman","Biel"};
        people[1] = new Person(new String[]{"Herman","Biel"});
        people[2] = new Person(new String[] { "Anke", "Haupt" });
        people[3] = new Person(new String[] { "Thore", "Haupt" });
        
        addPersonHashfromArray(people);

        for (String name : peopleHash.keySet()) {
            System.out.println(name + ": "+ peopleHash.get(name));
        }
    }

    public static HashMap<String, Person> addPersonHashfromArray(Person[] list){
        for (Person person : list) {
           HashMaps.peopleHash.put(person.getStandardizedName(), person);
        }
        return HashMaps.peopleHash;
    }

    public static String firstString(String s1, String s2){

        //returns the alphabetically higher String
        int[] s1Array = s1.toCharArray();
        int[] s2Array = s2.toCharArray();
        int i = 0;
        while(s1Array[i] == s2Array[i]){
            if (s2Array[i] < s1Array[i]{
                return s2;
            }
            if (s1Array[i] < s2Array[i]){
                return s1;
            }
            if((i+1) == Math.min(s1Array.length, s2Array.length)){
                break;
            }else {i++;}
        
    }

}