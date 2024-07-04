package ru.home.work.shop.domain;

import ru.home.work.shop.domain.api.Decreasing;
import ru.home.work.shop.domain.api.Increasing;

import java.util.Objects;

public class WareHouseProduct implements Increasing, Decreasing { //сегрегация интерфейса
    private String name;
    private Long id;
    private Double price;
    private int count;
    private String producer;

    public WareHouseProduct() {
    }

    public WareHouseProduct(Long id, String name, String producer, Double price, Integer count) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.count = count;
        this.producer = producer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public void decrease() {
        count--;
    }

    @Override
    public void increase() {
        count++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopProduct that = (ShopProduct) o;
        return Objects.equals(getId(), that.getId()) &&  Objects.equals(getName(), that.getName()) && Objects.equals(getProducer(), that.getProducer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, producer);
    }
}
