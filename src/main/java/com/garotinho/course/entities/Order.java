package com.garotinho.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.garotinho.course.entities.enums.OrderStatus;

// Um cliente pode ter varios pedidos
// Um pedido ta pra apenas um cliente.

@Entity
@Table(name = "tb_order")
public class Order implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "client_id") // Criando Chave Estrangeira 
    private User client;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant instant;
    private Integer orderStatus;
    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<OrderItem>();

    public Order(){}
    public Order(Long id, Instant instant, User client, OrderStatus orderStatus){
        this.id = id;
        this.instant = instant;
        this.client = client;
        setOrderStatus(orderStatus);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getClient() {
        return client;
    }

    public Instant getInstant() {
        return instant;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public void setInstant(Instant instant) {
        this.instant = instant;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }
    public void setOrderStatus(OrderStatus orderStatus) {
        if(orderStatus != null) this.orderStatus = orderStatus.getCode();
    }

    public Set<OrderItem> getItems() {
        return items;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Order other = (Order) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
}
