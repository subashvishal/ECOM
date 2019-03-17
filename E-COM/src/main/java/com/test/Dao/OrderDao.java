package com.test.Dao;

import com.test.model.OrderDetails;

public interface OrderDao {

	public boolean receiptGenerate(OrderDetails orderDetail);
	public boolean updateCartItemStatus(String username);
}
