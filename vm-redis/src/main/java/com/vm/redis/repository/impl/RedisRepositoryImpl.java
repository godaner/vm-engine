package com.vm.redis.repository.impl;

import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Repository
public class RedisRepositoryImpl<K, V> implements com.vm.redis.repository.inf.RedisRepository<K, V> {

    @Resource
    private RedisTemplate<K, V> redisTemplate;


    private BoundValueOperations<K, V> getBoundValueOps(K key) {
        return redisTemplate.boundValueOps(key);
    }

    private BoundZSetOperations<K, V> getBoundZSetOps(K key) {
        return redisTemplate.boundZSetOps(key);
    }

    private BoundSetOperations<K, V> getBoundSetOps(K key) {
        return redisTemplate.boundSetOps(key);
    }

    private BoundListOperations<K, V> getBoundListOps(K key) {
        return redisTemplate.boundListOps(key);
    }

    private <HK, HV> BoundHashOperations<K, HK, HV> getBoundHashOps(K key) {
        return redisTemplate.boundHashOps(key);
    }

    // Key
    @Override
    public void del(final K key) {
        redisTemplate.delete(key);
    }

    @Override
    public void del(final Collection<K> keys) {
        redisTemplate.delete(keys);
    }

    public Boolean exists(final K key) {
        return redisTemplate.hasKey(key);
    }

    public Boolean expire(final K key, final long timeout, final TimeUnit unit) {
        return redisTemplate.expire(key, timeout, unit);
    }

    public void expireAt(final K key, Date date) {
        redisTemplate.expireAt(key, date);
    }

    public Set<K> keys(final K pattern) {
        return redisTemplate.keys(pattern);
    }

    public String type(final K key) {
        return redisTemplate.type(key).code();
    }

    public V get(final K key) {
        BoundValueOperations<K, V> ops = this.getBoundValueOps(key);
        return ops.get();
    }

    public V getSet(final K key, final V value) {
        BoundValueOperations<K, V> ops = this.getBoundValueOps(key);
        return ops.getAndSet(value);
    }

    public Long incr(final K key, final long delta) {
        BoundValueOperations<K, V> ops = this.getBoundValueOps(key);
        return ops.increment(delta);
    }

    public void set(final K key, final V value) {
        BoundValueOperations<K, V> ops = this.getBoundValueOps(key);
        ops.set(value);
    }

    public void set(final K key, final V value, final long timeout, final TimeUnit unit) {
        BoundValueOperations<K, V> ops = this.getBoundValueOps(key);
        ops.set(value, timeout, unit);
    }

    // Hash
    public void hDel(final K key, final Object... hKeys) {
        BoundHashOperations<K, K, V> ops = this.getBoundHashOps(key);
        ops.delete(hKeys);
    }

    public Boolean hExists(final K key, final K hKeys) {
        BoundHashOperations<K, K, V> ops = this.getBoundHashOps(key);
        return ops.hasKey(hKeys);
    }

    public Map<K, V> hGet(final K key) {
        BoundHashOperations<K, K, V> ops = this.getBoundHashOps(key);
        return ops.entries();
    }

    public V hGet(final K key, final K hKey) {
        BoundHashOperations<K, K, V> ops = this.getBoundHashOps(key);
        return ops.get(hKey);
    }

    public Set<K> hKeys(final K key) {
        BoundHashOperations<K, K, V> ops = this.getBoundHashOps(key);
        return ops.keys();
    }

    public Long hLen(final K key) {
        BoundHashOperations<K, K, V> ops = this.getBoundHashOps(key);
        return ops.size();
    }

    public void hSet(final K key, final K hk, final V hv) {
        BoundHashOperations<K, K, V> ops = this.getBoundHashOps(key);
        ops.put(hk, hv);
    }

    public void hSet(final K key, final Map<K, V> map) {
        BoundHashOperations<K, K, V> ops = this.getBoundHashOps(key);
        ops.putAll(map);
    }

