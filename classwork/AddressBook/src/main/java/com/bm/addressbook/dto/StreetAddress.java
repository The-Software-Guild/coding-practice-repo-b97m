/**
 *
 * @author Benjamin Munoz
 * email: driver396@gmail.com
 * date: Jul 28, 2021
 * purpose: (TODO)
 */

package com.bm.addressbook.dto;

import java.util.Objects;


public class StreetAddress {
    private String number, name;

    public StreetAddress(String number, String name) {
        this.number = number;
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.number);
        hash = 29 * hash + Objects.hashCode(this.name);
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
        final StreetAddress other = (StreetAddress) obj;
        if (!Objects.equals(this.number, other.number)) {
            return false;
        }
        return Objects.equals(this.name, other.name);
    }   

    @Override
    public String toString() {
        return String.format("%s %s", number, name);
    }
}
