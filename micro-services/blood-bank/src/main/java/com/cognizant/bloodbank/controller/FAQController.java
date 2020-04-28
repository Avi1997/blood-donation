package com.cognizant.bloodbank.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.bloodbank.DTO.FaqDto;
import com.cognizant.bloodbank.model.BloodNotification;
import com.cognizant.bloodbank.model.User;
import com.cognizant.bloodbank.repository.BloodNotificationRepository;
import com.cognizant.bloodbank.repository.UserRepository;
import com.cognizant.bloodbank.security.AppUserDetailsService;
import com.cognizant.bloodbank.service.FAQService;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;



@RestController
@RequestMapping("/blood-bank/faq")
public class FAQController {
	private static final Logger LOGGER = LoggerFactory.getLogger(FAQController.class);
	List<String> userList = new ArrayList<String>();
	@Autowired
	FAQService faqService;
	@Autowired
	BloodNotificationRepository bloodNotificationRepository ;
	@Autowired
	UserRepository userRepository;
	@Autowired
	AppUserDetailsService appUserDetailsService;

	@GetMapping()
	public List<FaqDto> getFAQs() {
		LOGGER.info("START");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String user = authentication.getName();
		LOGGER.info("user : {}", user);
		if (!user.equals("anonymousUser")) {
			UserDetails userDetails = appUserDetailsService.loadUserByUsername(user);
			String role = userDetails.getAuthorities().toArray()[0].toString();
			LOGGER.info("role : {}", role);
			if (role.equals("ADMIN")) {
				return faqService.getFAQsForAdmin();
			} else {
				return faqService.getFAQsForDonor();
			}
		}
		return faqService.getFAQsForDonor();

	}

	@PutMapping
	public void asnwerFAQ(@RequestBody FaqDto faq) {
		User user = userRepository.findByUsername(faq.getUser());
		this.bloodNotificationRepository.save(new BloodNotification(user,"Your Question =  "+faq.getQuestion()+" ?  is Answered.",false));
		 faqService.modifyFAQ(faq);
	}

	@PostMapping
	public void postQuestion(@RequestBody FaqDto faq) {		
		faqService.postQuestion(faq);
	}
	

}
