package by.korozhan.news.config;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Veronika Korozhan March 5, 2018.
 */
@EnableMongoRepositories(basePackages = "by.korozhan.news.repository")
public class MongoConfig extends AbstractMongoConfiguration {
    private final String dbName;
    private final String host;
    private final int port;

    public MongoConfig(@Value("${db.name}") String dbName,
                       @Value("${db.host}") String host,
                       @Value("${db.port}") int port) {
        this.dbName = dbName;
        this.host = host;
        this.port = port;
    }

    @Override
    protected String getDatabaseName() {
        return dbName;
    }

    @Override
    public MongoClient mongoClient() {
        return new MongoClient(host, port);
    }
}