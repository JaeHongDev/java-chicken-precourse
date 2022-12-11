package domain.payment;

import exception.InvalidInputException;
import java.util.Arrays;
import java.util.stream.Collectors;

public enum Payment {
    CARD("1", "신용 카드"),
    CASH("2", "현금");

    private final String command;
    private final String message;


    Payment(String command, String message) {
        this.command = command;
        this.message = message;
    }

    public static Payment from(final String input) {
        return Arrays.stream(values())
                .filter(payment -> payment.command.equals(input.trim()))
                .findAny()
                .orElseThrow(() -> new InvalidInputException("유효하지 않는 결제방식입니다.", input));
    }

    public static String messages() {
        return Arrays.stream(values())
                .map(payment -> String.format("%s는 %s번", payment.message, payment.command))
                .collect(Collectors.joining(","));
    }
}
