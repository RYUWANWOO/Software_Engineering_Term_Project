package com.example.softwareengineering.repository;

import com.example.softwareengineering.model.entity.LectureList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureListRepository extends JpaRepository<LectureList, Long> {

}
