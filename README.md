# noticeboard

네번째 개인어플만들기 "게시판앱"입니다
Java와 Android Volley를 활용하여 개발한 Android 게시판 애플리케이션입니다. 사용자 인증(로그인, 회원가입)부터 게시글 작성, 조회, 수정, 삭제(CRUD) 기능을 포함하며, 서버와의 데이터 통신 및 JSON 파싱을 구현했습니다.




1) 사용자 인증 시스템 구현 
기능: 로그인, 회원가입, 아이디/비밀번호 찾기, 아이디 중복 확인.

 Volley 라이브러리를 이용해 Android와 서버 간의 비동기 통신을 구축하고, 사용자 인증 정보를 POST 방식으로 안전하게 전송하는 로직 구현.

 





2) 게시글 목록 조회 및 동적 UI 구성
기능: 서버에 저장된 게시글 목록(제목, 작성자, 인덱스)을 조회하고 사용자에게 표시.

 서버로부터 JSON 데이터 배열을 수신하여 파싱하고, ArrayList를 활용하여 게시판 목록을 동적으로 생성 및 업데이트하는 UI 로직 구현.

 





3) 게시글 CRUD 기능 구현
생성 : 게시글 제목 및 내용을 입력받아 서버로 전송

조회: 목록에서 선택한 게시글의 상세 내용(제목, 내용, 작성자)을 서버에서 조회하고 화면에 출력 

수정/삭제 

비밀번호 확인 모듈을 통해 사용자 본인 인증 

인증 후, 게시글 내용 수정 또는 삭제 기능을 서버와 연동하여 구현.














사용기술 android java php mysql json

DB서버는 닷홈사이트 


<img src="https://user-images.githubusercontent.com/48806275/139759072-ed3f2840-2f70-4cef-ad9d-deb3c5b85932.jpg " width="20%" height="200%"/> 첫화면

<img src="https://user-images.githubusercontent.com/48806275/139759074-b0016f06-eefd-4846-81b3-513b099beef8.jpg " width="20%" height="200%"/><img src="https://user-images.githubusercontent.com/48806275/139759075-992dea60-3137-4f2a-a0bb-9ae839542f02.jpg" width="20%" height="200%"/>php 이용하여 아이디찾기

<img src="https://user-images.githubusercontent.com/48806275/139759076-16d9b107-8746-4960-a05e-c6e73416af83.jpg" width="20%" height="200%"/><img src="https://user-images.githubusercontent.com/48806275/139759077-726cc738-ca86-4cd3-9f66-f59995a1389b.jpg" width="20%" height="200%"/>php 이용하여 비밀번호찾기

<img src="https://user-images.githubusercontent.com/48806275/139770493-aadf2339-a954-4f23-b03d-a0e4eb6904d0.jpg " width="20%" height="200%"/><img src="https://user-images.githubusercontent.com/48806275/139759082-4a802c8b-a41d-4ecc-b2fe-f2d9a3536580.jpg" width="20%" height="200%"/>회원가입 db저장
<img src="https://user-images.githubusercontent.com/48806275/139770022-85bb8fc9-49c6-4971-90ac-d96f00f83cf5.png" width="50%" height="500%"/>

<img src="https://user-images.githubusercontent.com/48806275/139759056-faef3c0a-1bfc-463c-aae6-cdbb65085fcc.jpg " width="20%" height="200%"/>로그인 완료하면 게시판홈

<img src="https://user-images.githubusercontent.com/48806275/139759058-8caf4bed-6c28-4a84-93d5-115cbb3ec6e3.jpg " width="20%" height="200%"/>애국가 글쓰기

<img src="https://user-images.githubusercontent.com/48806275/139759060-1fb989a4-e353-445e-84a5-51a77cec3e23.png " width="50%" height="500%"/> 글쓰면 db저장

<img src="https://user-images.githubusercontent.com/48806275/139759061-628532ad-aad2-41b5-bc7c-0ceb3150bc74.jpg " width="20%" height="200%"/><img src="https://user-images.githubusercontent.com/48806275/139759062-eaa74c8f-fe4f-43b4-ae80-f4069f813abb.jpg " width="20%" height="200%"/>글수정

<img src="https://user-images.githubusercontent.com/48806275/139759065-152a6e8a-6e78-45d3-9da7-e5af7c5962f8.png" width="50%" height="500%"/> 확인버튼누르면 db가 수정됨

<img src="https://user-images.githubusercontent.com/48806275/139759066-e7b812d1-c083-49e8-b392-fe2883fcb32a.jpg" width="20%" height="200%"/>글삭제 누르면 db에서삭제됨

<img src="https://user-images.githubusercontent.com/48806275/139759069-2d7af086-07e0-40ed-9189-994bce896129.png" width="50%" height="500%"/>

