
/** this program uses Java ArrayList implementation to organize a list of Strings into lexicographical order. **/

import java.util.*;

public class arrayListOrganizer {

    // DECLARING VARIABLES
    private String[] list;
    int currentSize;

    public static void main(String[] args) { // MAIN METHOD

        arrayListOrganizer gameList = new arrayListOrganizer(); // CREATING AN INSTANCE OF THE CLASS

        // ADDING GAMES INTO ARRAYLIST
        gameList.add(0, "Fortnite");
        gameList.add(1, "FIFA 23");
        gameList.add(2, "Call of Duty: Modern Warfare");
        gameList.add(3, "NBA 2K23");
        gameList.add(4, "Minecraft");
        gameList.add(5, "Street Fighter II");
        gameList.add(6, "Fallout 2");
        gameList.add(7, "Borderlands 2");
        gameList.add(8, "Overwatch");
        gameList.add(9, "Red Dead Redemption II");
        gameList.add(10, "Grand Theft Auto V");
        gameList.add(11, "Call of Duty: Black Ops III");
        gameList.add(12, "The Legend of Zelda");
        gameList.add(13, "Super Smash Bros. Ultimate");
        gameList.add(14, "Assassin's Creed II");
        gameList.add(15, "The Last of Us");
        gameList.add(16, "Resident Evil 4");
        gameList.add(17, "Halo 2");
        gameList.add(18, "Undertale");
        gameList.add(19, "Final Fantasy XIV");

        System.out.println("List before sorting: " + gameList.toString());
        gameList.bubbleSort(); // calling sort method onto list object created
        System.out.println();
        System.out.println("List after sorting: " + gameList.toString());


    }

    // CONSTRUCTOR
    public arrayListOrganizer() {
        final int INITIAL_SIZE = 20;
        list = new String[INITIAL_SIZE]; // INITIALIZING LIST TO 20 SPOTS
        int currentSize = 0; // KEEPS TRACK OF THE NUMBER OF ELEMENTS IN THE LIST

    }

    // CHECKS THAT OUR ARRAYLIST IS WITHIN THE BOUNDS OF AVAILABLE SPOTS TO ADD MORE ELEMENTS
    private void checkBounds(int n) {
        if (n < 0 || n >= currentSize)
            throw new IndexOutOfBoundsException();
    }


    // DOUBLES THE SIZE OF THE LIST IF WE REACH MAXIMUM CAPACITY OF THE LIST
    public void growListIfNecessary() {
        if (currentSize >= list.length) {
            String[] newlist = new String[2 * list.length];
            for (int i = 0; i < list.length; i++) {
                newlist[i] = list[i];
            }
            list = newlist;
        }
    }

    // ADDS ELEMENTS USING POSITION AND THE STRING FORM OF OUR VIDEO GAME
    public boolean add(int pos, String newElement) {
        growListIfNecessary();
        currentSize++;
        checkBounds(pos);
        for (int i = currentSize - 1; i > pos; i--) {
            list[i] = list[i - 1];
        }
        list[pos] = newElement;
        return true;
    }

    // ALLOWS YOU TO ACCESS THE ELEMENT IN THE POSITION YOU HAVE SPECIFIED
    public Object get(int pos){
        checkBounds(pos);
        return list[pos];
    }

    // BUBBLE SORT TECHNIQUE
    public void bubbleSort() {
        int n = list.length;
        String temp = null;

        // EACH ELEMENT ADDED WILL BE COMPARED TO ITS NEXT ELEMENT - SWAPS BASED ON ALPHABETICAL ORDER
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n-i); j++) {
                if (list[j-1] == null  || list[j] == null){ // IF EITHER ELEMENTS ARE NULL - DON'T COMPARE
                    return;
                }
                if (list[j-1].compareTo( list[j]) > 0 ) {
                    temp = list[j-1];
                    list[j-1] = list[j];
                    list[j] = temp;
                }
            }
        }
    }

    // RETURNS THE STRING FORM OF THE ARRAYLIST
    public String toString() {
        return Arrays.toString(list);
    }

} // ENDS CLASS


