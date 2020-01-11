package date20200111;

import date20200110.SxtHsshMap1;

import java.util.HashMap;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/11
 * time        : 16:22
 * description :
 */
public class SxtHashSet {
    HashMap map;

    private static final Object PRSENT = new Object();
    public SxtHashSet() {
        map = new HashMap();
    }

    public int size() {
        return map.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");


        for (Object key : map.keySet()) {
            sb.append(key + ",");
        }
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public void add(Object o) {
        map.put(o, PRSENT);
    }

    public static void main(String[] args) {
        SxtHashSet set = new SxtHashSet();
        set.add("aaa");
        set.add("bbb");
        set.add("ccc");
        System.out.println(set);
    }
}
