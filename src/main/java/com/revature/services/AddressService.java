package com.revature.services;

import com.revature.dtos.AddressDTO;
import com.revature.models.Address;
import com.revature.models.User;

import java.util.Optional;

public interface AddressService {
    AddressDTO createAddress(Address address);
    void deleteAddressById(int id);
    Optional<Address> findByAll(Address address);
}
