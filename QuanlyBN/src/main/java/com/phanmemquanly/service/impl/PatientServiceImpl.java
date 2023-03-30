package com.phanmemquanly.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.phanmemquanly.dao.PatientDao;
import com.phanmemquanly.domain.Patient;
import com.phanmemquanly.model.PatientDto;
import com.phanmemquanly.repository.PatientRepository;
import com.phanmemquanly.service.PatientService;
import com.phanmemquanly.service.mapper.PatientMapper;

@Service
public class PatientServiceImpl implements PatientService {
	PatientRepository patientRepository;

	public PatientServiceImpl(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}

	@Override
	public List<Patient> findByHotenBNContaining(String hotenBN) {
		return patientRepository.findByHotenBNContaining(hotenBN);
	}

	@Override
	public Page<Patient> findByHotenBNContaining(String hotenBN, Pageable pageable) {
		return patientRepository.findByHotenBNContaining(hotenBN, pageable);
	}

	@Override
	public <S extends Patient> S save(S entity) {
		return patientRepository.save(entity);
	}

	@Override
	public <S extends Patient> List<S> saveAll(Iterable<S> entities) {
		return patientRepository.saveAll(entities);
	}

	@Override
	public List<Patient> findAll(Sort sort) {
		return patientRepository.findAll(sort);
	}

	@Override
	public Page<Patient> findAll(Pageable pageable) {
		return patientRepository.findAll(pageable);
	}

	@Override
	public List<Patient> findAll() {
		return patientRepository.findAll();
	}

	@Override
	public List<Patient> findAllById(Iterable<Integer> ids) {
		return patientRepository.findAllById(ids);
	}
	

	@Override
	public Optional<Patient> findById(Integer id) {
		return patientRepository.findById(id);
	}

	@Override
	public void deleteAllInBatch(Iterable<Patient> entities) {
		patientRepository.deleteAllInBatch(entities);
	}

	@Override
	public boolean existsById(Integer id) {
		return patientRepository.existsById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		patientRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public <S extends Patient> long count(Example<S> example) {
		return patientRepository.count(example);
	}

	@Override
	public void deleteAllInBatch() {
		patientRepository.deleteAllInBatch();
	}

	@Override
	public <S extends Patient, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return patientRepository.findBy(example, queryFunction);
	}

	@Override
	public long count() {
		return patientRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		patientRepository.deleteById(id);
	}

	@Override
	public Patient getById(Integer id) {
		return patientRepository.getById(id);
	}

	@Override
	public void delete(Patient entity) {
		patientRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		patientRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends Patient> entities) {
		patientRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		patientRepository.deleteAll();
	}
	
	// don thuoc
	@Autowired
	private PatientDao PatientDAO;
	
	@Autowired
	private PatientMapper patientMapper;

	@Override
	public List<PatientDto> getPatient() {

		List<Patient> patients = PatientDAO.getPatients();

		List<PatientDto> patientDTOList = new ArrayList<PatientDto>();
		for (Patient c : patients) {
			patientDTOList.add(patientMapper.mapToDTO(c));
		}
		return patientDTOList;
	}
	
	

}
