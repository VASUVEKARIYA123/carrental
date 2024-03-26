package com.example.carrental.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.carrental.Entity.AccessKey;

public interface AccessKeyRepository extends JpaRepository<AccessKey, Long> {
}

