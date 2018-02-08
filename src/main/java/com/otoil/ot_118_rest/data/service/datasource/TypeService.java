package com.otoil.ot_118_rest.data.service.datasource;

import com.otoil.ot_118_rest.data.entity.datasource.Type;
import org.springframework.data.domain.Page;

public interface TypeService {

    public Page<Type> findTypes(int page, int size);

    public Type findOne(String id);

}
