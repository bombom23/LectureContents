package com.example.market3.Rapository;

import com.example.market3.Entity.JpaMemberAuth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberAuthRepository  extends JpaRepository<JpaMemberAuth, Long> {
}
