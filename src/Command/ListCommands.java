package Command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ListCommands {

    public static HashMap<String, List<String>> newHM = new HashMap<String, List<String>>();
    public static String[] array;
    public static List<String> arrayList;
    public static List<String> arrList;
    public static List<String> arrayL = new ArrayList<>();

    public static String rpush(String query) {
        array = query.split(" ");
        if (newHM.containsKey(array[1])) {
            arrayList = newHM.get(array[1]);
            for (int i = 2; i < array.length; i++) {
                arrayList.add(array[i]);
            }
        } else {
            arrayList = new ArrayList<>();
            for (int i = 2; i < array.length; i++) {
                arrayList.add(array[i]);
            }
            newHM.put(array[1], arrayList);
        }
//        newHM.entrySet().forEach(entry -> {
//                System.out.println(entry.getKey() + " " + entry.getValue());
//            });
        return String.valueOf(arrayList.size());
    }

    public static String lpush(String query) {
        array = query.split(" ");
        if (newHM.containsKey(array[1])) {
            arrList = newHM.get(array[1]);
            for (int i = 2; i < array.length; i++) {
                arrayL.add(array[i]);
            }
            arrList.addAll(0, arrayL);
        } else {
            arrList = new ArrayList<>();
            for (int i = 2; i < array.length; i++) {
                arrList.add(array[i]);
            }
            newHM.put(array[1], arrList);
        }
        newHM.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " " + entry.getValue());
        });
        return String.valueOf(arrList.size());
    }

    public static void rpop(String query) {
        array = query.split(" ");
        try {
            arrayL = newHM.get(array[1]);
            if (array.length == 2 && newHM.containsKey(array[1])) {
                String last = arrayL.get(arrayL.size() - 1);
                System.out.println(last);
                arrayL.remove(arrayL.size() - 1);
            } else if (array.length == 3 && newHM.containsKey(array[1])) {
                int index = Integer.parseInt(array[2]);
                for (int i = 0; i < index; i++) {
                    String last = arrayL.get(arrayL.size() - 1);
                    System.out.println(last);
                    arrayL.remove(arrayL.size() - 1);
                }
            } else {
                System.out.println("Enter right command");
            }
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Error");
        }
    }

    public static String lindex(String query) {
        array = query.split(" ");
        if (newHM.containsKey(array[1])) {
            arrayList = newHM.get(array[1]);
            try {
                if (Integer.parseInt(array[2]) >= 0) {
                    return arrayList.get(Integer.parseInt(array[2]));
                } else {
                    return arrayList.get(arrayList.size() + Integer.parseInt(array[2]));
                }
            } catch (IndexOutOfBoundsException e) {
                return "nil";
            }
        } else {
            return "Enter right command";
        }
    }

    public static void linsert(String query) {
        array = query.split(" ");
        try {
            if (newHM.containsKey(array[1]) && array[2].equals("before")) {
                arrayList = newHM.get(array[1]);
                arrayList.add(arrayList.indexOf(array[3]), array[4]);
                System.out.println(arrayList.size());
            }
            newHM.put(array[1], arrayList);
//            Iterator itr = arrayList.iterator();
//            while (itr.hasNext()) {
//                String aaa = (String) itr.next();
//                System.out.println(aaa);
//            }
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            System.err.println("Enter right command");
        }

    }

    public static void llen(String query) {
        array = query.split(" ");
        try {
            if (newHM.containsKey(array[1])) {
                arrayList = newHM.get(array[1]);
                System.out.println(arrayList.size());
            } else {
                System.out.println(0);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Right command");
        }
    }

    public static void lrenge(String query) {
        array = query.split(" ");
        try {
            if (newHM.containsKey(array[1]) && array.length == 4) {
                arrayList = newHM.get(array[1]);
                int first = Integer.parseInt(array[2]);
                int second = Integer.parseInt(array[3]);
                if (first < 0) {
                    first = arrayList.size() + first;
                }
                if (second < 0) {
                    second = arrayList.size() + second;
                }
                for (int i = first; i <= second; i++) {
                    System.out.println(arrayList.get(i));
                }
            } else {
                System.out.println("Error");
            }
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Right command");
        }
    }

    public static void lset(String query) {
        array = query.split(" ");
        try {
            if (newHM.containsKey(array[1]) && array.length == 4) {
                arrayList = newHM.get(array[1]);
                int first = Integer.parseInt(array[2]);
                if (first < 0) {
                    first = arrayList.size() + first;
                }
                arrayList.set(first, array[3]);
                System.out.println("ok");
            } else {
                System.out.println("Error");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Right command");
        }
    }
}
