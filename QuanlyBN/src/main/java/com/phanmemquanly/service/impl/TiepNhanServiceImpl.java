package com.phanmemquanly.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.phanmemquanly.domain.TiepNhan;
import com.phanmemquanly.repository.TiepNhanRepository;
import com.phanmemquanly.service.TiepNhanService;

@Service
public class TiepNhanServiceImpl implements TiepNhanService{
	TiepNhanRepository tiepNhanRepository;
	

	public TiepNhanServiceImpl(TiepNhanRepository tiepNhanRepository) {
		
		this.tiepNhanRepository = tiepNhanRepository;
	}

	@Override
	public <S extends TiepNhan> S save(S entity) {
		return tiepNhanRepository.save(entity);
	}

	@Override
	public <S extends TiepNhan> List<S> saveAll(Iterable<S> entities) {
		return tiepNhanRepository.saveAll(entities);
	}

	@Override
	public List<TiepNhan> findAll(Sort sort) {
		return tiepNhanRepository.findAll(sort);
	}

	@Override
	public Page<TiepNhan> findAll(Pageable pageable) {
		return tiepNhanRepository.findAll(pageable);
	}

	@Override
	public List<TiepNhan> findAll() {
		return tiepNhanRepository.findAll();
	}

	@Override
	public List<TiepNhan> findAllById(Iterable<Integer> ids) {
		return tiepNhanRepository.findAllById(ids);
	}

	@Override
	public Optional<TiepNhan> findById(Integer id) {
		return tiepNhanRepository.findById(id);
	}

	@Override
	public void deleteById(Integer id) {
		tiepNhanRepository.deleteById(id);
	}

	@Override
	public TiepNhan getById(Integer id) {
		return tiepNhanRepository.getById(id);
	}

	@Override
	public void delete(TiepNhan entity) {
		tiepNhanRepository.delete(entity);
	}

	@Override
	public TiepNhan getReferenceById(Integer id) {
		return tiepNhanRepository.getReferenceById(id);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		tiepNhanRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends TiepNhan> entities) {
		tiepNhanRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		tiepNhanRepository.deleteAll();
	}
	
	

}
