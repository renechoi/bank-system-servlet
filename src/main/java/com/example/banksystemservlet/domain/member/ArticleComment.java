package com.example.banksystemservlet.domain.member;

import java.time.LocalDateTime;

public record ArticleComment(
        Long id,
        Long articleId,
        String memberId,        // TODO : db에 객체 저장을 못하므로...
        String memberName,
        String content,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy
) {

    public static ArticleComment of(Long id, Long articleId, String memberId, String memberName, String content, LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy) {
        return new ArticleComment(id, articleId,   memberId,  memberName, content, createdAt, createdBy, modifiedAt, modifiedBy);
    }
}
