package racingcar;

public class RequestDto {
    String[] cars;
    int tc;
    public RequestDto(String[] cars, int tc) {
        this.cars = cars;
        this.tc = tc;
    }
}
