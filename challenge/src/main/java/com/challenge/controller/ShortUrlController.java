package com.challenge.controller;

import com.challenge.entry.ShortUrl;
import com.challenge.service.ShortUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShortUrlController {
  @Autowired
  private ShortUrlService shortUrlService;


  @PostMapping("/shorten")
  public ResponseEntity<ShortUrl> shortenUrl(@RequestParam String url) {
    ShortUrl shortUrl = shortUrlService.shortenUrl(url);
    return ResponseEntity.ok(shortUrl);
  }
}
