package com.driver;

public class Order {

    private String id;
    private int deliveryTime;

    public Order(String id, String deliveryTime) {
        // The deliveryTime has to converted from string to int and then stored in the attribute
        //deliveryTime  = HH*60 + MM
        this.deliveryTime = delivery(deliveryTime);
    }
    private int delivery(String deliveryTIme){
        List<String> list = ArrayList.asList(deliveryTime.split(":"));
        int HH = Integer.parseInt(list.get(0));
        int MM = Integer.parseInt(list.get(1));
        return HH*60 + MM;
    }
    public String getId() {
        return id;
    }

    public int getDeliveryTime() {return deliveryTime;}
}
