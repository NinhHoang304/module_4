package com.example.furama_manager.repository;

import com.example.furama_manager.dto.IContractDto;
import com.example.furama_manager.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IContractRepository extends JpaRepository<Contract, Integer> {
    //    @Query(value = "select customer.name as customerName, facility.name as facilityName, contract.start_date as startDay, contract.end_date as endDay, contract.deposit as deposit, sum(ifnull(attach_facility.cost, 0) * ifnull(contract_detail.quantity, 0) + facility.cost) as total from contract left join facility on contract.facility_id = facility.id left join customer on contract.customer_id = customer.id left join contract_detail on contract_detail.contract_id = contract.id left join attach_facility on attach_facility.id = contract_detail.attach_facility_id group by contract.id", nativeQuery = true)
    @Query(value = "select contract.id                                                                                  as contractId,\n" +
            "        customer.name                                                                                as customerName,\n" +
            "       facility.name                                                                                as facilityName,\n" +
            "       contract.start_date                                                                          as startDate,\n" +
            "       contract.end_date                                                                            as endDate,\n" +
            "       contract.deposit                                                                             as deposit,\n" +
            "       (sum(ifnull(attach_facility.cost, 0) * ifnull(contract_detail.quantity, 0) + facility.cost)) as total\n" +
            " from `contract`\n" +
            "         left join `facility` on contract.facility_id = facility.id\n" +
            "         left join `customer` on contract.customer_id = customer.id\n" +
            "         left join `contract_detail` on contract_detail.contract_id = contract.id\n" +
            "         left join `attach_facility` on attach_facility.id = contract_detail.attach_facility_id\n" +
            " group by contract.id",
            nativeQuery = true)
    Page<IContractDto> getAllContracts(Pageable pageable);
}
