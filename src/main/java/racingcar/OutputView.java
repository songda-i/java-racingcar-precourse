package racingcar;

import java.util.List;

public class OutputView {

    void msgView(String str) {
        System.out.println(str);
    }

    void nextMsgView(String str) {
        System.out.print(str);
    }
    //자동차 주행 상태 출력 표시 함수
    void printCarPosition(Car[] cars, int carIdx) {
        System.out.print(cars[carIdx].getName());
        System.out.print(" : ");
        int carPositionCnt = cars[carIdx].getPosition();
        if (carPositionCnt > 0) {
            for (int k = 0; k < carPositionCnt; k++) {
                System.out.print("-");
            }
        }
        System.out.println();
    }

    //최종우승 출력 함수
    void printWinner(List<Car> winnerCarsList) {
        System.out.print(winnerCarsList.get(0).getName());
        if (winnerCarsList.size() > 1) {
            for (int i = 1; i < winnerCarsList.size(); i++) {
                System.out.print(", ");
                System.out.print(winnerCarsList.get(i).getName());
            }
        }
    }

}
