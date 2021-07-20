package com.github.juliocesarscheidt.domain;

import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ItemList {

  @XmlElement(name="item")
  private List<Item> itens;

  public ItemList(List<Item> itens) {
      this.itens = itens;
  }

  public ItemList() {
  }
}
