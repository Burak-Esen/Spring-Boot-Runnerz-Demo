package com.burakesen.restdemo.run;

import java.util.List;
// import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

public interface IRunRepository extends ListCrudRepository<Run, Integer> {
    // List<Run> findAll();

    // Optional<Run> findById(Integer id);

    // void create(Run run);

    // void update(Integer id, Run run);

    // void delete(Integer id);

    // long count();

    // void saveAll(List<Run> runs);

    @Query
    List<Run> findByLocation(String location);
}
