package com.otoil.ot_118_rest.repository.datasource;

import com.otoil.ot_118_rest.data.entity.datasource.Type;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Ageev Evgeny on 02.02.2018.
 */
public interface TypeRepository extends PagingAndSortingRepository<Type, String> {


}
