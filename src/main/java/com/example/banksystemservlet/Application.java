package com.example.banksystemservlet;


import com.example.banksystemservlet.domain.bank.Controller;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.openBank();
    }
}
