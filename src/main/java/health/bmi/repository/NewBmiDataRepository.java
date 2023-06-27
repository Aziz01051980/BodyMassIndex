package health.bmi.repository;

import health.bmi.domain.BmiData;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Component
public class NewBmiDataRepository implements BmiDataRepository{

    public void setBmiDataRepository(BmiDataRepository bmiDataRepository) {
        this.bmiDataRepository = bmiDataRepository;
    }

    private BmiDataRepository bmiDataRepository;

    @Override
    public <S extends BmiData> S save(S entity) {
        return null;
    }

    @Override
    public Double getBmiBypersonName(String name) {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends BmiData> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends BmiData> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<BmiData> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public BmiData getOne(Long aLong) {
        return null;
    }

    @Override
    public BmiData getById(Long aLong) {
        return null;
    }

    @Override
    public BmiData getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends BmiData> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends BmiData> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends BmiData> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends BmiData> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends BmiData> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends BmiData> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends BmiData, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends BmiData> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<BmiData> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<BmiData> findAll() {
        return null;
    }

    @Override
    public List<BmiData> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(BmiData entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends BmiData> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<BmiData> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<BmiData> findAll(Pageable pageable) {
        return null;
    }
}
