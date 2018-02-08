package com.otoil.ot_118_rest.data.service.datasource;

import com.otoil.ot_118_rest.data.entity.datasource.DataSource;
import org.springframework.data.domain.Page;

public interface DataSourceService {

    public Page<DataSource> findAll(int page, int size);

    public DataSource findOne(String id);

}
