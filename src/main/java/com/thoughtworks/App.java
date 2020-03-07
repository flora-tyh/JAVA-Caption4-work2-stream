package com.thoughtworks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

  public static void main(String[] args) {
    // 以下是执行交易的交易员和发生的一系列交易,请为以下八个查询方法提供实现。
    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");
    List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
        new Transaction(raoul, 2012, 1000),
        new Transaction(raoul, 2011, 400),
        new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700),
        new Transaction(alan, 2012, 950)
    );

    // 1.找出2011年的所有交易并按交易额排序(从低到高)
    System.out.println(get2011Transactions(transactions));

    // 2.交易员都在哪些不同的􏱜城市工作过
    System.out.println(getTradersCity(transactions));

    // 3.查找所有来自于剑桥的交易员，并按姓名排序
    System.out.println(getCambridgeTraders(transactions));

    // 4.返回所有交易员的姓名字符串，按字母顺序排序
    System.out.println(getTradersName(transactions));

    // 5.有没有交易员是在米兰工作的
    System.out.println(hasMilanTrader(transactions));

    // 6.返回交易员是剑桥的所有交易的交易额
    System.out.println(getCambridgeTransactionsValue(transactions));

    // 7.所有交易中，最高的交易额是多少
    System.out.println(getMaxTransactionValue(transactions));

    // 8.返回交易额最小的交易
    System.out.println(getMinTransaction(transactions));
  }

  public static List<Transaction> get2011Transactions(List<Transaction> transactions) {
    Stream<Transaction> transactions1 = transactions.stream().filter((Transaction t) -> t.getYear() == 2011);
    List<Transaction> transactionList = transactions1.collect(Collectors.toList());
    Collections.sort(transactionList);
    return transactionList;
  }

  public static List<String> getTradersCity(List<Transaction> transactions) {
    List<String> cities = new ArrayList<>();
    transactions.stream().distinct().forEach((Transaction t) -> cities.add(t.getTrader().getCity()));
    return cities;
  }

  public static List<Trader> getCambridgeTraders(List<Transaction> transactions) {
    List<Trader> traders = new ArrayList<>();
    traders = transactions.stream().filter((Transaction t) -> t.getTrader().getCity() == "Cambridge")
                         .map((Transaction t) -> t.getTrader()).distinct().collect(Collectors.toList());
    Collections.sort(traders);
    return traders;
  }

  public static List<String> getTradersName(List<Transaction> transactions) {
    List<String> names = new ArrayList<>();
    List<Trader> traders = new ArrayList<>();
    transactions.stream().forEach((Transaction t) -> traders.add(t.getTrader()));
    Collections.sort(traders);
    traders.stream().distinct().forEach((Trader t) -> names.add(t.getName()));
    return names;
  }

  public static boolean hasMilanTrader(List<Transaction> transactions) {
    boolean hasMilan = transactions.stream().filter((Transaction t) -> t.getTrader().getCity() == "Milan")
                                      .collect(Collectors.toList()).size() != 0;
    return hasMilan;
  }

  public static List<Integer> getCambridgeTransactionsValue(List<Transaction> transactions) {
    List<Integer> cambridgeValue = new ArrayList<>();
    transactions.stream().filter((Transaction t) -> t.getTrader().getCity() == "Cambridge")
            .forEach((Transaction t) -> cambridgeValue.add(t.getValue()));
    return cambridgeValue;
  }

  public static int getMaxTransactionValue(List<Transaction> transactions) {
    Collections.sort(transactions);
    return transactions.get(transactions.size() - 1).getValue();
  }

  public static Transaction getMinTransaction(List<Transaction> transactions) {
    Collections.sort(transactions);
    return transactions.get(0);
  }
}
