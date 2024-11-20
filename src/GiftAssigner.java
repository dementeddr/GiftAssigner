import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GiftAssigner {

    public static String[][] people = {{"Alice", "Bob"}, {"Carol", "Dave"}, {"Eve", "Faythe"}, {"Grandma"}};
    public static String[] categories = {"Something Consumable", "Something Handmade", "Something Useful", "Something made of wood"};
    public static boolean mirrorSpouses = true;

    public static void main(String[] args) throws Exception {
        System.out.println("Starting assignment");

        // Get arrangement of people
        List<String> arrangement;

        if (countPeople(people) % 2 != 0 || !mirrorSpouses) {
            System.out.println("Unmirrored Arrangement");

            arrangement = arrangeUnmirrored(people);
        } else {
            System.out.println("Mirrored Arrangement");

            arrangement = arrangeMirrored(people);
        }

        // Organize categories
        var catDirections = new ArrayList<String>(Arrays.asList(categories));

        for (int i = catDirections.size(); i < arrangement.size() - 1; i++) {
            catDirections.add("");
        }
        
        shuffle(catDirections);

        if (mirrorSpouses && catDirections.size() % 2 == 1 && catDirections.contains("")) {
            int index = 0;

            for (; index < catDirections.size(); index++) {
                if (catDirections.get(index) == "")
                    break;
            }

            int mid = catDirections.size()/2;
            String swap = catDirections.get(mid);
            catDirections.set(mid, catDirections.get(index));
            catDirections.set(index, swap);
        } 

        // Assign categories and output
        System.out.println("Arrangement:");

        for (int i = 0; i < arrangement.size(); i++) {

            System.out.printf("%d. %s:\n", i, arrangement.get(i));

            for (int j = 0; j < catDirections.size(); j++) {

                String category = catDirections.get(j);

                if (category == "")
                    continue;

                int index = (i + j + 1) % (arrangement.size());
                String recipient = arrangement.get(index);

                System.out.printf("\t%s <- %s\n", recipient, category);
            }
        }
    }


    public static List<String> arrangeMirrored(String[][] people) {
        int pairCount = countPeople(people) / 2;
        var arrangement = Arrays.asList(new String[pairCount * 2]);
        var peopleList = Arrays.asList(people);
        Random rnd = ThreadLocalRandom.current();

        shuffle(peopleList);

        for (int i = 0; i < pairCount; i++) {
            int a = rnd.nextInt(1);
            int b = (a + 1) % 2;
            String[] pair = peopleList.get(i);

            arrangement.set(i, pair[a]);
            arrangement.set(i + pairCount, pair[b]);
        }

        return arrangement;
    }
 
    
    public static List<String> arrangeUnmirrored(String[][] people) {
        var arrangement = new ArrayList<String>();

        for (String[] group : people) {
        
            for (String person : group) {
                arrangement.add(person);
            }
        }

        shuffle(arrangement);

        return arrangement;
    }


    public static int countPeople(String[][] people) {

        int totalPeople = 0;

        for (int i = 0; i < people.length; i++) {
            totalPeople += people[i].length;
        }

        return totalPeople;
    }


    public static <T> void shuffle(List<T> list) {

        Random rnd = ThreadLocalRandom.current();

        for (int i = list.size() - 1; i > 0; i--) {
            int j = rnd.nextInt(i + 1);
            T swap = list.get(j);
            list.set(j, list.get(i));
            list.set(i, swap);
        }
    }
}
