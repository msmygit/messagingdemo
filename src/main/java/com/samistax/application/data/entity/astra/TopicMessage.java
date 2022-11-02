package com.samistax.application.data.entity.astra;

import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("topic_message")
public class TopicMessage {

    @PrimaryKey
    @CassandraType(type = CassandraType.Name.UDT)
    private TopicMessageKey key; // Topic and time

    // CollaborationEngine Massage params
    private String text;
    // De normalizing entities
    // Collaboration Engine User Info  parameter
    private String userId;
    private String userName;
    private String userAbbreviation;
    private String userImage;
    private int userColorIndex;

    public TopicMessage(TopicMessageKey key) {
        this.key = key;
    }


    /*public TopicMessage(String topic, Instant timestamp) {
        key = new TopicMessageKey(topic, timestamp);
    }*/

    public TopicMessageKey getKey() {
        return key;
    }

    public void setKey(TopicMessageKey key) {
        this.key = key;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }



    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAbbreviation() {
        return userAbbreviation;
    }

    public void setUserAbbreviation(String userAbbreviation) {
        this.userAbbreviation = userAbbreviation;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public int getUserColorIndex() {
        return userColorIndex;
    }

    public void setUserColorIndex(int userColorIndex) {
        this.userColorIndex = userColorIndex;
    }
}