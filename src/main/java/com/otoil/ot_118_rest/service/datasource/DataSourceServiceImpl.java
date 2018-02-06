package com.otoil.ot_118_rest.service.datasource;

import com.otoil.ot_118_rest.data.entity.datasource.DataSource;
import com.otoil.ot_118_rest.repository.datasource.DataSourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;

@Repository
@Transactional
@Service("dataSourceService")
public class DataSourceServiceImpl implements DataSourceService {

    //@Autowired
    //private DataSourceRepository dataSourceRepository;

    /*@Autowired
    public DataSourceServiceImpl(DataSourceRepository repository) {
        this.dataSourceRepository = repository;
    }*/

    @Transactional(readOnly = true, isolation = Isolation.REPEATABLE_READ)
    public Page<DataSource> findAll(int page, int size) {
        //return dataSourceRepository.findAll(new PageRequest(page, size));
        return new Page<DataSource>() {
            @Override
            public int getTotalPages() {
                return 0;
            }

            @Override
            public long getTotalElements() {
                return 0;
            }

            @Override
            public <S> Page<S> map(Converter<? super DataSource, ? extends S> converter) {
                return null;
            }

            @Override
            public int getNumber() {
                return 0;
            }

            @Override
            public int getSize() {
                return 0;
            }

            @Override
            public int getNumberOfElements() {
                return 0;
            }

            @Override
            public List<DataSource> getContent() {
                return null;
            }

            @Override
            public boolean hasContent() {
                return false;
            }

            @Override
            public Sort getSort() {
                return null;
            }

            @Override
            public boolean isFirst() {
                return false;
            }

            @Override
            public boolean isLast() {
                return false;
            }

            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }

            @Override
            public Pageable nextPageable() {
                return null;
            }

            @Override
            public Pageable previousPageable() {
                return null;
            }

            @Override
            public Iterator<DataSource> iterator() {
                return null;
            }
        };
    }

    @Transactional(readOnly = true, isolation = Isolation.REPEATABLE_READ)
    public DataSource findOne(String id) {
        //return dataSourceRepository.findOne(id);
        return new DataSource();
    }
}
