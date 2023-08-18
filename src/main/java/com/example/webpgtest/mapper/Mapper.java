package com.example.webpgtest.mapper;

public interface Mapper<K, T> {
    T map(K k);
}
