package com.szgomb.webshop.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/resricted")
@RequiredArgsConstructor
public class TestController {

	@GetMapping("/area")
	public ResponseEntity<String> register(){
		return ResponseEntity.ok("Welcome");
	}
}
