package com.example.banksystemservlet.domain.member;

public class MemberResult {

    private final String message;
    private final boolean result;
    private final MemberData memberData;
    private final Member member;

    public MemberResult(String message, boolean result) {
        this(message, result, MemberData.of(
                "not login",
                0,
                "not login",
                "not login",
                "not login",
                0,
                0));
    }

    public MemberResult(String message, boolean result, MemberData memberData) {
        this(message,result,memberData,null);
    }

    public MemberResult(String message, boolean result, MemberData memberData, Member member) {
        this.message = message;
        this.result = result;
        this.memberData = memberData;
        this.member = member;
    }

    public String getMessage() {
        return message;
    }

    public boolean isResult() {
        return result;
    }

    public MemberData getMemberData() {
        return memberData;
    }

    public Member getMember() {
        return member;
    }


    public boolean isSuccess() {
        return result;
    }
}
