package collection.set;

import java.util.Objects;


/**
 * 我们知道HashSet的元素不可重复，因此，在以上测试代码中，p1 与 p2对象是equals的，
 * 我们本来希望HashSet只保存其中一个对象， 但是，事与愿违，输出的结果却是2，
 * 说明hashSet把这两个对象都保存了。这是为什么呢？
 *
 * 我们结合一下HashMap来看吧，
 * 首先，由于我们没有重写Person的hashCode方法，会导致p1 与 p2的hash值不一致，
 * 这时， HashMap会把hash不一致的元素放在不同的位置，
 * 因此就产生了两个对象。那么，怎么改善？ 当然是重写hashCode方法了。
 *
 * 重写完后，我们再用上面的测试类测试，发现输出为1。OK，终于和我们的想法一致了。
 * 这就是为什么强烈推荐在重写equals方法的时候，同时重写hashCode方法的原因之一。
 */
public class HashSetPerson {
    //身份证
    private String idCard;

    private String name;

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HashSetPerson)) {
            return false;
        }
        HashSetPerson others = (HashSetPerson) obj;
        if (others.getIdCard().equals(idCard)) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCard, name);
    }
}
