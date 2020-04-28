package com.cognizant.bloodbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.bloodbank.model.SlotBooking;

@Repository
public interface SlotBookingRepository extends JpaRepository<SlotBooking, Integer> {
	@Query(value = "select COUNT(sb_id) from slot_booking where sb_ho_id =?1 and sb_sl_id = ?2 and sb_date = ?3",nativeQuery = true)
	public int checkSlot(int hospitalId, int slotId, String dateString);


}
