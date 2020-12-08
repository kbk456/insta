package com.insta.repository;

import com.insta.model.Image;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ImageRepository extends JpaRepository<Image, Integer>{

	@Query
	(
			value = "select * from image where userId in (select toUserId from follow where fromUserId = ?1) or userId = ?1", nativeQuery = true		
	)
	Page<Image> findImage(int userId, Pageable pageable);

}
