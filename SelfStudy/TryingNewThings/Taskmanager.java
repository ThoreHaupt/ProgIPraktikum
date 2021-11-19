package TryingNewThings;

public class Taskmanager{
    public static void main(String[] args){
        
        //Stringoperations.printStringArray(Filemanager.getallLinesFromFile("TryingNewThings/loremIpsum.txt"));
        //System.out.println(Filemanager.returnLineFromFile("TryingNewThings/test.txt", 3));

        //compareSortingalgorythems();
        Filemanager.createFile("TryingNewThings/sortedList.txt");
        Filemanager.writeToFile(
                "TryingNewThings/sortedList.txt", 
                Filemanager.getallLinesFromFile("TryingNewThings/test.txt"),
                true);
    }

    public static void compareSortingalgorythems(){
        
        String[] strings = Stringoperations.splitStringsIntoWordArray(Filemanager.getallLinesFromFile("TryingNewThings/loremIpsum.txt"));
        strings = Stringoperations.removeSemantics(strings);
        
        long current = System.nanoTime();
        Sort.orderStringArray(strings);
        double t1 = (System.nanoTime() - current)*Math.pow(10,-9);

        System.out.println("Sortmethod1 time in nanoseconds: " + t1);

        current = System.nanoTime();
        Sort.radixsortII(strings);
        double t2 = (System.nanoTime() - current) * Math.pow(10, -9);

        System.out.println("Sortmethod2 time in nanoseconds: " + t2);
    

        System.out.println("ratio: " + (double)(t1/t2));
    }

}
