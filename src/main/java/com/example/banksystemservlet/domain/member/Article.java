package com.example.banksystemservlet.domain.member;

import java.sql.Date;
import java.time.LocalDateTime;

public record Article(
        Long id,
        String memberId,
        String memberName,
        String title,
        String content,
        String hashtag,
        Date createdAt,
        String createdBy,
        Date modifiedAt,
        String modifiedBy
) {

    public static Article of(Long id, String memberId, String memberName, String title, String content, String hashtag, Date createdAt, String createdBy, Date modifiedAt, String modifiedBy) {
        return new Article(id, memberId, memberName, title, content, hashtag, createdAt, createdBy, modifiedAt, modifiedBy);
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", memberId='" + memberId + '\'' +
                ", memberName='" + memberName + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", hashtag='" + hashtag + '\'' +
                ", createdAt=" + createdAt +
                ", createdBy='" + createdBy + '\'' +
                ", modifiedAt=" + modifiedAt +
                ", modifiedBy='" + modifiedBy + '\'' +
                '}';
    }



}