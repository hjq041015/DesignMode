package demo;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TvStation tvStation = new TvStation();
        WeatherStation weatherStation = new WeatherStation(tvStation);

        User Tom = new User("Tom", (info) -> {
            if (info.equals("晴天")) {
                System.out.println("Tom: 今天是个好天气，适合出去玩！");
            } else {
                System.out.println("Tom: 今天下雨了，还是待在家里吧。");
            }
        });

        User Jerry = new User("Jerry", (info) -> {
            if (info.equals("晴天")) {
                System.out.println("Jerry: 今天是个好天气，适合出去玩！");
            } else {
                System.out.println("Jerry: 今天下雨了，还是待在家里吧。");
            }
        });

        tvStation.subscribe(Tom, demo.WeatherUpdateEvent.class);
        tvStation.subscribe(Jerry, demo.WeatherUpdateEvent.class);



        weatherStation.start();
    }


}