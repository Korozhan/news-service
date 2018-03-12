package by.korozhan.news.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Veronika Korozhan on June 16, 2016.
 */
@NoRepositoryBean
public interface GenericRepository<T, ID extends Serializable> extends MongoRepository<T, ID> {

    <S extends T> S save(S var1);

    void delete(T deleted);

    List<T> findAll();

    T findOne(ID var1);

    boolean exists(ID id);

    long count();
}
