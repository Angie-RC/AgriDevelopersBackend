package com.agripure.agripurebackend.repository;

import com.agripure.agripurebackend.entities.DetailPlant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDetailPlantRepository extends JpaRepository<DetailPlant, Long> {


}
