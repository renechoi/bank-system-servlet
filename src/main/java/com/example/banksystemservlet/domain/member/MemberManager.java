package com.example.banksystemservlet.domain.member;

import com.example.banksystemservlet.domain.bank.Bank;
import com.example.banksystemservlet.domain.bank.BankResult;
import com.example.banksystemservlet.domain.board.ArticleDao;
import com.example.banksystemservlet.domain.board.BoardManager;

import java.sql.SQLException;

public class MemberManager {

    private final MemberDao MEMBER_DAO = new MemberDao();
    private String currentlyLogin = "-1";

    private static final MemberManager instance = new MemberManager();

    public static MemberManager getInstance() {
        return instance;
    }

    public MemberResult register(Member member) {
        try {
            validateRegisterId(member);
            MEMBER_DAO.add(member);
            this.currentlyLogin = member.getMemberId();
            member.setLoginStatus(true);
            return new MemberResult("회원 가입에 성공하였습니다", true, null, member);
        } catch (RuntimeException | SQLException e) {
            return new MemberResult("회원 가입에 실패하였습니다", false);
        }
    }

    public MemberResult unRegister() {
        validateLoginOff();
        try {
            MEMBER_DAO.delete(validateLoginId(currentlyLogin));
            setLoginStatusNone();
            return new MemberResult("회원 탈퇴에 성공하였습니다", true, createMemberData());
        } catch (RuntimeException | SQLException e) {
            return new MemberResult("회원 탈퇴에 실패하였습니다", false);
        }
    }

    public MemberResult login(String requestedId, String requestedPassword) {
        try {
            validateLoginOn();
            Member member = getMember(requestedId, requestedPassword);
            member.setLoginStatus(true);
            this.currentlyLogin = validateLoginIdAndPassword(requestedId, requestedPassword);
            return new MemberResult("로그인에 성공하였습니다", true, null, member);
        } catch (RuntimeException | SQLException e) {
            return new MemberResult("로그인에 실패하였습니다 \n" + e.getMessage(), false);
        }
    }

    public MemberResult logout() {
        try {
            setLoginStatusNone();
            return new MemberResult("로그아웃에 성공하였습니다", true, null, null);
        } catch (RuntimeException e) {
            return new MemberResult("로그아웃에 실패하였습니다", false);
        }
    }

    private Member getMember(String requestedId, String requestedPassword) throws SQLException {
        return MEMBER_DAO.getMember(requestedId, requestedPassword);
    }

    private MemberData createMemberData() throws SQLException {
        Member member = MEMBER_DAO.getMemberCurrentlyLogin(currentlyLogin);

        return MemberData.of(
                currentlyLogin,
                member.getMemberNumber(),
                member.getName(),
                member.getMemberId(),
                member.getPassword(),
                1,
                1
        );
    }

    private void setLoginStatusNone() {
        this.currentlyLogin = "-1";
    }

    private void validateRegisterId(Member member) throws SQLException {
        if (MEMBER_DAO.exist(member)) {
            throw new IllegalArgumentException("이미 존재하는 아이디입니다.");
        }
    }

    private void validateLoginOff() {
        if (currentlyLogin.equals("-1")) {
            throw new IllegalArgumentException("로그인이 되어 있지 않습니다.");
        }
    }

    private void validateLoginOn() {
        if (!currentlyLogin.equals("-1")) {
            throw new IllegalArgumentException("현재 로그인이 되어 있습니다.");
        }
    }

    private String validateLoginId(String requestedId) {
        if (!currentlyLogin.equals(requestedId)) {
            throw new IllegalArgumentException("아이디가 일치하지 않습니다.");
        }
        return requestedId;
    }

    public String validateLoginIdAndPassword(String requestedId, String requestedPassword) throws SQLException {
        if (!MEMBER_DAO.match(requestedId, requestedPassword)) {
            throw new IllegalArgumentException("로그인 가능한 아이디가 없거나 비밀번호가 일치하지 않습니다");
        }
        return requestedId;
    }

}
