package com.foodApp.dao;

import java.util.ArrayList;

import com.foodApp.model.OrderItem;

public interface orderItemDAO {
   ArrayList<OrderItem> getAllItems();
   OrderItem getOrderItemById(int itemId);
   void addItem(OrderItem itemId);
   void updateItem(OrderItem itemId);
   void deleteItemById(int itemId);
   
   

}
