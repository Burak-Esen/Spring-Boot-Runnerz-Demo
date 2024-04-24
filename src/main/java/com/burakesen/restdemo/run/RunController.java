package com.burakesen.restdemo.run;

import com.burakesen.restdemo.exceptions.NotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/runs")
public class RunController {

    // private final JdbcClientRunRepository runRepository;
    private final IRunRepository runRepository;
    public RunController(IRunRepository runRepository) {
        this.runRepository = runRepository; // it is @AutoWired cause of @Repository annotation
//    ! this.runRepository = new RunRepository(); it might broke app cause of multi initialize in different classes
    }

    //@RequestMapping(method = RequestMethod.GET, path = "/run")
    @GetMapping("")
    List<Run> findAll() {
        return runRepository.findAll();
    }

    @GetMapping("/{id}")
    Run findById(@PathVariable Integer id) {
        Optional<Run> run = runRepository.findById(id);
        if (run.isEmpty()) {
            throw new NotFoundException("Run");
        }
        return run.get();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    void create(@Valid @RequestBody Run run) {
        runRepository.save(run);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateById(@PathVariable Integer id, @Valid @RequestBody Run run) {
        runRepository.save(run);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteById(@PathVariable Integer id) {
        runRepository.delete(runRepository.findById(id).get());
    }

    @GetMapping("/location/{location}")
    List<Run> findByLocation(@PathVariable String location) {
        return runRepository.findByLocation(location);
    }
}
