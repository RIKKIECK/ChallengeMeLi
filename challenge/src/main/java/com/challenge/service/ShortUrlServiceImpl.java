package com.challenge.service;

import com.challenge.entry.ShortUrl;
import com.google.common.hash.Hashing;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class ShortUrlServiceImpl implements ShortUrlService{

  @Value("${redis.cache.expiration}")
  private Integer rexp;

  @Autowired
  private RedisTemplate<String, ShortUrl> redisTemplate;

  @Override
  public String getOriginalUrlByKey(String key) {
    ShortUrl shortUrl = redisTemplate.opsForValue().get(key);
    if (shortUrl == null) return null;
    return shortUrl.getOriginalUrl();
  }

  @Override
  public ShortUrl shortenUrl(String originalUrl) {
    String key = Hashing.murmur3_32_fixed().hashString(originalUrl, Charset.defaultCharset()).toString();
    ShortUrl shortUrl = ShortUrl.builder().originalUrl(originalUrl).key(key).build();
    redisTemplate.opsForValue().set(key,
      shortUrl,rexp, TimeUnit.SECONDS);
    return shortUrl;
  }
}
