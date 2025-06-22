package insight.set;

import java.util.HashSet;

/**
 * 装饰器模式实现的历史集合类
 */


public class Main {
    public static void main(String[] args) {
        HistorySet<String> historySet = new HistorySet<>(new HashSet<>());
        historySet.add("1");
        historySet.add("2");
        historySet.add("3");
        historySet.add("4");
        historySet.remove("2");
        historySet.remove("3");
        System.out.println(historySet);
    }
}
