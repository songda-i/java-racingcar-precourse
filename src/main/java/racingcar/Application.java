package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import utils.RandomUtils;

public class Application {

    private static final int STANDARD_NUMBER = 4;

    public static void main(String[] args) throws Exception {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        outputView.printMsg("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        Car[] cars = inputView.readCars(scanner);

        outputView.printMsg("시도할 회수는 몇 회인가요?");
        int racingCnt = inputView.readRacingCount(scanner);

        outputView.printMsg("\n실행결과");
        for (int x = 0; x < racingCnt; x++) {
            for (int carIdx = 0; carIdx < cars.length; carIdx++) {
                setCarPosition(cars, carIdx);
            }
            outputView.printCarGetName(cars);
        }

        List<Car> winnerCarsList = getWinnerCars(cars);
        outputView.printWinner(winnerCarsList);
    }


    private static void setCarPosition(Car[] cars, int carIdx) {
        int randomNum = RandomUtils.nextInt(0, 9);
        if (randomNum > STANDARD_NUMBER) {
            cars[carIdx].addPosition();
        }
    }

    private static int getMaxPosition(Car[] cars) {
        int maxNum = -1;
        for (Car car : cars) {
            if (maxNum < car.getPosition()) {
                maxNum = car.getPosition();
            }
        }
        return maxNum;
    }

    private static List<Car> getWinnerCars(Car[] cars) {
        int maxNum = getMaxPosition(cars);
        List<Car> winnerCarsList = new ArrayList<>();
        for (Car car : cars) {
            if (maxNum == car.getPosition()) {
                winnerCarsList.add(car);
            }
        }
        return winnerCarsList;
    }
}
