package Command;

import java.util.*;

public class setCommands {
    public static HashMap<String, HashSet<String>> newHM = new HashMap<String, HashSet<String>>();
    public static String[] array;
    public static List<String> arrayList;
    public static HashSet<String> arrSet;
    public static HashSet<String> set = new HashSet<>();

    public static String sadd(String query) {
        array = query.split(" ");
        int b = 0;
        if (newHM.containsKey(array[1])) {
            arrSet = newHM.get(array[1]);
            for (int i = 2; i < array.length; i++) {
                if (!arrSet.contains(array[i])) {
                    b++;
                }
                arrSet.add(array[i]);
            }
        } else {
            arrSet = new HashSet<String>();
            for (int i = 2; i < array.length; i++) {
                arrSet.add(array[i]);
                b++;
            }
            newHM.put(array[1], arrSet);
        }
//        newHM.entrySet().forEach(entry -> {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        });
        return String.valueOf(b);
    }

    public static int scard(String query) {
        array = query.split(" ");
        if (newHM.containsKey(array[1])) {
            arrSet = newHM.get(array[1]);
            for (int i = 2; i < array.length; i++) {
                arrSet.add(array[i]);
            }
        } else {
            arrSet = new HashSet<String>();
            for (int i = 2; i < array.length; i++) {
                arrSet.add(array[i]);
            }
            newHM.put(array[1], arrSet);
        }
        return arrSet.size();
    }

    public static void sdiff(String query) {
        array = query.split(" ");
        Set one = new HashSet<>();
        Set two = new HashSet<>();
        if (newHM.containsKey(array[1]) && newHM.containsKey(array[2])) {
            one = newHM.get(array[1]);
            two = newHM.get(array[2]);
            one.removeAll(two);
        } else {
            System.out.println("Error");
        }

        Iterator itr = one.iterator();
        while (itr.hasNext()) {
            String a = (String) itr.next();
            System.out.println(a);
        }
    }

    public static void sdiffstore(String query) {
        array = query.split(" ");
        Set one = new HashSet<>();
        Set two = new HashSet<>();
        if (newHM.containsKey(array[1]) && newHM.containsKey(array[2])) {
            one = newHM.get(array[1]);
            two = newHM.get(array[2]);
            one.removeAll(two);
        } else {
            System.out.println("Error");
        }
        System.out.println(one.size());
    }

    public static void sismember(String query) {
        array = query.split(" ");
        if (newHM.containsKey(array[1])) {
            arrSet = newHM.get(array[1]);
            if (arrSet.contains(array[2])) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        } else {
            System.out.println("Error");
        }
    }

    public static void sunion(String query) {
        array = query.split(" ");
        Set one = new HashSet<>();
        Set two = new HashSet<>();
        if (newHM.containsKey(array[1]) && newHM.containsKey(array[2])) {
            one = newHM.get(array[1]);
            two = newHM.get(array[2]);
            one.addAll(two);
        } else {
            System.out.println("Error");
        }
        Iterator itr = one.iterator();
        while (itr.hasNext()) {
            String a = (String) itr.next();
            System.out.println(a);
        }
    }
}
