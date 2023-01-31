# ATM 프로그램 

1. 회원가입/탈퇴 기능
2. 로그인/아웃 기능 
3. 입금, 이체, 잔액조회, 전송, 조회 기능 


input --> command --     -----  ------      memberManager --> member
            |                       |       ||
            | --> result            | ----- accountManager - account 
                                            ||
                                            ||  
                                            result

[img](step2.png)

