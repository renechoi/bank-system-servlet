구현 해야 할 목록

## 예외 처리
- 로그인 안 되어 있을 경우 1차적으로 not login error -> alert msg로 로그인 요청 발생 -> 홈으로 redirect
- 내부 예외 -> 에러별 alert msg로 메시지 전달 -> 적절 response

## front page
- 로그인이 되어 있을 때와 안 되어 있을 때 다르게 전달
- 확인을 위해 db 현황 출력 



## 기타 
- 회원 탈퇴 기능 + 페이지 
- 입력값들에 대한 validation + 에러 창 


### 특징사항 
- info message 전달을 위한 record 객체 별도 생성
- 
### Q. 
- db 정보를 전체 가져올 때 리스트로 가져오는데 이것을 dao에서 public으로 열어서 한번에 가져온다..? 
- members 복수형 객체를 만들어서 list collection을 갖도록 하는 것은 . .? 
