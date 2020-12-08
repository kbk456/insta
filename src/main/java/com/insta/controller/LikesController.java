package com.insta.controller;

import java.util.List;

import com.insta.service.MyUserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insta.model.Likes;
import com.insta.model.User;
import com.insta.repository.LikesRepository;

@RestController
public class LikesController {
	
	@Autowired
	private LikesRepository mLikesRepository;
	
	@GetMapping("/like/notification")
	public List<Likes> likeNotification(
			@AuthenticationPrincipal MyUserDetail userDetail
			){
		
		User principal = userDetail.getUser();
		List<Likes> likesList = mLikesRepository.findLikeNotification(principal.getId());
		return likesList;
	}
}
