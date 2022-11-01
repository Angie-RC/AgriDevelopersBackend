package com.agripure.agripurebackend.service.impl;

import com.agripure.agripurebackend.entities.DetailPlant;
import com.agripure.agripurebackend.repository.IDetailPlantRepository;
import com.agripure.agripurebackend.service.IDetailPlantService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class DetailPlantServiceImpl implements IDetailPlantService {

    private final IDetailPlantRepository detailPlantRepository;

    public DetailPlantServiceImpl(IDetailPlantRepository detailPlantRepository) {
        this.detailPlantRepository = detailPlantRepository;
    }

    @Override
    @Transactional
    public DetailPlant save(DetailPlant detailPlant) throws Exception {
        return detailPlantRepository.save(detailPlant);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        detailPlantRepository.deleteById(id);
    }

    @Override
    public List<DetailPlant> getAll() throws Exception {
        return detailPlantRepository.findAll();
    }

    @Override
    public Optional<DetailPlant> getById(Long id) throws Exception {
        return detailPlantRepository.findById(id);
    }
}
