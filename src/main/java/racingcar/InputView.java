package racingcar;

import java.util.Scanner;

public class InputView {
    int readRacingCount(Scanner scanner) {
        return scanner.nextInt();
    }

    //자동차이름을 읽어 자동차를 리턴
    Car[] readCars(Scanner scanner) {
        String carNameAll = scanner.nextLine();
        String[] carArr = carNameAll.split(",");
        // 각 Car 객체를 담은 배열
        Car[] cars = new Car[carArr.length];
        for (int i = 0; i < carArr.length; i++) {
            cars[i] = new Car(carArr[i]);
        }
        return cars;
    }
}
