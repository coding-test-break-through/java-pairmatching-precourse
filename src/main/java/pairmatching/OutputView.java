package pairmatching;

import java.util.List;

public class OutputView {
    void showList() {
        System.out.println(
                "#############################################\n" +
                        "과정: 백엔드 | 프론트엔드\n" +
                        "미션:\n" +
                        "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n" +
                        "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n" +
                        "  - 레벨3: \n" +
                        "  - 레벨4: 성능개선 | 배포\n" +
                        "  - 레벨5: \n" +
                        "############################################");
    }

    void showMatching(List<List<String>> input){
        System.out.println("페어 매칭 결과입니다.");
        for(List<String> sublist : input) {
            System.out.println(String.join(" : ", sublist));
        }
        System.out.println();
    }
}
