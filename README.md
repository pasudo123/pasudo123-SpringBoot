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


### 뭔가 익혔다고 생각하는데...
- vue 에서 actions 호출시 commit 여러번 하니깐 전달인자 분해기법이 있음
  - 말 그대로 인자를 분해하는 기법 actionModule(context, payload) === actionsModule({commit}, payload) 이렇게 간다.
- font-awesome vue 설치 내용

### 참고들
- [앵귤러 상 올바른 커밋 메시지 작성 방법](https://github.com/angular/angular/blob/master/CONTRIBUTING.md#-commit-message-guidelines)
