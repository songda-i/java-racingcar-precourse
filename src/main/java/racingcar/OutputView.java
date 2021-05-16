package racingcar;

import java.util.List;

public class OutputView {

    void printMsg(String str) {
        System.out.println(str);
    }

    //자동차 주행 상태 출력 표시 함수
    void printCarGetName(Car[] cars) {
        for (Car car : cars) {
            System.out.print(car.getName());
            System.out.print(" : ");
            printCarGetPosition(car);
            System.out.println();
        }
        System.out.println();
    }

    private void printCarGetPosition(Car car) {
        int carPositionCnt = car.getPosition();
        if (carPositionCnt > 0) {
            for (int k = 0; k < carPositionCnt; k++) {
                System.out.print("-");
            }
        }
    }

    //최종우승 출력 함수
    void printWinner(List<Car> winnerCarsList) {
        System.out.print("최종 우승자: ");
        System.out.print(winnerCarsList.get(0).getName());
        if (winnerCarsList.size() > 1) {
            for (int i = 1; i < winnerCarsList.size(); i++) {
                System.out.print(", ");
                System.out.print(winnerCarsList.get(i).getName());
            }
        }
    }

}
