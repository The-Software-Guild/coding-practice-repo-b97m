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
import java.util.Map;
import java.util.Optional;

public interface AddressBookDao {
    public void addAddress(Member member, Address addr);
    public Optional<Address> getAddressByMember(Member member);
    public Optional<Address> removeAddressByMember(Member member);
    public long getAddressTally();
    public Map<Member, Address> getAllAddresses();
}
