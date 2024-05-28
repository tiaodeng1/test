package com.dapeng.service.impl;

import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dapeng.dao.mapper.WeatherDTOMapper;
import com.dapeng.dto.WeatherDTO;
import com.dapeng.service.WeatherService;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl extends ServiceImpl<WeatherDTOMapper,WeatherDTO> implements WeatherService {



    @Override
    public WeatherDTO getWeather(String cityStr){
        String apiKey = "9967651d646ff8c3a24cbd1cb0bf38bf";
        String city = cityStr;
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);

            try (CloseableHttpResponse response = httpClient.execute(request)) {
                // 检查响应状态码
                if (response.getStatusLine().getStatusCode() == 200) {
                    String json = EntityUtils.toString(response.getEntity());
                    JSONObject data = new JSONObject(json);

                    // 提取所需的天气信息
                    JSONObject weather = data.getJSONArray("weather").getJSONObject(0);
                    String weatherDescription = weather.getStr("description");

                    JSONObject main = data.getJSONObject("main");
                    double temperature = main.getDouble("temp");
                    int humidity = main.getInt("humidity");

                    WeatherDTO nowweather = WeatherDTO.builder()
                            .Weather(weatherDescription)
                            .Temperature(temperature)
                            .Humidity(humidity)
                            .build();
                    save(nowweather);
                    return nowweather;

                    // 打印天气信息

                } else {
                    System.err.println("HTTP error occurred: " + response.getStatusLine().getStatusCode());
                }
            }
        } catch (Exception e) {
            System.err.println("Error occurred: " + e.getMessage());
        }
        return null;
    }
}
