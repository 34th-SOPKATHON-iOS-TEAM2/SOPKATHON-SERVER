# 🏆 너 이거 알아?  🏆
문해력 부재를 가장 트렌디하게 채우자.

## 주요 기능
1. 문해력 퀴즈: 1일 5문제 재밌는 문해력 퀴즈 풀기
2. 퀴즈 공유: 너 이거 알아? 친구에게 공유하기
3. 기록: 나의 퀴즈 기록을 확인해요!


## Developers ✨
| 김채원 | 고나연                                                                                                          |
|----------|--------------------------------------------------------------------------------------------------------------|
| ![image](https://github.com/poten001/Ochaelwan-Server/assets/113420297/87b6a50f-f67d-4d9e-aa88-c7561dcb3a1c) | ![image](https://github.com/34th-SOPKATHON-iOS-TEAM2/server/assets/113420297/dd24907a-1064-455d-abef-607cd123657b) |
| <p align="center"> SERVER </p> | <p align="center"> SERVER </p> |

## Role Distribution 🎯
| Role                                 | Developer |
|--------------------------------------|-----|
| 문제 상세 조회, 문제 풀이, 문제 상세 조회            | 김채원 |
| 멤버 생성, 문제 조회(홈 화면),채점표 조회, 기록 리스트 조회 | 고나연 |


## ERD 🗂️
![image](https://github.com/34th-SOPKATHON-iOS-TEAM2/server/assets/113420297/b86b6e19-59ee-450f-ba19-99361b78ef13)

## Foldering 🗂️
![image](https://github.com/34th-SOPKATHON-iOS-TEAM2/server/assets/113420297/365495bf-6ae4-4602-8013-badc05195aab)

## API Specification 🔗
[API 명세서 바로가기](https://www.notion.so/bohyunnkim/API-f3c0104eb3ec40d1bca1b84258c35803) <br>

![image](https://github.com/34th-SOPKATHON-iOS-TEAM2/server/assets/113420297/dcf06d13-f200-447e-8d5d-7d28e1fedaba) <br>

## Code Convention 🔗
[Code 컨벤션 바로가기](https://www.notion.so/bohyunnkim/Convention-39662e13a4b94b1c8bd005b751bdb43d) <br>

## 1. 브랜치 컨벤션

### 브랜치 운영 방식

> Git Flow 전략
>

![image](https://github.com/34th-SOPKATHON-iOS-TEAM2/server/assets/113420297/6d01ef5c-e195-413b-b99f-03b70660b2ef)

<aside>
💡  `main` **→ 우린 이걸 default 브랜치로!**

`feat`: 기능을 개발하면서 각자가 사용할 브랜치

브랜치명은 “**feat/#이슈 번호**” 형식

**예시**: `feat/#3`

</aside>

## 2. 커밋 컨벤션

- `[FEAT]` : 새로운 기능 구현
- `[CHORE]` : 동작에 영향 없는 코드 or 변경 없는 변경 사항(주석 추가 등)
- `[ADD]` : Feat 이외의 부수적인 코드 추가, 라이브러리 추가, 새로운 파일 생성
- `[DEL]` : 쓸모 없는 코드 삭제
- `[RENAME]` : 파일 명, 변수 명 수정
- `[FIX]` : 코드 수정, 버그/오류 해결
- `[DOCS]` : README나 WIKI 등의 문서 수정
- `[DEPLOY]`: 배포 관련
- `[REFACTOR]` : 전면 수정, 코드 리팩토링
- `[MERGE]`: 다른 브랜치와 병합
- `[TEST]`: 테스트 추가/수정
- `[HOTFIX]` : 급한 핫픽스

### 커밋 단위

- 세부 기능 기준

### 커밋 예시

> **[FEAT]  #이슈번호  내용**
>

`ex ) git commit -m "[FEAT] #2 로그인 기능 구현"`

## 3. 이슈 & PR 컨벤션

### **이슈/PR 생성 시 제목 형식**

> **[FEAT]  구현한 내용**
>

**예시 : `[FEAT] 홈 화면 즐겨찾기 API 구현`**

### ❗이슈 템플릿

```bash
<!--- 
❗️ 이슈 제목은 아래의 형식을 맞춰주세요 
- [FEAT] 기능 추가
- [FIX] 에러 수정, 버그 수정
- [CHORE] gradle 세팅, 위의 것 이외에 거의 모든 것
- [DOCS] README, 문서
- [REFACTOR] 코드 리펙토링 (기능 변경 없이 코드만 수정할 때)
- [MODIFY] 코드 수정 (기능의 변화가 있을 때)
-->

## ✨ 이슈 내용

-

## ✅ 체크리스트

- [ ] Assignees / Labels 선택
- [ ] 
- [ ]
```

### ❗PR 템플릿

```bash
<!-- - 
❗️ PR 제목은 아래의 형식을 맞춰주세요 
- [FEAT] 기능 추가
- [FIX] 에러 수정, 버그 수정
- [CHORE] gradle 세팅, 위의 것 이외에 거의 모든 것
- [DOCS] README, 문서
- [REFACTOR] 코드 리펙토링 (기능 변경 없이 코드만 수정할 때)
- [MODIFY] 코드 수정 (기능의 변화가 있을 때)
-->

## 📌 관련 이슈
<!-- 관련있는 이슈 번호(#000)을 적어주세요.
  해당 pull request merge와 함께 이슈를 닫으려면
  closed #Issue_number를 적어주세요 -->

## ✨ 어떤 이유로 변경된 내용인지
<!-- 어떤 기능을 만들기 위한 내용인지 적어주세요 -->
<!— 그게 아닌 경우에는 어떤 문제를 해결하기 위한 것인지 적어주세요 —>

## 🙏 검토 혹은 리뷰어에게 남기고 싶은 말
<!— Reviewers, Assignees, Labels 지정해주세요 —>
```


![image](https://github.com/34th-SOPKATHON-iOS-TEAM2/server/assets/113420297/76a7d476-55e0-4574-ac7b-f6b98faf827d)
