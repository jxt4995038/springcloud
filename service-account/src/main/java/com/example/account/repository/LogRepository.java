package com.example.account.repository;

import com.example.account.domain.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @program: springcloud
 * @description:
 * @author: jiaxiaotong
 * @create: 2019-12-23 16:58
 */
@Repository
public interface LogRepository extends JpaRepository<Log,String> {
}