package com.foodApp.model;
import java.util.HashMap;
import java.util.Map;

import com.foodApp.model.CartItem;

public class Cart {
	private Map<Integer,CartItem> items;
	public Cart() {
		this.items=new HashMap<>();
	}
	
	public void addItem(CartItem item) {
		int itemId=item.getItemId();
		if(items.containsKey(itemId)) {
			CartItem existingItem=items.get(itemId);
			existingItem.setQuantity(existingItem.getQuantity() + item.getQuantity());
		}
		else {
			items.put(itemId, item);
		}
	}
	public void updateItem(int itemId, int quantity) {
		if(items.containsKey(itemId)) {
			if(quantity<=0) {
				items.remove(itemId);
			}
			else {
				CartItem existingCartItem=items.get(itemId);
				existingCartItem.setQuantity(quantity);
			}
		}
	}

	public void removeItem(int itemId) {
		//int itemId = item.getItemId();
		items.remove(itemId);
	}
	public Map<Integer,CartItem> getItems(){
		return items;
		
	}
	

}
