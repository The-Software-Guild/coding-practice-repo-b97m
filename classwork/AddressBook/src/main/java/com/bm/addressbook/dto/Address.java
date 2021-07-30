/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Benjamin Munoz
 * email: driver396@gmail.com
 * date: Jul 28, 2021
 * purpose: (TODO)
 */

package com.bm.addressbook.dto;

import java.util.Objects;


public class Address {
    private StreetAddress streetAdddress;
    private City city;

    public Address(StreetAddress streetAdddress, City city) {
        this.streetAdddress = streetAdddress;
        this.city = city;
    }

    public StreetAddress getStreetAdddress() {
        return streetAdddress;
    }

    public City getCity() {
        return city;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.streetAdddress);
        hash = 47 * hash + Objects.hashCode(this.city);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Address other = (Address) obj;
        if (!Objects.equals(this.streetAdddress, other.streetAdddress)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        return true;
    }
}
