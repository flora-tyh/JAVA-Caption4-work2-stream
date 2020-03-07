package com.thoughtworks;

public class Trader implements Comparable<Trader>{

  private final String name;
  private final String city;

  public Trader(String n, String c) {
    this.name = n;
    this.city = c;
  }

  public String getName() {
    return this.name;
  }

  public String getCity() {
    return this.city;
  }

  public String toString() {
    return "Trader:" + this.name + " in " + this.city;
  }

  @Override
  public int compareTo(Trader o) {
    return this.getName().compareTo(o.getName());
  }
}
