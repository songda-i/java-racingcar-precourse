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
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameAll = scanner.nextLine();
        String[] carArr = carNameAll.split(",");
        // 각 Car 객체를 담은 배열
        Car[] cars = new Car[carArr.length];
        for (int i = 0; i < carArr.length; i++) {
            cars[i] = new Car(carArr[i]);
        }
        System.out.println("시도할 회수는 몇 회인가요?");
        int racingCnt = scanner.nextInt();

        System.out.println();
        System.out.println("실행결과");
        for (int x = 0; x < racingCnt; x++) {
            racingRound(cars);
            System.out.println();
        }
        System.out.print("최종 우승자: ");
        winner(cars);
    }

    private static void racingRound(Car[] cars) {
        for (int i = 0; i < cars.length; i++) {
            int randomNum = RandomUtils.nextInt(0, 9);
            if (randomNum > STANDARD_NUMBER) {
                cars[i].addPosition();
            }
            System.out.print(cars[i].getName() + " : ");
            int carPositionCnt = cars[i].getPosition();
            if (carPositionCnt > 0) {
                for (int k = 0; k < carPositionCnt; k++) {
                    System.out.print("-");
                }
            }
            System.out.println();
        }
    }

    private static void winner(Car[] cars) {
        int maxNum = -1;
        List<Integer> maxIdxList = new ArrayList<>();
        for (int i = 0; i < cars.length; i++) {
            if (maxNum < cars[i].getPosition()) maxNum = cars[i].getPosition();
        }
        for (int i = 0; i < cars.length; i++) {
            if (maxNum == cars[i].getPosition()) maxIdxList.add(i);
        }
        System.out.print(cars[maxIdxList.get(0)].getName());
        if (maxIdxList.size() > 1) {
            for (int i = 1; i < maxIdxList.size(); i++) {
                System.out.print(", " + cars[maxIdxList.get(i)].getName());
            }
        }
        System.out.println();
    }
}
