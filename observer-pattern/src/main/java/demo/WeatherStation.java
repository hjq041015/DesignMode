package demo;

import java.util.Random;

public class WeatherStation {
    private final TvStation tvStation;

    public WeatherStation (TvStation tvStation) {
        this.tvStation = tvStation;
    }

    public String getInfo() {
        if (new Random().nextBoolean()) {
            return "晴天";
        }
        return "雨天";
    }

    public void start() throws InterruptedException {
        while (true) {
            String info = getInfo();
            WeatherUpdateEvent weatherUpdateEvent = new WeatherUpdateEvent(info);
            tvStation.publish(weatherUpdateEvent);
            Thread.sleep(3000);
        }
    }


}