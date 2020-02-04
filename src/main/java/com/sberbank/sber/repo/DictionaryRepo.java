package com.sberbank.sber.repo;

import com.sberbank.sber.model.Dict;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DictionaryRepo extends PagingAndSortingRepository<Dict, Long> {
    Dict findByName(String name);

    boolean exists(Dict dict);
}
