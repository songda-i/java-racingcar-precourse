package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import utils.RandomUtils;

public class Application {

    private static final int STANDARD_NUMBER = 4;

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        View view = new View();
        view.OutputView("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        view.EmptyView();
        String carNameAll = scanner.nextLine();
        String[] carArr = carNameAll.split(",");
        // 각 Car 객체를 담은 배열
        Car[] cars = new Car[carArr.length];
        for (int i = 0; i < carArr.length; i++) {
            cars[i] = new Car(carArr[i]);
        }
        view.OutputView("시도할 회수는 몇 회인가요?");
        view.EmptyView();
        int racingCnt = scanner.nextInt();

        view.EmptyView();
        view.OutputView("실행결과");
        view.EmptyView();
        for (int x = 0; x < racingCnt; x++) {
            racingRound(cars, view);
            view.EmptyView();
        }
        view.OutputView("최종 우승자: ");
        winner(cars, view);
    }

    private static void racingRound(Car[] cars, View view) {
        for (int i = 0; i < cars.length; i++) {
            int randomNum = RandomUtils.nextInt(0, 9);
            if (randomNum > STANDARD_NUMBER) {
                cars[i].addPosition();
            }
            view.OutputView(cars[i].getName());
            view.OutputView(" : ");
            int carPositionCnt = cars[i].getPosition();
            if (carPositionCnt > 0) {
                for (int k = 0; k < carPositionCnt; k++) {
                    view.OutputView("-");
                }
            }
            view.EmptyView();
        }
    }

    private static void winner(Car[] cars, View view) {
        int maxNum = -1;
        List<Integer> maxIdxList = new ArrayList<>();
        for (int i = 0; i < cars.length; i++) {
            if (maxNum < cars[i].getPosition()) maxNum = cars[i].getPosition();
        }
        for (int i = 0; i < cars.length; i++) {
            if (maxNum == cars[i].getPosition()) maxIdxList.add(i);
        }
        view.OutputView(cars[maxIdxList.get(0)].getName());
        if (maxIdxList.size() > 1) {
            for (int i = 1; i < maxIdxList.size(); i++) {
                view.OutputView(", ");
                view.OutputView(cars[maxIdxList.get(i)].getName());
            }
        }
    }
}
