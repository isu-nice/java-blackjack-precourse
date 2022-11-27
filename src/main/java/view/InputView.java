package view;

import domain.exception.ExceptionMessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputView {
    private static final String INPUT_PLAYER_NAME = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    private static final String INPUT_BETTING_MONEY = "의 베팅금액은?";
    private static final String NAME_REGEX = "^[a-z]+$";
    private static final String MONEY_REGEX = "^[0-9]+$";
    private static final int START_MONEY_RANGE = 0;
    private static final int END_MONEY_RANGE = 100_000_000;

    private static final BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

    public static List<String> readPlayerName() throws IOException {
        System.out.println(INPUT_PLAYER_NAME);
        List<String> playerName = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(console.readLine(), ",");
        while (tokenizer.hasMoreTokens()) {
            String name = tokenizer.nextToken();
            validateName(name);
            playerName.add(name);
        }
        return playerName;
    }

    private static void validateName(String name) {
        if (!name.matches(NAME_REGEX)) {
            throw new IllegalArgumentException(ExceptionMessage.ONLY_ALPHABET);
        }
    }

    public static int readBettingMoney(String name) throws IOException {
        System.out.println(name + INPUT_BETTING_MONEY);
        String bettingMoney = console.readLine();

        return Integer.parseInt(bettingMoney);
    }

}
