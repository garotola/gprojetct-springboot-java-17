package com.garotinho.course.entities.enums;

public enum OrderStatus {
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int code;
    private OrderStatus(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    // Retorna o OrderStatus referent ao código passado no parâmetro
    public static OrderStatus valueOf(int code){
        for (OrderStatus orderStatus : OrderStatus.values()) {
            if(orderStatus.getCode() == code) return orderStatus;
        }
        throw new IllegalArgumentException("Código de Status Inválido");
    }
}
