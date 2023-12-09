package pairmatching;

import java.util.List;

public class OutputView {
    void showMatching(List<List<String>> input){
        System.out.println("페어 매칭 결과입니다.");
        for(List<String> sublist : input) {
            System.out.println(String.join(" : ", sublist));
        }
        System.out.println();
    }
}
