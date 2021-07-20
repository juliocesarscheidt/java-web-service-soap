package com.github.juliocesarscheidt.interfaces;

import com.github.juliocesarscheidt.domain.Item;
import com.github.juliocesarscheidt.domain.ItemList;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public interface ItemWS {
  @WebMethod Item findOne(int id);
  @WebMethod ItemList findAll();
  @WebMethod Item create(Item item);
  @WebMethod Item update(int id, Item payload);
  @WebMethod void delete(int id);
}
