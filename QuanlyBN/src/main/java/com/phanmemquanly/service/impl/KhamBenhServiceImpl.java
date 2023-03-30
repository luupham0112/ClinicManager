package com.phanmemquanly.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.phanmemquanly.config.ImageUpload;
import com.phanmemquanly.domain.KhamBenh;
import com.phanmemquanly.repository.KhamBenhRepository;
import com.phanmemquanly.service.KhamBenhService;
import com.phanmemquanly.service.PatientService;;
@Service
public class KhamBenhServiceImpl implements KhamBenhService{
	KhamBenhRepository khamBenhRepository;
	
	private ImageUpload imageUpload;

	public KhamBenhServiceImpl(KhamBenhRepository khamBenhRepository) {
		
		this.khamBenhRepository = khamBenhRepository;
	}

	@Override
	public <S extends KhamBenh> S save(S entity) {
		return khamBenhRepository.save(entity);
	}
	

	@Override
	public List<KhamBenh> findAll() {
		return khamBenhRepository.findAll();
	}
	
	@Override
	public List<KhamBenh> findAllByPatient(int id) {
		return khamBenhRepository.findAllByPatient(id);
	}

	@Override
	public List<KhamBenh> findAllById(Iterable<Integer> ids) {
		return khamBenhRepository.findAllById(ids);
	}

	@Override
	public List<KhamBenh> getAllKhamBenhByPatientId(int id){
		return khamBenhRepository.findAllByPatient(id);
	}

	@Override
	public Optional<KhamBenh> findById(Integer id) {
		return khamBenhRepository.findById(id);
	}


	@Override
	public <S extends KhamBenh> long count(Example<S> example) {
		return khamBenhRepository.count(example);
	}

	@Override
	public void deleteAllInBatch() {
		khamBenhRepository.deleteAllInBatch();
	}

	@Override
	public long count() {
		return khamBenhRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		khamBenhRepository.deleteById(id);
	}

	@Override
	public KhamBenh getById(Integer id) {
		return khamBenhRepository.getById(id);
	}

	@Override
	public void delete(KhamBenh entity) {
		khamBenhRepository.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends KhamBenh> entities) {
		khamBenhRepository.deleteAll(entities);
	}

	@Override
	public List<KhamBenh> getKhambenhinPatient(int idBenhNhan) {
        return khamBenhRepository.getKhambenhinPatient(idBenhNhan);
    }

	@Override
	public List<KhamBenh> findByIdKhamBenhContaining(int idKhambenh) {
		return khamBenhRepository.findByIdKhamBenhContaining(idKhambenh);
	}

	@Override
	public Page<KhamBenh> findByIdKhamBenhContaining(int idKhambenh, Pageable pageable) {
		return khamBenhRepository.findByIdKhamBenhContaining(idKhambenh, pageable);
	}

	@Override
	public Page<KhamBenh> findAll(Pageable pageable) {
		return khamBenhRepository.findAll(pageable);
	}

	@Override
	public List<KhamBenh> findByBacSi(String bacsi) {
		return khamBenhRepository.findByBacSiContaining(bacsi);
	}
	
}
