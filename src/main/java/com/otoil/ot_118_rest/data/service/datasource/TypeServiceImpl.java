package com.otoil.ot_118_rest.data.service.datasource;

import com.otoil.ot_118_rest.data.entity.datasource.Type;
import com.otoil.ot_118_rest.data.repo.datasource.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@Service("typeService")
public class TypeServiceImpl implements TypeService {

	@Autowired
    private TypeRepository typeRepository;

    @Transactional(readOnly = true, isolation = Isolation.REPEATABLE_READ)
    public Page<Type> findTypes(int page, int size) {
        return typeRepository.findAll(new PageRequest(page, size));
    }

    @Transactional(readOnly = true, isolation = Isolation.REPEATABLE_READ)
    public Type findOne(String id) {
        return typeRepository.findOne(id);
    }
}
