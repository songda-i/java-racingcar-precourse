21.05.13

### 💻 프로그래밍 실행 결과 예시

```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 회수는 몇회인가요?
5

실행 결과
pobi : -
woni : 
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

최종 우승자: pobi, jun
```

## :a: 기능

### 1차 Application 기능 구현

- [x] 입력된 자동차 모으고 갯수세기 carCnt 
  - [x] 글자수 5초과 err
- [x] 입력된 시도횟수 int gameCnt
  - [x] 숫자아님 err
- [x] 각 자동차 랜덤수 뽑기 random
  - [x] 3이하 +0 / 4이상 +1위치
- [x] 회당 각 자동차 출력
- [x] 가장 많은 위치 자동차 담아서 출력

```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
a,b,c,d,e
[a, b, c, d, e]5[0, 0, 0, 0, 0]
시도할 회수는 몇 회인가요?
4

실행결과
 a 랜덤(5) : -
 b 랜덤(1) : 
 c 랜덤(0) : 
 d 랜덤(7) : -
 e 랜덤(6) : -

 a 랜덤(6) : --
 b 랜덤(9) : -
 c 랜덤(3) : 
 d 랜덤(2) : -
 e 랜덤(6) : --

 a 랜덤(9) : ---
 b 랜덤(9) : --
 c 랜덤(9) : -
 d 랜덤(9) : --
 e 랜덤(0) : --

 a 랜덤(0) : ---
 b 랜덤(5) : ---
 c 랜덤(8) : --
 d 랜덤(7) : ---
 e 랜덤(7) : ---

[3, 3, 2, 3, 3]
최종 우승자:a, b, d, e
=========
idx[0, 1, 3, 4]

```



### 2차 프로그래밍 요구사항

- [x] Car 객체 사용

  - [x] String[] carArr 와 int[] carPositionNum 의 데이터를 묶어서
    각 Car 인스턴스로 쓰자

    

### 3차 리팩토링

- [x] 함수 분리 (ctrl+alt+M) 
  - [x] 깊이는 2까지
  - [x] 메서드는 15라인

- [x] View in/output

  - [x] 출력과 입력은 View에서 처리를 해야한다.(View가 아닌 다른곳에서 scanner와 sout 사용 X)

  - [x] InputView - 입력에 관련된 출력과 입력을 받아 입력을 리턴한다.

  - [x] OutputView - 출력만 할때 필요한 데이터를 파라미터로 전달하여 출력한다.

    

## :rabbit2: 피드백

### ERROR

- [x] error

- [ERROR] 시도 횟수는 숫자여야 한다.
- [ERROR] 자동차 이름은 5자 이하만 가능합니다.



### 점검

- [x] 메서드는 15라인
- [x] else 예약어 안쓰기



### STDUY

- for each 문 : for i 에서 i를 안쓰고 그 배열의 원소 자체를 사용할 때 대체해서 직관적으로 사용

- Exception

  - ```
    // 비추천
    
    e.printStackTrace(); // 에러추적문구
    System.exit(1); // 비정상종료
    ```

  - ```
    // 추천 : try catch로 처리 할 때까지 위로위로 e 올라간다
    
    throw new RuntimeException; // 언체크Exception
    ```

    