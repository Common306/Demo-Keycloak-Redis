package com.example.demo.cache;

import com.example.demo.constant.Constant;
import com.example.demo.entities.Popup;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ExceptionCache {

    private static final String PREFIX_KEY_EXCEPTION = "exception_";

    private final RedisTemplate redisTemplate;

    public void setException(Popup popup) {
        String key = getKey(popup.getException().getExceptionId(), popup.getLanguage().getLanguageId());
        redisTemplate.opsForValue().set(key, popup);
    }

    public Popup getException(int exceptionId, String languageId) {
        String key = getKey(exceptionId, languageId);
        boolean hasKey = redisTemplate.hasKey(key);
        if(!hasKey) {
            return null;
        }
        return (Popup) redisTemplate.opsForValue().get(key);
    }

    public void deleteException(int exceptionId, String languageId) {
        String key = getKey(exceptionId, languageId);
        boolean hasKey = redisTemplate.hasKey(key);
        if(hasKey) {
            redisTemplate.delete(key);
        }
    }

    private String getKey(int exceptionId, String languageId) {
        return PREFIX_KEY_EXCEPTION + exceptionId + Constant.UNDERSCORE + languageId;
    }
}
