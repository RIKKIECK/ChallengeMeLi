package com.challenge.controller;

import com.challenge.service.ShortUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class ViewUrlController {


  @Autowired
  private ShortUrlService shortUrlService;

  @GetMapping("/u/{key}")
  public ResponseEntity<String> getUrl(@PathVariable String key) {
    String originalUrl = shortUrlService.getOriginalUrlByKey(key);
    return ResponseEntity.ok(originalUrl);
  }
}
