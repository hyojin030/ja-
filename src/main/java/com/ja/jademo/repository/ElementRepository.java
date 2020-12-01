package com.ja.jademo.repository;

import com.ja.jademo.model.Element;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface ElementRepository extends JpaRepository<Element, Long> {
    List<Element> findByid(Long id);
}