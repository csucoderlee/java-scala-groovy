package org.csu.coderlee.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

  public static void main(String[] args) {

    Foo foo1 = new Foo();
    foo1.setName("foo1");
    Foo foo2 = new Foo();
    foo2.setName("foo2");

    List<Foo> list = new ArrayList<>();

    List<String> collect = list.stream().map(Foo::getName).collect(Collectors.toList());

    System.out.println(collect.size());

    list.add(foo1);

    List<String> collect1 = list.stream().map(Foo::getName).collect(Collectors.toList());

    System.out.println(collect1.size());

  }
}


class Foo {
  private String name;
  private Integer age;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }
}