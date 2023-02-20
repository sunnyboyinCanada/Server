package com.acorn2.FinalProject.lectureReview.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acorn2.FinalProject.common.dto.ComResponseDto;
import com.acorn2.FinalProject.common.dto.ComResponseEntity;
import com.acorn2.FinalProject.lectureReview.dto.LectureReviewDto;
import com.acorn2.FinalProject.lectureReview.dto.req.LectureReviewCreateReqDto;
import com.acorn2.FinalProject.lectureReview.dto.req.LectureReviewReadReqDto;
import com.acorn2.FinalProject.lectureReview.dto.req.LectureReviewUpdateReqDto;
import com.acorn2.FinalProject.lectureReview.dto.res.LectureReviewReadListResDto;
import com.acorn2.FinalProject.lectureReview.service.LectureReviewService;


import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;


@Api(value = "LectureReview")
@RestController
@RequestMapping("/api/lectureReview")
public class LectureReviewController {
	@Autowired
	private LectureReviewService service;

	@GetMapping("/LectureReviewList")
	public ComResponseEntity<LectureReviewReadListResDto> getReviewList(@RequestParam(value = "lecReStuRefGroup",required = true ,defaultValue = "1") int lecReStuRefGroup, 
					@Parameter(hidden = true) LectureReviewReadReqDto reviewReadReqDto) {
		
		LectureReviewReadListResDto revicewReadListResDto = service.LectureReviewList(reviewReadReqDto);
		
		return new ComResponseEntity<>(new ComResponseDto<>(revicewReadListResDto));
	}
	
	@GetMapping("/{lecReNum}/lectureReviewOne")
	public ComResponseEntity<LectureReviewDto> LectureReviewOne(@PathVariable int lecReNum){
		LectureReviewDto dtoOne =  service.LectureReviewOne(lecReNum);
		return new ComResponseEntity<>(new ComResponseDto<>(dtoOne));	
	}
	
	@PostMapping("/LectureReviewinsert")
	public ComResponseEntity<Void> LectureReviewInsert(@Valid @RequestBody LectureReviewCreateReqDto reviewCreateReqDto ){
		service.LectureReviewInsert(reviewCreateReqDto);
		return new ComResponseEntity<Void>();
	}
	
	@PutMapping("/{lecReNum}/update")
	public ComResponseEntity<Void> LectureReviewUpdate(@RequestParam(value = "lecReNum", required = true) int lecReNum,
											@Valid @RequestBody LectureReviewUpdateReqDto reviewUpdateReqDto){
		service.LectureReviewUpdate(reviewUpdateReqDto);
		return new ComResponseEntity<Void>();	
	}
	
	@DeleteMapping("/{lecReNum}")
	public ComResponseEntity<Void> LectureReviewDelete(@RequestParam(value = "lecReNum", required = true) int lecReNum){
		service.LectureReviewDelete(lecReNum);
		return new ComResponseEntity<Void>();
	}

	

	

	
}
