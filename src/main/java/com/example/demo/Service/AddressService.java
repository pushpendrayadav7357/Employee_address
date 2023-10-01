package com.example.demo.Service;

import com.example.demo.Entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Address getAddressById(Long id) {
        return addressRepository.findById(id).orElse(null);
    }

    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address updateAddress(Long id, Address address) {
        if (addressRepository.existsById(id)) {
            address.setId(id);
            return addressRepository.save(address);
        }
        return null;
    }

    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }
}
