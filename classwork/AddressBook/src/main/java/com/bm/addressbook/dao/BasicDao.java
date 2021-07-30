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

package com.bm.addressbook.dao;

import com.bm.addressbook.dto.Address;
import com.bm.addressbook.dto.Member;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;


public class BasicDao implements AddressBookDao {
    private Map<Member, Address> aux;

    public BasicDao() {
        this.aux = new HashMap<>();
    }
    
    @Override
    public void addAddress(Member member, Address addr) {
        aux.put(member, addr);
    }

    @Override
    public Optional<Address> getAddressByMember(Member member) {
        Address retr = aux.get(member);
        return (retr == null) ? Optional.empty() : Optional.of(retr);
    }

    @Override
    public Optional<Address> removeAddressByMember(Member member) {
        Address retr = aux.remove(member);
        return (retr == null) ? Optional.empty() : Optional.of(retr);
    }

    @Override
    public long getAddressTally() {
        return aux.size();
    }

    @Override
    public Map<Member, Address> getAllAddresses() {
        return Map.copyOf(aux);
    }
}
