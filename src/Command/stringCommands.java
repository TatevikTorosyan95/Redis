package Command;

import java.util.HashMap;

public class stringCommands {

    public static HashMap<String, String> newHM = new HashMap<String, String>();
    public static String[] array;

    public static String create(String query) {
        array = query.split(" ");
        if (array.length == 3) {
            newHM.put(array[1], array[2]);
        }
        return "OK";
    }

    public static String get(String query) {
        array = query.split(" ");
        String value = newHM.get(array[1]);

        if (array.length == 2 && newHM.containsKey(array[1])) {
            return value;
        } else if (array.length == 2 && !newHM.containsKey(array[1]))
            return "nil";
        else {
            return "There isn't such a key";
        }
    }

    public static String append(String query) {
        array = query.split(" ");
        if (array.length == 3 && newHM.containsKey(array[1])) {
            newHM.put(array[1], newHM.get(array[1]) + array[2]);
            int length = newHM.get(array[1]).length();
            return String.valueOf(length);
        } else if (array.length == 3 && !newHM.containsKey(array[1])) {
            int length = array[2].length();
            newHM.put(array[1], array[2]);
            return String.valueOf(length);
        } else {
            return "There isn't such a key";
        }
    }

    public static void decr(String query) {
        array = query.split(" ");
        int a = 0;
        try {
            if (array.length == 2 && newHM.containsKey(array[1])) {
                a = Integer.parseInt(newHM.get(array[1]));
                a--;
                newHM.put(array[1], String.valueOf(a));
                System.out.println(String.valueOf(a));
            } else {
                System.out.println("There isn't such a key");
            }

        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.err.println("Invalid string in argumment");
        }
    }


    public static void incr(String query) {
        array = query.split(" ");
        int a = 0;
        try {
            if (array.length == 2 && newHM.containsKey(array[1])) {
                a = Integer.parseInt(newHM.get(array[1]));
                a++;
                newHM.put(array[1], String.valueOf(a));
                System.out.println(String.valueOf(a));
            } else {
                System.out.println("There isn't such a key");
            }

        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.err.println("Invalid string in argumment");
        }
    }


    public static void mget(String query) {
        array = query.split(" ");

        for (int i = 1; i < array.length; i++) {
            if (newHM.containsKey(array[i])) {
                System.out.println(i + ") " + newHM.get(array[i]));
            } else if (!newHM.containsKey(array[i])) {
                System.out.println(i + ") nil");
            } else {
                System.out.println("There isn't such a key");
            }
        }

    }

}

