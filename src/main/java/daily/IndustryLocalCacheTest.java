package daily;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class IndustryLocalCacheTest {
    static LoadingCache<String, List<IndustryVO>> cache = CacheBuilder.newBuilder()
            .refreshAfterWrite(180, TimeUnit.SECONDS) /**24小时未写则刷新缓存*/
            //.expireAfterAccess(180, TimeUnit.SECONDS) /**180s 未读则过期 此处无用*/
            .maximumSize(10) /**缓存个数，此处无用*/
            .build(new CacheLoader<String, List<IndustryVO>>() {
                @Override
                public List<IndustryVO> load(String s) {
                    List<IndustryVO> industryVOS = new ArrayList<>();
                    IndustryVO industryVO  = new IndustryVO();
                    industryVO.setId(123L);
                    industryVO.setName("互联网");
                    industryVO.setMembers(null);
                    industryVOS.add(industryVO);
                    if (!CollectionUtils.isEmpty(industryVOS)){
                        cache.put("industry", industryVOS);
                    }
                    return industryVOS;
                }
            });
     public static List<IndustryVO> getCacheValue(String key) throws ExecutionException {
         return cache.get(key);
     }

     public static void refresh(String key){
         cache.refresh(key);
     }

    public static void main(String[] args) throws ExecutionException {
        System.out.println(IndustryLocalCacheTest.getCacheValue("industry"));
    }
}