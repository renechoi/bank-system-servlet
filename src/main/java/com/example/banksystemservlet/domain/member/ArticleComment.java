package com.example.banksystemservlet.domain.member;

import java.sql.Date;

public record ArticleComment(
        Long id,
        String articleId,
        String memberId,        // TODO : db에 객체 저장을 못하므로...
        String memberName,
        String content,
        Date createdAt,
        String createdBy,
        Date modifiedAt,
        String modifiedBy
) {

    public static ArticleComment of(Long id, String articleId, String memberId, String memberName, String content, Date createdAt, String createdBy, Date modifiedAt, String modifiedBy) {
        return new ArticleComment(id, articleId,   memberId,  memberName, content, createdAt, createdBy, modifiedAt, modifiedBy);
    }
}
