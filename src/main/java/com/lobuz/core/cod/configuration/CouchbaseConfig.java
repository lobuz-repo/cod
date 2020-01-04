package com.lobuz.core.cod.configuration;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.core.convert.CouchbaseCustomConversions;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

@Configuration
@EnableCouchbaseRepositories(basePackages = {"com.lobuz.core.cod"})
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    @Value("${couchbase.bucket.name}")
    private String bucketName;

    @Value("${couchbase.bucket.password}")
    private String bucketPassword;

    @Value("${couchbase.cluster.ip}")
    private String clusterIp;

    @Value("${couchbase.username}")
    private String username;

    @Override
    protected List<String> getBootstrapHosts() {
        return Collections.singletonList(clusterIp);
    }

    @Override
    protected String getBucketName() {
        return bucketName;
    }

    @Override
    protected String getBucketPassword() {
        return bucketPassword;
    }

    @Override
    protected String getUsername() {
        return username;
    }

    @PostConstruct
    public void init() {
        try {
            couchbaseClient().bucketManager().createN1qlPrimaryIndex(true, false);
        } catch (Exception e) {
            throw new BeanInitializationException("Cannot create couchbase primary index");
        }
    }

    @Override
    public CouchbaseCustomConversions customConversions() {
        return new CouchbaseCustomConversions(List.of(
                LocalDateToString.INSTANCE, StringToLocalDateConverter.INSTANCE,
                LocalTimeToString.INSTANCE, StringToLocalTimeConverter.INSTANCE,
                DateTimeReader.INSTANCE, DateTimeWriter.INSTANCE));
    }

    @WritingConverter
    public enum LocalDateToString implements Converter<LocalDate, String> {
        INSTANCE;

        @Override
        public String convert(LocalDate source) {
            return source.toString();
        }
    }

    @ReadingConverter
    public enum StringToLocalDateConverter implements Converter<String, LocalDate> {
        INSTANCE;

        @Override
        public LocalDate convert(String source) {
            return LocalDate.parse(source);
        }
    }

    @WritingConverter
    public enum LocalTimeToString implements Converter<LocalTime, String> {
        INSTANCE;

        @Override
        public String convert(LocalTime source) {
            return source.toString();
        }
    }

    @ReadingConverter
    public enum StringToLocalTimeConverter implements Converter<String, LocalTime> {
        INSTANCE;

        @Override
        public LocalTime convert(String source) {
            return LocalTime.parse(source);
        }
    }

    @WritingConverter
    public enum DateTimeWriter implements Converter<LocalDateTime, String> {
        INSTANCE;

        @Override
        public String convert(LocalDateTime source) {
            return FORMATTER.format(source);
        }
    }

    @ReadingConverter
    public enum DateTimeReader implements Converter<String, LocalDateTime> {
        INSTANCE;

        @Override
        public LocalDateTime convert(String source) {
            return LocalDateTime.parse(source, FORMATTER);
        }
    }

}
