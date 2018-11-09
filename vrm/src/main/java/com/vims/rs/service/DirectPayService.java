package com.vims.rs.service;

import java.util.List;

import com.vims.rs.model.DirectPay;

public interface DirectPayService {
	public List<DirectPay> findBypolicyId(String searchTerm);
	 public List<DirectPay> getAllPaymentDetails();
}
