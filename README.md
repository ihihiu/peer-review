# 📌 동료 평가 웹사이트

> 팀 구성원 간의 상호 평가를 손쉽게 진행할 수 있는 웹 기반 평가 시스템입니다. 

---

## 📁 프로젝트 선정 이유

- 기존 기업의 동료 평가 방식은?
  팀장이 평가 양식을 엑셀로 만들어 팀원들에게 일일이 보내고, 그 자료를 취합하여 결과를 보여줍니다.

- 동료 평가 사이트가 있다면?
  - ✅ 표준화된 동료 평가 양식을 편리하게 제공할 수 있습니다. 
  - ✅ 데이터 취합을 안전하고 용이하게 할 수 있습니다.
  - ✅ 결과를 가시적으로 보여줄 수 있습니다.

---

## 👤 지원자 개인 기여

### 담당 역할

| 역할                  |
|-----------------------|
| 백엔드 개발, DB 설계, API 설계 및 구현 |

### 주요 기여

- H2 Database 기반의 ERD 설계 및 테이블 구조 구축  
- 회원 가입 기능 구현 시 입력값 유효성 검증(Validation) 처리  
- 팀장/팀원 구분에 따른 역할 기반 로그인 및 세션 관리 기능 구현    
- 제출된 평가 결과를 기반으로 한 평균 점수 계산 및 결과 조회 기능 개발
- 동료 평가 결과 시각화 기능 개발 (점수 -> 레이더 차트)  
- MVC 패턴에 기반한 Thymeleaf 템플릿 연동 및 동적 페이지 구성  



---

## 🛠 사용 기술 스택

<p align="center">
  <img src="https://img.shields.io/badge/SpringBoot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"/>
  <img src="https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white"/>
  <img src="https://img.shields.io/badge/H2-00599C?style=for-the-badge&logo=h2&logoColor=white"/>
  <img src="https://img.shields.io/badge/Thymeleaf-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white"/>
  <img src="https://img.shields.io/badge/IntelliJIDEA-000000?style=for-the-badge&logo=intellijidea&logoColor=white"/>
</p>

---

## 🖥️ 주요 화면

### [홈 화면]
![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/2eca7098-509b-4340-bd11-b6f6c99298a1/a71786ce-544b-4a40-90ef-e9524d3e622c/Untitled.png)

### 1. 회원 가입

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/2eca7098-509b-4340-bd11-b6f6c99298a1/b4727b18-af31-4f37-8512-6fd38a57e510/Untitled.png)
![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/2eca7098-509b-4340-bd11-b6f6c99298a1/26f97cce-24ee-44e7-9287-86e0b9cf7155/Untitled.png)
- 회사 이메일로 회원 가입을 합니다.
    - 아이디 중복 검사를 합니다.
    - 이름은 2글자 이상, 비밀번호는 8자 이상 입력해야 합니다.
    - 부서와 직위를 선택하여 회원 가입합니다.
 
### 2. 로그인
![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/2eca7098-509b-4340-bd11-b6f6c99298a1/723c5c22-badd-4354-a44f-d33069a34f1c/Untitled.png)
![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/2eca7098-509b-4340-bd11-b6f6c99298a1/4e2ca576-e95a-44ad-ba5b-5cd4d5dc595a/Untitled.png)
![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/2eca7098-509b-4340-bd11-b6f6c99298a1/9bb48dcf-d764-4c4a-a4f4-9bfba7438b7c/Untitled.png)

### 3. [팀장] 평가지 생성
![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/2eca7098-509b-4340-bd11-b6f6c99298a1/f2e8d296-a5cd-4181-89f9-c2324f2a8ad5/Untitled.png)
- 본인의 부서, 현재 연도가 자동으로 선택됩니다.
- 분기를 선택한 후 평가지를 생성할 수 있습니다.

### 4. [팀원] 평가하기
![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/2eca7098-509b-4340-bd11-b6f6c99298a1/4cdc8a38-c514-48b5-abed-62df5f6f50e0/Untitled.png)
- 평가하기를 누르면 소속된 팀원 리스트가 나옵니다.

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/2eca7098-509b-4340-bd11-b6f6c99298a1/b40afcc2-a46b-4461-9ea8-b09f9fbcfa73/Untitled.png)
- 평가하기를 눌러 팀원을 평가할 수 있으며, 평가가 완료되면 상태가 바뀝니다.

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/2eca7098-509b-4340-bd11-b6f6c99298a1/5ccf3abe-d155-466d-b2c3-df717504d996/Untitled.png)
![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/2eca7098-509b-4340-bd11-b6f6c99298a1/cf8696b8-3c37-4752-8a6e-a41950d470ba/Untitled.png)

### 5. [팀원] 결과 학인하기
![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/2eca7098-509b-4340-bd11-b6f6c99298a1/36b72d1a-2e57-41de-922b-88f5c1f7cb16/Untitled.png)
- 모든 팀원이 평가를 완료하면, 결과 집계 중에서 결과보기 버튼으로 바뀝니다.

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/2eca7098-509b-4340-bd11-b6f6c99298a1/b8a0214a-70a3-48fa-a74a-c1b760451d32/Untitled.png)
![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/2eca7098-509b-4340-bd11-b6f6c99298a1/752e1dca-b05a-4a3d-aef7-0f2e5ea424ca/Untitled.png)
- 피평가자의 점수가 소수점 둘째 자리까지 표시되며, 해당 점수가 레이다 차트로 표시됩니다.
- 등급은 다음과 같이 알파벳으로 표현됩니다.
    - 4점 이상: ‘A’   /  3점 이상 4점 미만 : ‘B’
        
        2점 이상 3점 미만 : ‘C’    /     2점 미만: ‘D’

### 6. [팀장] 결과 보기
![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/2eca7098-509b-4340-bd11-b6f6c99298a1/ce4cc9db-5c27-4620-83e3-0b9523c4ca4e/Untitled.png)
![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/2eca7098-509b-4340-bd11-b6f6c99298a1/2397defe-2e71-47e2-b22f-5d6308e7eff9/Untitled.png)
- 소속된 팀원의 모든 결과를 볼 수 있습니다.
