package fr.epita.assistants;

import fr.epita.assistants.myset.GenericSet;
import fr.epita.assistants.myset.IntegerSet;

public class Main {
    public static void main(String[] args) {
        IntegerSet my_set = new IntegerSet();
        my_set.insert(1);
        my_set.insert(2);
        System.out.println("My set contains " + my_set.size() + " element(s)");
        my_set.remove(3);
        my_set.remove(2);
        System.out.println("My set contains " + my_set.size() + " element(s)");
        my_set.insert(1);
        System.out.println(my_set.has(1));

        GenericSet<Integer> intSet = new GenericSet<>();
        intSet.insert(5);
        intSet.insert(2);
        intSet.insert(8);
        System.out.println("Integer Set Size: " + intSet.size()); // 3


        GenericSet<String> strSet = new GenericSet<>();
        strSet.insert("apple");
        strSet.insert("banana");
        strSet.insert("cherry");
        System.out.println("String Set Min: " + strSet.min()); // apple

        // Union of Two Sets
        GenericSet<Integer> anotherSet = new GenericSet<>();
        anotherSet.insert(3);
        anotherSet.insert(2);
        GenericSet<Integer> unionSet = GenericSet.union(intSet, anotherSet);
        System.out.println("Union Set Size: " + unionSet.size()); // 4
    }
}
