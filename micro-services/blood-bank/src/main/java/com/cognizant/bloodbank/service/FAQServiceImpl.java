package com.cognizant.bloodbank.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.bloodbank.DTO.FaqDto;
import com.cognizant.bloodbank.model.FAQ;

import com.cognizant.bloodbank.repository.FAQrepository;
import com.cognizant.bloodbank.repository.UserRepository;


@Service 
public class FAQServiceImpl implements FAQService {

	@Autowired
	FAQrepository faqRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Transactional
	@Override
	public List<FaqDto> getFAQsForDonor() {
		List<FaqDto>faqList = new ArrayList<FaqDto>(); 
		for(FAQ faq:faqRepository.getFAQsForDonor()) {
			faqList.add(new FaqDto(faq.getId(),faq.getUser().getUsername(),faq.getQuestion(),faq.getAnswer()));
		}
		return faqList;
	}
	@Transactional
	@Override
	public List<FaqDto> getFAQsForAdmin() {
		
		List<FaqDto>faqList = new ArrayList<FaqDto>(); 
		for(FAQ faq:faqRepository.getFAQsForAdmin()) {
			faqList.add(new FaqDto(faq.getId(),faq.getUser().getUsername(),faq.getQuestion(),faq.getAnswer()));
		}
		return faqList;
	}
	@Transactional
	@Override
	public void modifyFAQ(FaqDto faq) {
		FAQ fAQ = new FAQ( userRepository.findByUsername(faq.getUser()),faq.getQuestion(),faq.getAnswer());
		fAQ.setId(faq.getFaqId());
		faqRepository.save(fAQ);
	}
	@Override
	public List<Integer> getNotification() {
			return faqRepository.getNotifcations();
	}
	@Transactional
	@Override
	public void postQuestion(FaqDto faq) {
		FAQ fAQ = new FAQ( userRepository.findByUsername(faq.getUser()),faq.getQuestion(),null);
		faqRepository.save(fAQ);
	}
	

	
}
	
