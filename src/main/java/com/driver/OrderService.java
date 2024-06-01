package com.driver;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository = new OrderRepository();

    public void addOrder(Order order){
        orderRepository.saveOrder(order);
    }

    public void addPartner(String partnerId){
        orderRepository.savePartner(partnerId);
    }

    public void addOrderPartnerPair(String orderId, String partnerId){
        orderRepository.addOrderPartnerMap(orderId, partnerId);
    }

    public Order getOrderById(String orderId){
        return orderRepository.getOrderById(orderId);
    }

    public DeliveryPartner getPartnerById(String partnerId){
        return orderRepository.getPartnerById(partnerId);
    }

    public int getOrderCountByPartnerId(String partnerId){
        return orderRepository.getOrderCountByPartnerId(partnerId);
    }

    public List<String> getOrdersByPartnerId(String partnerId){
        return orderRepository.getOrdersByPartnerId(partnerId);
    }

    public List<String> getAllOrders(){
        return orderRepository.getAllOrders();
    }
    
    public void deletePartnerById(String partnerId){
        orderRepository.deletePartnerById(partnerId);
    }

    public void deleteOrderById(String orderId){
        orderRepository.deleteOrderById(orderId);
    }

    public int getCountOfUnassignedOrders(){
        return orderRepository.getCountOfUnassignedOrders();
    }

    public int getOrdersLeftAfterGivenTimeByPartnerId(String time, String partnerId){
        //        String s1 = String.valueOf(time.charAt(0) + time.charAt(1));
        //        String s2 = String.valueOf(time.charAt(3) + time.charAt(4));
        //        int hh = Integer.valueOf(s1);
        //        int mm = Integer.valueOf(s2);

        String arr[] = time.split(":");
        int hh = Integer.parseInt(arr[0]);
        int mm = Integer.parseInt(arr[1]);
        int timeInt = (hh*60)+mm;
        int count = orderRepository.getOrdersLeftAfterGivenTimeByPartnerId(timeInt, partnerId);
        return count;
    }

    public String getLastDeliveryTimeByPartnerId(String partnerId){
        int timeInt = orderRepository.getLastDeliveryTimeByPartnerId(partnerId);
        int hh = timeInt/60;
        int mm = timeInt%60;
        String HH = String.valueOf(hh);
        if(HH.length()==1){
            HH = '0' + HH;
        }
        String MM = String.valueOf(mm);
        if(MM.length()==1){
            MM = '0'+MM;
        }

        String time = HH + ":" + MM;
        return time;
    }
}
