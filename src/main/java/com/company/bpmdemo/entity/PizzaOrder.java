package com.company.bpmdemo.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@JmixEntity
@Table(name = "PIZZA_ORDER", indexes = {
        @Index(name = "IDX_PIZZA_ORDER_INITITOR", columnList = "INITIATOR_ID"),
        @Index(name = "IDX_PIZZA_ORDER_APPROVER", columnList = "APPROVER_ID"),
        @Index(name = "IDX_PIZZA_ORDER_ORDER_LINES", columnList = "ORDER_LINES_ID")
})
@Entity
public class PizzaOrder {
    @InstanceName
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private Integer id;

    @JmixGeneratedValue
    @Column(name = "UUID")
    private UUID uuid;

    @JoinColumn(name = "ORDER_LINES_ID")
    @OneToOne(fetch = FetchType.LAZY)
    private OrderLine orderLines;

    @JoinColumn(name = "INITIATOR_ID")
    @OneToOne(fetch = FetchType.LAZY)
    private User initiator;

    @JoinColumn(name = "APPROVER_ID")
    @OneToOne(fetch = FetchType.LAZY)
    private User approver;

    @Lob
    @Column(name = "STATUS")
    private String status;

    @Column(name = "DELIVERY_NUMBER")
    private String deliveryNumber;

    @Column(name = "OPENED")
    private LocalDateTime opened;

    @Column(name = "CLOSED")
    private LocalDateTime closed;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "pizzaOrder")
    private OrderLine orderLine;

    public OrderLine getOrderLine() {
        return orderLine;
    }

    public void setOrderLine(OrderLine orderLine) {
        this.orderLine = orderLine;
    }

    public void setOrderLines(OrderLine orderLines) {
        this.orderLines = orderLines;
    }

    public OrderLine getOrderLines() {
        return orderLines;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getClosed() {
        return closed;
    }

    public void setClosed(LocalDateTime closed) {
        this.closed = closed;
    }

    public LocalDateTime getOpened() {
        return opened;
    }

    public void setOpened(LocalDateTime opened) {
        this.opened = opened;
    }

    public String getDeliveryNumber() {
        return deliveryNumber;
    }

    public void setDeliveryNumber(String deliveryNumber) {
        this.deliveryNumber = deliveryNumber;
    }

    public User getApprover() {
        return approver;
    }

    public void setApprover(User approver) {
        this.approver = approver;
    }

    public User getInitiator() {
        return initiator;
    }

    public void setInitiator(User initiator) {
        this.initiator = initiator;
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