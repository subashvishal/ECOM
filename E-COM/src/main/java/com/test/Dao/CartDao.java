package com.test.Dao;

import java.util.List;

import com.test.model.CartItem;

public interface CartDao {
	public boolean addToCart(CartItem cartItem);
	public boolean deleteFromCart(CartItem cartItem);
	public boolean updateCart(CartItem cartItem);
	public CartItem getCartItem(int cartItemId);
	public List<CartItem> listCartItems(String username);
}
