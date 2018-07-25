package elasticsearch;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * @author zhangjingsi
 * @date 2018/6/8下午3:47
 */
public class ConnectEs {
    public static void main(String[] args) throws UnknownHostException {
        // on startup

        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new TransportAddress(InetAddress.getByName("zjs"), 9300))
                .addTransportAddress(new TransportAddress(InetAddress.getByName("zjs"), 9300));
        SearchResponse searchResponse = client.prepareSearch().get();
        SearchHit[] hits = searchResponse.getHits().getHits();
        Arrays.asList(hits).stream().forEach(hit->{
            System.out.println(hit.getSourceAsMap().get("about"));
        });
// on shutdown
        System.out.println("");
        client.close();

    }
}
