package com.szgomb.webshop.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.szgomb.webshop.auth.dto.AuthenticationResponse;
import com.szgomb.webshop.auth.dto.RegisterRequest;
import com.szgomb.webshop.auth.service.AuthenticationService;

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
