package com.example.repository;

import com.example.entity.Merchant;
import com.example.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepository extends JpaRepository<Merchant,Long> {
}
