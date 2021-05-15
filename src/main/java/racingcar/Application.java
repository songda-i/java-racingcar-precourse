package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import utils.RandomUtils;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameAll = scanner.nextLine();
        String[] carArr = carNameAll.split(",");
        int carCnt = carArr.length;
        int[] carPositionNum = new int[carCnt];
        System.out.println(Arrays.toString(carArr) + carCnt + Arrays.toString(carPositionNum));
        System.out.println("시도할 회수는 몇 회인가요?");
        int gameCnt = scanner.nextInt();

        System.out.println("실행결과");
        for (int x = 0; x < gameCnt; x++) {
            for (int i = 0; i < carCnt; i++) {
                int randomNum = RandomUtils.nextInt(0, 9);
                if (randomNum > 4) {
                    carPositionNum[i] += 1;
                }
                System.out.print(" " + carArr[i] + " 랜덤(" + randomNum + ") : ");
                int carPositionCnt = carPositionNum[i];
                if (carPositionCnt > 0) {
                    for (int k = 0; k < carPositionCnt; k++) {
                        System.out.print("-");
                    }
                }
                System.out.println();
            }
            System.out.println();
        }

        System.out.println(Arrays.toString(carPositionNum));
        System.out.print("최종 우승자: ");

        int maxNum = -1;
        List<Integer> maxIdxList = new ArrayList<>();
        for (int i = 0; i < carCnt; i++) {
            if (maxNum < carPositionNum[i]) {
                maxNum = carPositionNum[i];
            }
        }
        for (int i = 0; i < carCnt; i++) {
            if (maxNum == carPositionNum[i]) {
                maxIdxList.add(i);
            }
        }
        System.out.print(carArr[maxIdxList.get(0)]);
        if (maxIdxList.size() > 1) {
            for (int i = 1; i < maxIdxList.size(); i++) {
                System.out.print(", " + carArr[maxIdxList.get(i)]);
            }
        }
        System.out.println();
        System.out.println("=========");
        System.out.println("idx" + maxIdxList);
    }
}
