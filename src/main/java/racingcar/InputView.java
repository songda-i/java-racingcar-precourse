package racingcar;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    public static final int LIMIT_CAR_NAME = 5;

    int readRacingCount(Scanner scanner) {
        int racingCnt = 0;
        try {
            racingCnt = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
//            e.printStackTrace();
//            System.exit(1);
            throw e;
        }
        return racingCnt;
    }

    //자동차이름을 읽어 자동차를 리턴
    public Car[] readCars(Scanner scanner) {
        String carNameAll = scanner.nextLine();
        String[] carArr = carNameAll.split(",");
        checkCarName(carArr);
        // 각 Car 객체를 담은 배열
        Car[] cars = new Car[carArr.length];
        for (int i = 0; i < carArr.length; i++) {
            cars[i] = new Car(carArr[i]);
        }
        return cars;
    }

    private void checkCarName(String[] carArr) {
        for (String car : carArr) {
            if (car.length() > LIMIT_CAR_NAME) {
                System.out.println("[ERROR] 자동차 이름은 5자 이하만 가능합니다.");
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }
}
