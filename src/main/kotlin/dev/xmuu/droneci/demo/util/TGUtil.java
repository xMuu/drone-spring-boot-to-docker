package dev.xmuu.droneci.demo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Component
public class TGUtil {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${config.telegram.token}")
    public String token;

    @Value("${config.telegram.chat-id}")
    public String chatId;

    private String getBaseUrl() {
        return "https://api.telegram.org/bot" + token + "/";
    }

    private String getSendMessageUrl() {
        return getBaseUrl() + "sendMessage?chat_id=" + chatId + "&text={1}";
    }

    private RestTemplate getDefaultTemplate() {
        RestTemplate template = new RestTemplate();
        template.setErrorHandler(new ResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse response) throws IOException {
                return response.getStatusCode().isError();
            }

            @Override
            public void handleError(ClientHttpResponse response) throws IOException {
                logger.info("Error: " + response.getStatusCode());
            }
        });
        return template;
    }

    public void sendMessage(String message) {
        RestTemplate template = getDefaultTemplate();
        String result = template.getForObject(getSendMessageUrl(), String.class, message);
        logger.info("TG sendMessage result: {}", result);
    }

}
