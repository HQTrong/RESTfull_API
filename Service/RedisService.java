package tmdt.tmdt_api.Service;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisService {
    private final RedisTemplate<String, Object> redisTemplate;

    public RedisService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void saveData(String key, Object data, long timeoutInSeconds) {
        redisTemplate.opsForValue().set(key, data);
        redisTemplate.expire(key, timeoutInSeconds, TimeUnit.SECONDS);
    }
    public Object getData(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}