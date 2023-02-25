TODO : 
멤버 도메인의 확실한 분리 
- memberdata와 memberdto를 혼용해서 사용하고 있다 (bank에서부터 같이 불러오는 account 정보들을 포함하는 member)
- 두개의 정보를 하나의 멤버 객체를 통해 사용하는 것으로 리팩토링 
- board에서 member 정보를 사용하는 방법 재정의 

- result, repository 객체 통일 필요 
- 