package com.shulpin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name="cargo")
public class Cargo implements Serializable {

    private static final long serialVersionUID = -5527566248002296042L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "destination_city")
    private String destinationCity;

    @Column(name = "date_of_shipment")
    private Date dateOfShipment;

    public Cargo() {
    }

    public Cargo(String productName, Double weight, String destinationCity, Date dateOfShipment) {
        this.productName = productName;
        this.weight = weight;
        this.destinationCity = destinationCity;
        this.dateOfShipment = dateOfShipment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public Date getDateOfShipment() {
        return dateOfShipment;
    }

    public void setDateOfShipment(Date dateOfShipment) {
        this.dateOfShipment = dateOfShipment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cargo cargo = (Cargo) o;

        if (!id.equals(cargo.id)) return false;
        if (productName != null ? !productName.equals(cargo.productName) : cargo.productName != null)
            return false;
        if (weight != null ? !weight.equals(cargo.weight) : cargo.weight != null) return false;
        if (destinationCity != null ? !destinationCity.equals(cargo.destinationCity) : cargo.destinationCity != null)
            return false;
        return dateOfShipment != null ? dateOfShipment.equals(cargo.dateOfShipment) : cargo.dateOfShipment == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (destinationCity != null ? destinationCity.hashCode() : 0);
        result = 31 * result + (dateOfShipment != null ? dateOfShipment.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", weight=" + weight +
                ", destinationCity='" + destinationCity + '\'' +
                ", dateOfShipment=" + dateOfShipment +
                '}';
    }
}
