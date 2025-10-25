package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RequestDto requestDto = input();
        String[] cars = requestDto.cars;
        validateCarNames(cars);
        String tcInput = Console.readLine();
        int tc = validateTrialCount(tcInput);

        StringBuilder[] carBuilders = new StringBuilder[cars.length];
        for (int i = 0; i < cars.length; i++) {
            carBuilders[i] = new StringBuilder();
        }

        StringBuilder output = new StringBuilder();
        while (tc-->0){
            for(int i =0 ; i< cars.length ; i++){
                if(condition()){
                    carBuilders[i].append(" -");
                }
                output.append(cars[i]+" :" + carBuilders[i]).append("\n");
            }

            output.append("\n");
        }

        List<String> winners = findWinners(cars, carBuilders);
        output.append("최종 우승자 : " + winners.get(0));

        if(winners.size() >1){

            for(int i = 1; i<winners.size(); i++){
                output.append(", "+ winners.get(i));
            }
        }
        System.out.println(output);
    }

    static RequestDto input(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] cars = Console.readLine().split(",");

        System.out.println("시도할 횟수는 몇 회인가요?");
        int tc = Integer.parseInt(Console.readLine());
        return new RequestDto(cars, tc);
    }

    static boolean condition(){
        int num = Randoms.pickNumberInRange(0,9);
        return num >= 4;
    }
    static List<String> findWinners(String[] cars, StringBuilder[] carBuilders){
        List<String> winners = new ArrayList<>();
        int maxLength = 0;
        for (StringBuilder builder : carBuilders) {
            if (builder.length() > maxLength) {
                maxLength = builder.length();
            }
        }

        for (int i = 0; i < cars.length; i++) {
            if (carBuilders[i].length() == maxLength && maxLength > 0) {
                winners.add(cars[i]);
            }
        }
        return winners;
    }
    private static void validateCarNames(String[] cars) {
        // 이름이 없는 경우 (예: "a,," 또는 ",a" 등)는 split의 결과에 포함되지 않거나 빈 문자열로 처리됨.
        // 여기서는 trim()을 적용했기 때문에 빈 문자열을 검사합니다.
        if (cars.length == 0 || (cars.length == 1 && cars[0].isEmpty())) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 최소 하나 이상 입력해야 합니다.");
        }

        for (String car : cars) {
            if (car.isEmpty() || car.length() > 5) {
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 1자 이상 5자 이하만 가능합니다. (현재: '" + car + "')");
            }
        }
    }

    private static int validateTrialCount(String tcInput) {
        int tc;
        try {
            tc = Integer.parseInt(tcInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자만 입력해야 합니다.");
        }

        if (tc <= 0) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 1회 이상이어야 합니다.");
        }
        return tc;
    }
}
