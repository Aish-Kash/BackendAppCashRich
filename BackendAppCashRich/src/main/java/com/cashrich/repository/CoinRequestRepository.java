package com.cashrich.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cashrich.model.CoinRequest;

public interface CoinRequestRepository extends JpaRepository<CoinRequest, Long>{

}
