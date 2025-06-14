package com.foodApp.dao;


	import java.util.List;

	import com.foodApp.model.Orders;

	public interface orderDAO {
		List<Orders>getAllOrders();
		Orders getOrderById(int OrderId);
		 int addOrder(Orders or) ;
			
		
		void updateOrder(Orders or);
		void deleteOrder(int OrderId); 

}
