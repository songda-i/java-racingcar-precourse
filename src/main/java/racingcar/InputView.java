package racingcar;

import java.util.Scanner;

public class InputView {

    public static final int LIMIT_CAR_NAME = 5;

    int readRacingCount(Scanner scanner) {
        return scanner.nextInt();
    }

    //자동차이름을 읽어 자동차를 리턴
    public Car[] readCars(Scanner scanner) throws Exception {
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

    private void checkCarName(String[] carArr) throws Exception {
        for (String car : carArr) {
            if (car.length() > LIMIT_CAR_NAME) {
                System.out.println("[ERROR] 자동차 이름은 5자 이하만 가능합니다.");
                throw new Exception();
            }
        }
    }
}
