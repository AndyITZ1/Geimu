package com.revature.services;

import com.revature.dtos.AddressDTO;
import com.revature.models.Address;
import com.revature.repositories.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService{
    private final AddressRepository addressRepository;

//    @Autowired
//    public AddressServiceImpl(AddressRepository addressRepository) {
//        this.addressRepository = addressRepository;
//    }

    public AddressDTO createAddress(Address address) {
        Address savedAddress = addressRepository.save(address);
        AddressDTO addressDTO = new AddressDTO(
                savedAddress.getStreet(),
                savedAddress.getCity(),
                savedAddress.getState(),
                savedAddress.getCountry(),
                savedAddress.getZipCode()
        );
        return addressDTO;
    }

    public void deleteAddressById(int id) {
        addressRepository.deleteById(id);
    }

    public Optional<Address> findByAll(Address address) {
//        System.out.println("I MADE IT THIS FAR, " + address.getCity());
        Optional<Address> addressOpt = addressRepository.findByMatch(address.getStreet(), address.getCity(), address.getState(),
                address.getCountry(), address.getZipCode());
//        if (addressOpt.isPresent()) {
//            System.out.println("ADDDRESSS: " + addressOpt.get());
//        }
        return addressOpt;
    }
}