    public List<V> hVals(final K key) {
        BoundHashOperations<K, K, V> ops = this.getBoundHashOps(key);
        return ops.values();
    }

    // List

    public V lIndex(final K key, final long index) {
        BoundListOperations<K, V> ops = this.getBoundListOps(key);
        return ops.index(index);
    }

    public void lInsert(final K key, final long index, V value) {
        BoundListOperations<K, V> ops = this.getBoundListOps(key);
        ops.set(index, value);
    }

    public Long lLen(final K key) {
        BoundListOperations<K, V> ops = this.getBoundListOps(key);
        return ops.size();
    }

    public V lPop(final K key) {
        BoundListOperations<K, V> ops = this.getBoundListOps(key);
        return ops.leftPop();
    }

    public V lPop(final K key, long timeout, TimeUnit unit) {
        BoundListOperations<K, V> ops = this.getBoundListOps(key);
        return ops.leftPop(timeout, unit);
    }

    public Long lPush(final K key, final V value) {
        BoundListOperations<K, V> ops = this.getBoundListOps(key);
        return ops.leftPush(value);
    }

    public List<V> lRange(final K key, final long start, final long end) {
        BoundListOperations<K, V> ops = this.getBoundListOps(key);
        return ops.range(start, end);
    }

    public Long lRem(final K key, final long index, final V value) {
        BoundListOperations<K, V> ops = this.getBoundListOps(key);
        return ops.remove(index, value);
    }

    public void lSet(final K key, final long index, final V value) {
        BoundListOperations<K, V> ops = this.getBoundListOps(key);
        ops.set(index, value);
    }

    public void ltrim(final K key, final long start, final long end) {
        BoundListOperations<K, V> ops = this.getBoundListOps(key);
        ops.trim(start, end);
    }

    public Long rPush(final K key, final V value) {
        BoundListOperations<K, V> ops = this.getBoundListOps(key);
        return ops.rightPush(value);
    }

    public V rPop(final K key) {
        BoundListOperations<K, V> ops = this.getBoundListOps(key);
        return ops.rightPop();
    }

    // Set

    public Long sAdd(final K key, final V value) {
        BoundSetOperations<K, V> ops = this.getBoundSetOps(key);
        return ops.add(value);
    }

    public Set<V> sDiff(final K key) {
        BoundSetOperations<K, V> ops = this.getBoundSetOps(key);
        return ops.diff(key);
    }

    public Set<V> sMembers(final K key) {
        BoundSetOperations<K, V> ops = this.getBoundSetOps(key);
        return ops.members();
    }

    public Boolean sIsMember(final K key, final V value) {
        BoundSetOperations<K, V> ops = this.getBoundSetOps(key);
        return ops.isMember(value);
    }

    public V sPop(final K key) {
        BoundSetOperations<K, V> ops = this.getBoundSetOps(key);
        return ops.pop();
    }

    public Long sRem(final K key, final V value) {
        BoundSetOperations<K, V> ops = this.getBoundSetOps(key);
        return ops.remove(value);
    }

    public Long sCard(K key) {
        BoundSetOperations<K, V> ops = this.getBoundSetOps(key);
        return ops.size();
    }

    // SortedSet

    public void zAdd(final K key, final V value, final double score) {
        BoundZSetOperations<K, V> ops = this.getBoundZSetOps(key);
        ops.add(value, score);
    }

    public Set<V> zRange(final K key, final long start, final long end) {
        BoundZSetOperations<K, V> ops = this.getBoundZSetOps(key);
        return ops.range(start, end);
    }

    public Long zRem(final K key, final Object... values) {
        BoundZSetOperations<K, V> ops = this.getBoundZSetOps(key);
        return ops.remove(values);
    }

    public Long zCard(K key) {
        BoundZSetOperations<K, V> ops = this.getBoundZSetOps(key);
        return ops.zCard();
    }

    public RedisTemplate<K, V> getRedisTemplate() {
        return redisTemplate;
    }


    public void setRedisTemplate(RedisTemplate<K, V> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}