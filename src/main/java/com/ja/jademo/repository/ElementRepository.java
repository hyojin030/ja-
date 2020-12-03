package com.ja.jademo.repository;

import com.ja.jademo.model.Element;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface ElementRepository extends JpaRepository<Element, Long> {
    List<Element> findByid(Long id);

    Page<Element> findByYearContainingOrRegionContainingOrOrzContainingOrWorkContaining(String year, String region, String orz, String work, Pageable pageable);

}