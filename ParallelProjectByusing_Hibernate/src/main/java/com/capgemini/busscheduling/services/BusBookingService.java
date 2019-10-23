package com.capgemini.busscheduling.services;

import java.util.Date;
import java.util.List;

import com.capgemini.busscheduling.dto.Availability;
import com.capgemini.busscheduling.dto.Bus;
import com.capgemini.busscheduling.dto.Feedback;

public interface BusBookingService {

	public Bus searchBus(Integer busId);
	public Integer checkAvailability(Integer busId, Date date);
	public List<Availability>checkAvailability(String source, String destination, Date date);
	public List<Feedback> viewFeedback();

	//validate
	public Integer validateId(String id);
	public String validateEmail(String email);
	public Long validateContact(String contact);
}