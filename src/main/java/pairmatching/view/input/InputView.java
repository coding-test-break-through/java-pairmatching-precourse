package pairmatching.view.input;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.matching.dto.MatchingSelection;
import pairmatching.view.input.formatter.InputFormatter;
import pairmatching.view.input.validator.FeatureValidator;
import pairmatching.view.input.validator.MatchingSelectionValidator;
import pairmatching.view.input.validator.ReMatchingValidator;

public class InputView implements Reader {

    @Override
    public String readLine() {
        return Console.readLine();
    }

    public String readSelectFeature() {
        System.out.print("""
                                
                기능을 선택하세요.
                1. 페어 매칭
                2. 페어 조회
                3. 페어 초기화
                Q. 종료
                """);

        return new FeatureValidator().validate(readLine());
    }

    public MatchingSelection readMatchingSelection() {
        System.out.print("""
                #############################################
                과정: 백엔드 | 프론트엔드
                미션:
                  - 레벨1: 자동차경주 | 로또 | 숫자야구게임
                  - 레벨2: 장바구니 | 결제 | 지하철노선도
                  - 레벨3:\s
                  - 레벨4: 성능개선 | 배포
                  - 레벨5:\s
                ############################################
                과정, 레벨, 미션을 선택하세요.
                ex) 백엔드, 레벨1, 자동차경주
                """);

        return new MatchingSelectionValidator().validate(readLine());
    }

    public boolean getReMatchingOrNot() {
        System.out.print("""
                매칭 정보가 있습니다. 다시 매칭하시겠습니까?
                네 | 아니오
                """);

        String inputValue = new ReMatchingValidator().validate(readLine());
        return InputFormatter.formatRestartOrNot(inputValue);
    }
}