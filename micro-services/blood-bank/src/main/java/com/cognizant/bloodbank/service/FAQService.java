package com.cognizant.bloodbank.service;

import java.util.List;

import com.cognizant.bloodbank.DTO.FaqDto;



public interface FAQService {
	public List<FaqDto> getFAQsForDonor();
	public List<FaqDto> getFAQsForAdmin();
	public void modifyFAQ(FaqDto faq);
	public List<Integer> getNotification();
	public void postQuestion(FaqDto faq);
}
