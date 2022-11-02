package com.samistax.application.data.entity.astra;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@PrimaryKeyClass
public class TopicMessageKey implements Serializable {

    @PrimaryKeyColumn(name = "topic",  ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String topic;

    @PrimaryKeyColumn(name = "time", ordinal = 1, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
    //@CassandraType(type = CassandraType.Name.TIMESTAMP)
    private Instant time;

    public TopicMessageKey(){}

    public TopicMessageKey(String topic) {
        this.topic = topic;
        this.time = Instant.now();
    }

    public TopicMessageKey(String topic, Instant time) {
        this.topic = topic;
        this.time = time;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TopicMessageKey that = (TopicMessageKey) o;
        return Objects.equals(topic, that.topic) && Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topic, time);
    }
}

