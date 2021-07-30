/**
 *
 * @author Benjamin Munoz
 * email: driver396@gmail.com
 * date: Jul 28, 2021
 * purpose: (TODO)
 */

package com.bm.addressbook.dto;

import java.util.Objects;


public class City {
    private String name, stateName, zipCode;

    public City(String name, String stateName, String zipCode) {
        this.name = name;
        this.stateName = stateName;
        this.zipCode = zipCode;
    }
    public String getName() {
        return name;
    }

    public String getStateName() {
        return stateName;
    }

    public String getZipCode() {
        return zipCode;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.name);
        hash = 37 * hash + Objects.hashCode(this.stateName);
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
        final City other = (City) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.stateName, other.stateName);
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s", name, stateName, zipCode);
    }
    
    
}
