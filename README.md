# java-racingcar-precourse
## 함수 설명
### input()

사용자로부터 경주할 자동차 이름과 시도 횟수를 입력받고, 이를 $\texttt{RequestDto}$ 객체로 만들어 반환합니다. 입력 과정에서 기본적인 유효성 검사를 수행합니다.

### validateCarNames(String[] cars)

자동차 이름 목록의 유효성을 검사합니다. 이름이 1개 이상인지, 그리고 각 이름의 길이가 1자 이상 5자 이하인지 확인하며, 위반 시 $\texttt{IllegalArgumentException}$을 발생시킵니다.

### validateTrialCount(String tcInput)

시도 횟수 문자열을 정수로 변환하고 유효성을 검사합니다. 입력값이 숫자인지, 그리고 그 값이 1 이상인지 확인하며, 위반 시 $\texttt{IllegalArgumentException}$을 발생시키고, 유효하면 정수형 횟수를 반환합니다.

### condition()

자동차 전진 조건을 판단합니다. $\texttt{Randoms.pickNumberInRange(0, 9)}$를 사용하여 무작위 숫자를 뽑고, 이 숫자가 4 이상일 경우 $\texttt{true}$ (전진)를 반환합니다.

### findWinners(String[] cars, StringBuilder[] carBuilders)

모든 $\texttt{carBuilders}$의 길이를 비교하여 최대 전진 거리를 찾고, 이 최대 거리와 동일한 길이를 가진 모든 자동차 이름을 리스트에 담아 최종 우승자 목록을 선정합니다.
