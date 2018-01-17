package com.vm.redis.repository.inf;

import java.util.*;
import java.util.concurrent.TimeUnit;

public interface RedisRepository<K, V> {
    // Key
    void del(final K key);

    void del(final Collection<K> keys);

    Boolean exists(final K key);

    Boolean expire(final K key, final long timeout, final TimeUnit unit);

    void expireAt(final K key, Date date);

    Set<K> keys(final K pattern);

    String type(final K key);

    V get(final K key);

    V getSet(final K key, final V value);

    Long incr(final K key, final long delta);

    void set(final K key, final V value);

    void set(final K key, final V value, final long timeout, final TimeUnit unit);

    // Hash
    void hDel(final K key, final Object... hKeys);

    Boolean hExists(final K key, final K hKeys);

    Map<K, V> hGet(final K key);

    V hGet(final K key, final K hKey);

    Set<K> hKeys(final K key);

    Long hLen(final K key);

    void hSet(final K key, final K hk, final V hv);

    void hSet(final K key, final Map<K, V> map);

    List<V> hVals(final K key);

    // List
    V lIndex(final K key, final long index);

    void lInsert(final K key, final long index, V value);

    Long lLen(final K key);

    V lPop(final K key);

    V lPop(final K key, long timeout, TimeUnit unit);

    Long lPush(final K key, final V value);

    List<V> lRange(final K key, final long start, final long end);

    Long lRem(final K key, final long index, final V value);

    void lSet(final K key, final long index, final V value);

    void ltrim(final K key, final long start, final long end);

    Long rPush(final K key, final V value);

    V rPop(final K key);

    // Set
    Long sAdd(final K key, final V value);

    Set<V> sDiff(final K key);

    Set<V> sMembers(final K key);

    Boolean sIsMember(final K key, final V value);

    V sPop(final K key);

    Long sRem(final K key, final V value);

    Long sCard(final K key);

    // SortedSet
    void zAdd(final K key, final V value, final double score);

    Set<V> zRange(final K key, final long start, final long end);

    Long zRem(final K key, final Object... values);

    Long zCard(final K key);
}