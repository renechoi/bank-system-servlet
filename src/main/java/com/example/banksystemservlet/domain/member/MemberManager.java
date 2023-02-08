package com.example.banksystemservlet.domain.member;

import com.example.banksystemservlet.domain.bank.BankResult;
import com.example.banksystemservlet.domain.board.ArticleDao;
import com.example.banksystemservlet.domain.board.BoardManager;

import java.sql.SQLException;

public class MemberManager {

    private final MemberDao MEMBER_DAO = new MemberDao();

    private static final MemberManager instance = new MemberManager();
//
//    public BankResult register(Member member) {
//        try {
//            validateRegisterId(member);
//            MEMBER_DAO.add(member);
//            ACCOUNT_DAO.create2(member, MEMBER_DAO.getMemberCount());
//            return new BankResult("회원 가입에 성공하였습니다", true, createMemberData());
//        } catch (RuntimeException | SQLException e) {
//            return new BankResult("회원 가입에 실패하였습니다", false);
//        }
//    }
//
//    public BankResult unRegister() {
//        validateLoginOff();
//        try {
//            MEMBER_DAO.delete(validateLoginId(currentlyLogin));
//            ACCOUNT_DAO.delete2(currentlyLogin);
//            setLoginStatusNone();
//            return new BankResult("회원 탈퇴에 성공하였습니다", true, createMemberData());
//        } catch (RuntimeException | SQLException e) {
//            return new BankResult("회원 탈퇴에 실패하였습니다", false);
//        }
//    }
//
//    public BankResult login(String requestedId, String requestedPassword) {
//        try {
//            validateLoginOn();
//            this.currentlyLogin = validateLoginIdAndPassword(requestedId, requestedPassword);
//            return new BankResult("로그인에 성공하였습니다", true, createMemberData());
//        } catch (RuntimeException | SQLException e) {
//            return new BankResult("로그인에 실패하였습니다 \n" + e.getMessage(), false);
//        }
//    }
//
//    public BankResult logout() {
//        try {
//            setLoginStatusNone();
//            return new BankResult("로그아웃에 성공하였습니다", true);
//        } catch (RuntimeException e) {
//            return new BankResult("로그아웃에 실패하였습니다", false);
//        }
//    }


}
