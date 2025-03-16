package com.calc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.calc.entity.User;

public interface CalRepository extends JpaRepository< User,Integer> {

	//@Modifying
	//@Query("UPDATE User u SET u.score =:sc where u.name=:nm")
	//void updateScore(@Param("nm") String name,@Param("sc") int score);

	List<User> findByName(String name);


}
