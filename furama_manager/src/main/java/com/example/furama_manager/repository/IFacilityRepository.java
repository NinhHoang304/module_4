package com.example.furama_manager.repository;

import com.example.furama_manager.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IFacilityRepository extends JpaRepository<Facility, Integer> {
    @Query(value = "select facility.* \n" +
            "from `facility` join `facility_type`\n" +
            "on facility.facility_type_id = facility_type.id\n" +
            "where facility.name like concat('%',:name,'%')\n" +
            "and facility_type.name like concat('%',:facilityTypeName,'%') and deleted = false"
            , nativeQuery = true)
    Page<Facility> getAllFacilityByQuery(@Param("name") String name, @Param("facilityTypeName") String facilityTypeName, Pageable pageable);
    @Query(value = "select * from facility where name like concat('%',:name,'%') and facility_type_id like concat('%',:id,'%') and deleted = false", nativeQuery = true)
    Page<Facility> findByNameAndFacilityTypeAndDeletedFalse(@Param("name") String name,@Param("id") String id, Pageable pageable);
}
