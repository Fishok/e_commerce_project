package com.project.api;

public interface ApiConstants {
    // Brand~~~~~~~~~~~~ // ~~~~~~~~~~~~~~~~~~~~~// ~~~~~~~~~~~~~~~~~
    String GET_BrandById = "/brand/get/byId";
    String GET_Brand = "/brand";
    String ADD_Brand = "/brand/add";
    String REMOVE_Brand = "/brand/remove";


    // Cart~~~~~~~~~~~~~~~~~~~~// ~~~~~~~~~~~~~~~~~~~~~~~~// ~~~~~~~~~~~~~~
    
    String GET_CartByUserId = "/cart/id";
    String ADD_ProductToCart = "/cart/add" ;
    String REMOVE_ProductFromCart = "/cart/remove";
    String SET_AmountOfProductFromCart = "/cart/set";
    
    
    // Collection~~~~~~~~~~~~~~~~// ~~~~~~~~~~~~~~~~~~~~~~// ~~~~~~~~~~~~~~~
    
    String ADD_Collection = "/collection/add" ;
    String REMOVE_Collection = "/collection/remove" ;
    String GET_CollectionById = "/collection/id";
    String GET_CollectionByName = "/collection/name";
    
    // Order ~~~~~~~~~~~~~~~~~// ~~~~~~~~~~~~~~~~~~~~ // ~~~~~~~~~~~~~~~
    
    String ADD_Order = "/order/add";
    String GET_OrderById = "/order/id";
    String GET_OrderByUserId = "/order/userId";// TODO ????
    String GET_OrdersByStatus = "/order/status" ;
    String GET_AllOrders = "/order/all";
    String SET_OrderStatus = "order/status/set";
    
    // Product ~~~~~~~~~~~~~~~~~ // ~~~~~~~~~~~~~~~~ // ~~~~~~~~~~~~~~~~~~
    
    String ADD_Product = "/product/add";
    String GET_ProductById = "/product/id";
    String SET_ProductPrice = "/product/price/set";
    String Set_ProductDiscount = "/product/discount/set";
    String SET_ProductAmount = "/product/amount/set";
    String DELETE_Product = "/product/remove";
    String GET_AllProducts = "/product/all";
    String GET_AllProductsByCollection = "/product/byCollection";
    String GET_AllProductsByBrand = "/product/byBrand";
    String GET_AllProductsByType = "/product/byType";
    
    // User ~~~~~~~~~~~~~~~~~~ // ~~~~~~~~~~~~~~ // ~~~~~~~~~~~~~~~~
    
    String GET_UserByUserName = "/user/name";
    String ADD_User = "/user/add";
    String SET_User = "/user/set";
    String DELETE_User = "/user/remove";
    String SET_Password = "/password/set";

    String GET_ExistsByEmail = "/user/email";
}
