package springproject.review.domain;

public enum Measure {
    매우그렇다("5"),
    그렇다("4"),
    보통이다("3"),
    그렇지않다("2"),
    매우그렇지않다("1");
    private final String value;

    Measure(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
