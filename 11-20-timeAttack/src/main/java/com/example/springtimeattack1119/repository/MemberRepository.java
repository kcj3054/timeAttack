package com.example.springtimeattack1119.repository;

import com.example.springtimeattack1119.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
