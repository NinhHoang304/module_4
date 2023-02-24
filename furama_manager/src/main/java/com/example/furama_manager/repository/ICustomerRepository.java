package com.example.furama_manager.repository;

import com.example.furama_manager.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "select customer.*\n" +
            "from `customer_type` join `customer` on customer_type.id = customer.customer_type_id \n" +
            "where customer.name like concat('%',:name, '%')\n" +
            "and customer.email like concat('%',:email, '%')\n" +
            "and customer_type.name like concat('%',:customerTypeName,'%') and deleted = false"
            , nativeQuery = true)
    Page<Customer> getCustomerByQuery(@Param("name") String name,@Param("email") String email,@Param("customerTypeName") String customerTypeName, Pageable pageable);
    Page<Customer> findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase(String name, String email, Pageable pageable);

    Page<Customer> findByCustomerTypeId(int customerTypeId, Pageable pageable);

    Customer findByIdCard(String idCard);

    Customer findByPhoneNumber(String phoneNumber);

    Customer findByEmail(String email);
}
