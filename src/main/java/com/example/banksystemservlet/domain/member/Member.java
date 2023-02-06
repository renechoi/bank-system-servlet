package com.example.banksystemservlet.domain.member;

import java.util.Objects;

public class Member {
    private int memberNumber;
    private String name;
    private String memberId;
    private String password;
    private String memo;

    public Member(String name, String memberId, String password ) {
        this.name = name;
        this.memberId = memberId;
        this.password = password;
    }

    public Member(int memberNumber, String name, String memberId, String password) {
        this.memberNumber = memberNumber;
        this.name = name;
        this.memberId = memberId;
        this.password = password;
    }

    public Member(int memberNumber, String name, String memberId, String password, String memo) {
        this.memberNumber = memberNumber;
        this.name = name;
        this.memberId = memberId;
        this.password = password;
        this.memo = memo;
    }



    public boolean matchId(String requestedId) {
        return memberId.equals(requestedId);
    }


    public boolean matchIdAndPassword(String requestedId, String requestedPassword) {
        return memberId.equals(requestedId) && password.equals(requestedPassword);
    }

    public String getMemberId() {
        return memberId;
    }

    public int getMemberNumber() {
        return memberNumber;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(memberId, member.memberId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId);
    }
}
