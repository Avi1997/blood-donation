package com.cognizant.bloodbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.bloodbank.model.FAQ;


@Repository
public interface FAQrepository extends JpaRepository<FAQ, Integer> {
	
	@Query(value = "select fa_id,fa_us_id,fa_question,fa_answer from faq where fa_answer is not null", nativeQuery = true)
	public List<FAQ> getFAQsForDonor(); 
	
	@Query(value = "select fa_id,fa_us_id,fa_question,fa_answer from faq where fa_answer is null", nativeQuery = true)
	public List<FAQ> getFAQsForAdmin(); 
	
	@Query(value = "select fa_us_id from faq where fa_answer is not null", nativeQuery = true)
	public List<Integer> getNotifcations();
	
	@Query(value="select fa_id,fa_us_id,fa_question,fa_answer from faq where fa_us_id=?1",nativeQuery=true)
	public List<FAQ> findByUser(int userId);
}
