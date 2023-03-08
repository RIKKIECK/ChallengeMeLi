package com.challenge.controller;

import com.challenge.exception.NotFoundException;
import com.challenge.exception.NotGoneException;
import com.challenge.service.ShortUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DelUrlController {

  @Autowired
  private ShortUrlService shortUrlService;

  @DeleteMapping("/d/{key}")
  public ResponseEntity<String> delUrl(@PathVariable String key) {
    String delOriginalUrl = String.valueOf(shortUrlService.delOriginalUrlByKey(key));
    if (delOriginalUrl == "null")
      throw new NotGoneException();
    return ResponseEntity.ok(delOriginalUrl);
  }
}
