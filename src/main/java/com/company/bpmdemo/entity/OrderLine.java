package com.company.bpmdemo.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;

import java.util.UUID;

@JmixEntity
@Table(name = "ORDER_LINE", indexes = {
        @Index(name = "IDX_ORDER_LINE_PIZZA_TYPE", columnList = "PIZZA_TYPE_ID"),
        @Index(name = "IDX_ORDER_LINE_PIZZA_EATER", columnList = "PIZZA_EATER_ID"),
        @Index(name = "IDX_ORDER_LINE_PIZZA_ORDER", columnList = "PIZZA_ORDER_ID")
})
@Entity
public class OrderLine {
    @InstanceName
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PIZZA_TYPE_ID")
    private PizzaType pizzaType;

    @Column(name = "SPECIAL_REQUIREMENTS")
    @Lob
    private String specialRequirements;

    @JoinColumn(name = "PIZZA_EATER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private User pizzaEater;

    @JmixGeneratedValue
    @Column(name = "UUID")
    private UUID uuid;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PIZZA_ORDER_ID")
    private PizzaOrder pizzaOrder;

    public PizzaOrder getPizzaOrder() {
        return pizzaOrder;
    }

    public void setPizzaOrder(PizzaOrder pizzaOrder) {
        this.pizzaOrder = pizzaOrder;
    }

    public User getPizzaEater() {
        return pizzaEater;
    }

    public void setPizzaEater(User pizzaEater) {
        this.pizzaEater = pizzaEater;
    }

    public String getSpecialRequirements() {
        return specialRequirements;
    }

    public void setSpecialRequirements(String specialRequirements) {
        this.specialRequirements = specialRequirements;
    }

    public PizzaType getPizzaType() {
        return pizzaType;
    }

    public void setPizzaType(PizzaType pizzaType) {
        this.pizzaType = pizzaType;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}