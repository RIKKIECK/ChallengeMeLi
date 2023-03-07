package com.challenge.controller;

import com.challenge.service.ShortUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
@RestController
public class RedirectUrlController {


  @Autowired
  private ShortUrlService shortUrlService;

  @GetMapping("/r/{key}")
  public ResponseEntity<String> redirectToUrl(@PathVariable String key) {
    String originalUrl = shortUrlService.getOriginalUrlByKey(key);
    HttpHeaders headers = new HttpHeaders();
    headers.setLocation(URI.create(originalUrl));
    return ResponseEntity.status(HttpStatus.PERMANENT_REDIRECT).headers(headers).body(originalUrl);
  }


}
