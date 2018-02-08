package com.otoil.ot_118_rest.data.service.datasource;

import com.otoil.ot_118_rest.data.entity.datasource.DataSource;
import com.otoil.ot_118_rest.data.repo.datasource.DataSourceRepository;
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

	@Autowired
    private DataSourceRepository dataSourceRepository;

    @Transactional(readOnly = true, isolation = Isolation.REPEATABLE_READ)
    public Page<DataSource> findAll(int page, int size) {
        return dataSourceRepository.findAll(new PageRequest(page, size));
    }

    @Transactional(readOnly = true, isolation = Isolation.REPEATABLE_READ)
    public DataSource findOne(String id) {
        return dataSourceRepository.findOne(id);
    }
}
