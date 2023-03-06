package com.revature.repositories;

import com.revature.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
   @Query(nativeQuery = true, value = "SELECT * FROM game.addresses a WHERE a.street = :street AND a.city = :city AND a.state = :state AND a.country = :country " +
           "AND a.zip_code = :zipCode")
    Optional<Address> findByMatch(@Param("street") String street, @Param("city") String city,
                                  @Param("state") String state, @Param("country") String country,
                                  @Param("zipCode") String zipCode);
}
