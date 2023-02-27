package com.example.banksystemservlet.domain.member;

import java.util.Objects;

public class Member {
    private int memberNumber;
    private String name;
    private String memberId;
    private String password;
    private String email;
    private String address;
    private boolean loginStatus;

    public Member(String memberId) {
        this.memberId = memberId;
    }

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

    public Member(int memberNumber, String name, String memberId, String password, String email, String address) {
        this(memberNumber, name, memberId, password, email, address, false);
    }

    public Member(String name, String memberId, String password, String email, String address) {
        this(name, memberId, password, email, address, false);
    }

    public Member(String name, String memberId, String password, String email, String address, boolean loginStatus) {
        this.name = name;
        this.memberId = memberId;
        this.password = password;
        this.email = email;
        this.address = address;
        this.loginStatus = loginStatus;
    }

    public Member(int memberNumber, String name, String memberId, String password, String email, String address, boolean loginStatus) {
        this.memberNumber = memberNumber;
        this.name = name;
        this.memberId = memberId;
        this.password = password;
        this.email = email;
        this.address = address;
        this.loginStatus = loginStatus;
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

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }

    public boolean isLoginStatus() {
        return loginStatus;
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
