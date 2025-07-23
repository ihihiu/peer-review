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
- 팀장/팀원 구분에 따른 역할 기반 로그인    
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

<p align="center">
  <img width="400" alt="홈 화면" src="https://github.com/user-attachments/assets/4b530797-a02e-4b30-a226-1621e3230986" />
</p>

---

### 1. 회원 가입

<p align="center">
  <img width="360" height="360" alt="회원가입1" src="https://github.com/user-attachments/assets/1726905f-d236-4e4a-b20e-10e3aedaff55" />
  &nbsp;&nbsp;
  <img width="360" height="360" alt="회원가입2" src="https://github.com/user-attachments/assets/3f70502d-11cc-419b-a039-f631569ff9dd" />
</p>

- 회사 이메일로 회원 가입을 합니다.
- 아이디 중복 검사, 이름 2글자 이상, 비밀번호 8자 이상 입력 요구
- 부서와 직위를 선택하여 가입 가능

---

### 2. 로그인

<p align="center">
  <img width="360" height="260" alt="로그인1" src="https://github.com/user-attachments/assets/3bc8d523-fe00-43b1-aa7c-12147740b7fe" />
  &nbsp;&nbsp;
  <img width="360" height="260" alt="로그인2" src="https://github.com/user-attachments/assets/cd80825f-c7c9-48e3-b7e5-b223264f118b" />
</p>

<p align="center">
  <img width="600" height="360" alt="로그인3" src="https://github.com/user-attachments/assets/25c5c868-ed65-43d7-b069-7bf5df13cb6d" />
</p>

- 회사 이메일과 비밀번호로 로그인합니다.
- 로그인 후 세션 기반으로 사용자 인증이 유지됩니다.

---

### 3. [팀장] 평가지 생성

<p align="center">
  <img width="500" height="420" alt="평가지 생성" src="https://github.com/user-attachments/assets/f45c126b-775b-4501-8e7c-8a4383dbf040" />
</p>

- 본인 부서와 현재 연도 자동 설정
- 분기를 선택해 새 평가지 생성 가능

---

### 4. [팀원] 평가하기

<p align="center">
  <img width="420" height="320" alt="팀원 리스트" src="https://github.com/user-attachments/assets/5b622091-15b7-428b-8692-9fa86e5298e2" />
</p>

- 소속된 팀원 리스트가 자동으로 표시됩니다.

<p align="center">
  <img width="400" height="270" alt="평가 상태 변경" src="https://github.com/user-attachments/assets/fd46fc76-8ac8-4b74-a661-44878703faaa" />
</p>

- 평가 완료 시, 평가 상태가 변경됩니다.

<p align="center">
  <img width="360" height="400" alt="평가 화면1" src="https://github.com/user-attachments/assets/b8fc266d-abf0-47c5-84be-8c66ff419e00" />
  &nbsp;&nbsp;
  <img width="360" height="320" alt="평가 화면2" src="https://github.com/user-attachments/assets/68401ee2-ebaa-4c77-ab0c-00bebbf9917f" />
</p>

---

### 5. [팀원] 결과 확인하기

<p align="center">
  <img width="430" height="180" alt="결과 대기" src="https://github.com/user-attachments/assets/9b83a22e-4e4c-4d8e-b690-fd7beaf1397b" />
</p>

- 모든 팀원이 평가를 완료하면 결과 확인이 가능합니다.

<p align="center">
  <img width="430" height="180" alt="결과 확인 버튼" src="https://github.com/user-attachments/assets/5e88b66d-6d52-41e6-bfef-895859047002" />
</p>

<p align="center">
  <img width="360" height="380" alt="점수 및 차트1" src="https://github.com/user-attachments/assets/04a687ea-d774-42a6-b160-2fe3623d8088" />
</p>

- 소수점 2자리까지 점수 표시 및 **레이더 차트 시각화**
- 평가 등급 기준  
  A (4점 이상) / B (3 ~ 4점) / C (2 ~ 3점) / D (2점 미만)

---

### 6. [팀장] 결과 보기

<p align="center">
  <img width="360" height="420" alt="팀장 결과1" src="https://github.com/user-attachments/assets/7b4489fc-790a-4929-ad94-540747ce1a0a" />
  &nbsp;&nbsp;
  <img width="360" height="360" alt="팀장 결과2" src="https://github.com/user-attachments/assets/a27834f0-eb23-4a7b-9a91-f060d7e05461" />
</p>

- 팀장은 모든 팀원의 결과를 한눈에 확인할 수 있습니다.

