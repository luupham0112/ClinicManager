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

import com.phanmemquanly.dao.ThuocDao;
import com.phanmemquanly.domain.Thuoc;
import com.phanmemquanly.model.ThuocDto;
import com.phanmemquanly.repository.ThuocRepository;
import com.phanmemquanly.service.ThuocService;
import com.phanmemquanly.service.mapper.ThuocMapper;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ThuocServiceImpl implements ThuocService {
	
	ThuocRepository thuocRepository;

	public ThuocServiceImpl(ThuocRepository thuocRepository) {
		
		this.thuocRepository = thuocRepository;
	}

	public List<Thuoc> findByNameThuocContaining(String namThuoc) {
		return thuocRepository.findByNameThuocContaining(namThuoc);
	}
	
	public Page<Thuoc> findByNameThuocContaining(String namThuoc, Pageable pageable) {
		return thuocRepository.findByNameThuocContaining(namThuoc, pageable);
	}

	public <S extends Thuoc> S save(S entity) {
		return thuocRepository.save(entity);
	}

	public <S extends Thuoc> List<S> saveAll(Iterable<S> entities) {
		return thuocRepository.saveAll(entities);
	}

	public List<Thuoc> findAll(Sort sort) {
		return thuocRepository.findAll(sort);
	}

	public void flush() {
		thuocRepository.flush();
	}

	public Page<Thuoc> findAll(Pageable pageable) {
		return thuocRepository.findAll(pageable);
	}

	public <S extends Thuoc> S saveAndFlush(S entity) {
		return thuocRepository.saveAndFlush(entity);
	}

	public <S extends Thuoc> List<S> saveAllAndFlush(Iterable<S> entities) {
		return thuocRepository.saveAllAndFlush(entities);
	}

	public List<Thuoc> findAll() {
		return thuocRepository.findAll();
	}

	public List<Thuoc> findAllById(Iterable<Integer> ids) {
		return thuocRepository.findAllById(ids);
	}

	public Optional<Thuoc> findById(Integer id) {
		return thuocRepository.findById(id);
	}

	public void deleteAllInBatch(Iterable<Thuoc> entities) {
		thuocRepository.deleteAllInBatch(entities);
	}

	public boolean existsById(Integer id) {
		return thuocRepository.existsById(id);
	}

	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		thuocRepository.deleteAllByIdInBatch(ids);
	}

	public <S extends Thuoc> boolean exists(Example<S> example) {
		return thuocRepository.exists(example);
	}

	public void deleteAllInBatch() {
		thuocRepository.deleteAllInBatch();
	}

	public Thuoc getOne(Integer id) {
		return thuocRepository.getOne(id);
	}

	public <S extends Thuoc, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return thuocRepository.findBy(example, queryFunction);
	}

	public long count() {
		return thuocRepository.count();
	}

	public void deleteById(Integer id) {
		thuocRepository.deleteById(id);
	}

	public Thuoc getById(Integer id) {
		return thuocRepository.getById(id);
	}

	public void delete(Thuoc entity) {
		thuocRepository.delete(entity);
	}

	public Thuoc getReferenceById(Integer id) {
		return thuocRepository.getReferenceById(id);
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		thuocRepository.deleteAllById(ids);
	}

	public void deleteAll(Iterable<? extends Thuoc> entities) {
		thuocRepository.deleteAll(entities);
	}

	public void deleteAll() {
		thuocRepository.deleteAll();
	}
	@Override
	public Thuoc find(int id) {
		return thuocRepository.getOne(id);
	}
	
	// don thuoc
	
	@Autowired
private ThuocDao thuocDAO;

@Autowired
private ThuocMapper thuocMapper;


@Override
public List<ThuocDto> getThuocs() {

	List<Thuoc> thuocs= thuocDAO.getThuocs();

	List<ThuocDto> thuocDTOList = new ArrayList<ThuocDto>();

	for(Thuoc p :thuocs) {
		thuocDTOList.add(thuocMapper.mapToDTO(p));
	}
	return thuocDTOList;
}

}
