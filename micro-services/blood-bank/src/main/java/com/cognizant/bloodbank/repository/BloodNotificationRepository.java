package com.cognizant.bloodbank.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.bloodbank.model.BloodNotification;
import com.cognizant.bloodbank.model.User;


@Repository
public interface BloodNotificationRepository extends JpaRepository<BloodNotification, Integer>{
	
	@Query(value = "select * from user_notification inner join user on user_notification.un_us_id = user.us_id where us_username = ?1 and  un_status = 0 ORDER BY un_id DESC",nativeQuery = true)
	public Set<BloodNotification> getAllNotification(String userName);
	
	@Query(value = "select * from user_notification inner join user on user_notification.un_us_id = user.us_id where us_username = ?1 and  un_status = 1 ORDER BY un_id DESC",nativeQuery = true)
	public Set<BloodNotification> getAllNotificationHistory(String userName);
	
	public void deleteByUser(User user);
	
	@Query(value = "select count(un_id) from user_notification where un_us_id = ?1 and un_notification = ?2",nativeQuery = true)
	public Integer entryAlreadyThere(int id, String message);
		
}
