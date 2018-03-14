package by.korozhan.news.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * Created by Veronika Korozhan on June 16, 2016.
 */
@NoRepositoryBean
public interface GenericRepository<T, ID extends Serializable> extends MongoRepository<T, ID> {
}
