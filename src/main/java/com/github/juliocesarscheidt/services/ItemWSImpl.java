package com.github.juliocesarscheidt.services;

import java.util.ArrayList;
import java.util.List;

import com.github.juliocesarscheidt.domain.Item;
import com.github.juliocesarscheidt.domain.ItemList;
import com.github.juliocesarscheidt.interfaces.ItemWS;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;


@WebService
public class ItemWSImpl implements ItemWS {

	private List<Item> itensList = new ArrayList<>();

	public ItemWSImpl() {
		this.itensList.add(new Item(1, "Item 1", 59.90f));
		this.itensList.add(new Item(2, "Item 2", 49.90f));
		this.itensList.add(new Item(3, "Item 3", 39.90f));
		this.itensList.add(new Item(4, "Item 4", 29.90f));
	}
	
	@WebMethod(operationName="findOneItem")
	@WebResult(name="item")
	public Item findOne(int id) {
		Item selected = null;
		for (Item item: this.itensList) {
			if (item.getId() == id) {
				 selected = item;
				 break;
			}
		}
		return selected;
	}
	
	@WebMethod(operationName="findAllItem")
	@WebResult(name="itens")
	public ItemList findAll() {
		return new ItemList(this.itensList);
	}
	
	@WebMethod(operationName="createItem")
	@WebResult(name="created")
	public Item create(@WebParam(name="item") Item item) {
		this.itensList.add(item);
		return item;
	}

	@WebMethod(operationName="updateItem")
	@WebResult(name="updated")
	public Item update(@WebParam(name="item") int id, Item item) {
		Item selected = null;
		int index = 0;
		
		for (Item it: this.itensList) {
			if (it.getId() == id) {
				selected = it;
				index = this.itensList.indexOf(it);
				break;
			}
		}
		if (selected == null) {
			return selected;
		}
		
		selected.setId(item.getId());
		selected.setName(item.getName());
		selected.setPrice(item.getPrice());
		
		this.itensList.set(index, selected);
		
		return selected;
	}
	
	@WebMethod(operationName="deleteItem")
	@WebResult(name="deleted")
	public void delete(int id) {		
		for (Item item: this.itensList) {
			if (item.getId() == id) {
				int index = this.itensList.indexOf(item);
				this.itensList.remove(index);
				break;
			}
		}
	}
}
