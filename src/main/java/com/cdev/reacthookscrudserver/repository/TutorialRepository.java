package com.cdev.reacthookscrudserver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import com.cdev.reacthookscrudserver.model.Tutorial;

//@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
	List<Tutorial> findByTitleContaining(String title);
}
