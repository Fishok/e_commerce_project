package com.telran.shop.service;

import java.util.HashMap;
import java.util.List;

import com.telran.shop.entities.*;

public interface Shop {

	String addBrand(String nameBrand);
	String addCollection(String nameCollection);
	String addProduct(String productId, double price, String type, String nameCollection, String nameBrand,
			String size, String category, int discount, int amount);
	Product getProduct(String productId);
	Brand getBrand(String nameBrand);
	Collect getCollection(String nameCollection);
	String setProductPrice(String productId, double price);
	String setProductDiscount(String productId, int discount);
	String setProductAmount(String productId, int amount);
	String removeProduct(String productId);
	String removeCollection(String nameCollection);
	String removeBrand(String nameBrand);
	String addUser(String login, String password, String role, String firstName, String secondName,
			String email, String phoneNumber, String country, String address);
	User getUser(String login);
	String updateUser(String login, String password, String firstName, String secondName,
			String email, String phoneNumber, String country, String address);
	String updatePassword(String login, String old_password, String new_password, String new_password_check);
	String removeUser(String login, String password);
	String addProductToCart(String uuid, String productId);
	String removeProductFromCart(String uuid, String productId);
	String setAmountOfProductFromCart(String uuid, String productId);
	List<Cart> getAllCarts();
	Order addOrder(String uuid, HashMap<String, Integer> products);
	Order getOrderbyOrderId(String orderId);
	Order getOrderbyUserId(String uuid);
	List<Order> getAllOrders();
	List<Order> getAllOrdersByStatus(String status);
}
