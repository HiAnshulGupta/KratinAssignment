package com.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Diet_chart;

public interface DietRepository extends JpaRepository<Diet_chart, Long> {

}
