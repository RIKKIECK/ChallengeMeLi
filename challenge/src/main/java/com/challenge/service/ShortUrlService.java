package com.challenge.service;

import com.challenge.entry.ShortUrl;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Validated
public interface ShortUrlService {

  String getOriginalUrlByKey(@NotBlank String key);

  ShortUrl shortenUrl(@NotBlank String originalUrl);

}
