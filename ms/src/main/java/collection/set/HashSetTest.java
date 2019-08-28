package collection.set;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {
    public static void main(String[] args) {

        HashSetPerson p1 = new HashSetPerson();
        p1.setIdCard("1234567890");

        HashSetPerson p2 = new HashSetPerson();
        p2.setIdCard("1234567890");

        Set<HashSetPerson> hashSet = new HashSet<HashSetPerson>();
        hashSet.add(p1);

        hashSet.add(p2);
        System.out.println(hashSet.size());

    }
}
