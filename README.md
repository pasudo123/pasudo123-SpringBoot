# SpringBoot + Vue.js
* pasudo123`s SpringBoot Study Sample Code
* Restful Application + Vue Application
* 뭐라도 만들며 공부하자

### Vue 설치 & [Dependencies graph](https://github.com/pasudo123/pasudo123-spring-boot-app/network/dependencies)
* vue cli 3.x
* 순서대로 진행하였음
  1. vue 프로젝트 생성
  2. axios 플러그인 설치
  3. vuex 설치 (의존성 주입, package.json)
  4. vue-router 설치 (의존성 주입, pakcage.json)
  5. vuetify 플러그인 설치

```code
vue create frontend

vue add axios

npm install vuex --save

npm install vue-router

vue add vuetify
```

### 할 일
- [ ] Album Enroll Layout
- [ ] Album Enroll (Comment, Picture)
- [ ] Album Page navigation

### 프로젝트를 하면서 배운 것들 나열(진짜 나열)
- form 태그 내에 input type = text 존재 시, Enter 키를 누르면 자동으로 submit() 이 작동한다. 여러 개의 인풋 타입 텍스트에도 동일하게 동작하는 것을 확인
- vuex 에는 helper function 이라는 유용한 함수가 존재
  1. three dots operator 가 존재 [link](https://dev.to/sagar/three-dots---in-javascript-26ci)

### 참고들
- [앵귤러 상 올바른 커밋 메시지 작성 방법](https://github.com/angular/angular/blob/master/CONTRIBUTING.md#-commit-message-guidelines)

