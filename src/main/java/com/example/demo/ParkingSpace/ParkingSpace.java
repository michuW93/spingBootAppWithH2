package com.example.demo.ParkingSpace;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "parking_space")
public class ParkingSpace {
    @Id
    @GeneratedValue
    @Column(name = "parking_space_id")
    long parkingSpaceId;

    @NotNull
    @Column(name = "lot")
    String lot;
    @NotNull
    @Column(name = "location")
    String location;

    public ParkingSpace() {
    }

    public long getParkingSpaceId() {
        return parkingSpaceId;
    }

    public void setParkingSpaceId(long parkingSpaceId) {
        this.parkingSpaceId = parkingSpaceId;
    }

    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParkingSpace)) return false;
        ParkingSpace that = (ParkingSpace) o;
        return parkingSpaceId == that.parkingSpaceId &&
                lot.equals(that.lot) &&
                location.equals(that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parkingSpaceId, lot, location);
    }

    @Override
    public String toString() {
        return "ParkingSpace{" +
                "parkingSpaceId=" + parkingSpaceId +
                ", lot='" + lot + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
