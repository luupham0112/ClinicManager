package com.phanmemquanly.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phanmemquanly.domain.TiepNhan;

@Repository
public interface TiepNhanRepository  extends JpaRepository<TiepNhan, Integer> {

}
