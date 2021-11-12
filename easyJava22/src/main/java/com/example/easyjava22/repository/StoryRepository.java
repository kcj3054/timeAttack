package com.example.easyjava22.repository;

import com.example.easyjava22.domain.Story;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Repository
public interface StoryRepository extends JpaRepository<Story, Long> {


}
