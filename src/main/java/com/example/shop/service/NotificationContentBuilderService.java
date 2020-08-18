package com.example.shop.service;


import com.example.shop.entity.Order;

public interface NotificationContentBuilderService {

	String buildNewOrderCreatedNotificationMessage(Order order);
}
