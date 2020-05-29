package httpclient.httpasyncclient;

import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.conn.PoolingNHttpClientConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: shenpeng
 * @Date: 2020-05-26
 */
@Component
public class AsynHttpClientFactory {

    private static Logger logger = LoggerFactory.getLogger(AsynHttpClientFactory.class);


    private static CloseableHttpAsyncClient httpclient;
    private static PoolingNHttpClientConnectionManager connManager;
    public AsynHttpClientFactory() {
        connManager = HttpUtil.getConnManager();
        httpclient = HttpUtil.getClient(connManager);
        httpclient.start();
        logger.info("异步httpClient启动完成");
    }

    public static CloseableHttpAsyncClient getCloseableHttpAsyncClient(){
        return httpclient;
    }
}
