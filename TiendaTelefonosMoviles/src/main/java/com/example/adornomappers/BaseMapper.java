package com.example.adornomappers;

public interface BaseMapper<T, V> {
	T map (V v);
}
