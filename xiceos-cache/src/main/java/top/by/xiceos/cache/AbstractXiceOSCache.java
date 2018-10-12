package top.by.xiceos.cache;

import top.by.xiceos.util.XiceOSUtil;

/**
 * <p>Title: AbstractXiceOSCache</p>
 * <p>Description: 缓存抽象父类</p>
 *
 * @author zwp
 * @date 2018/10/10 15:57
 */
public abstract class AbstractXiceOSCache implements XiceOSCache {

    @Override
    public <T> T reloadGet(String cacheName, Object key, ReloadCache reloadCache) {
        Object data = get(cacheName, key);

        if (XiceOSUtil.isNull(data)) {
            data = reloadCache.reload();
            set(cacheName, key, data);
        }

        return (T) data;
    }

    @Override
    public <T> T reloadGet(String cacheName, Object key, Class<? extends ReloadCache> reloadCacheClass) {
        Object data = get(cacheName, key);

        if (XiceOSUtil.isNull(data)) {
            try {
                ReloadCache reloadCache = reloadCacheClass.newInstance();
                data = reloadCache.reload();
                set(cacheName, key, data);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return (T) data;
    }
}
