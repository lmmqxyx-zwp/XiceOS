package top.by.xiceos.cache;

import java.util.List;

/**
 * <p>Title: XiceOSCache</p>
 * <p>Description: 缓存统一接口</p>
 *
 * @author zwp
 * @date 2018/10/10 16:08
 */
public interface XiceOSCache {

    /**
     * 设置缓存中的值
     *
     * @param cacheName 缓存名称
     * @param key       键
     * @param val       值
     */
    void set(String cacheName, Object key, Object val);

    /**
     * 获取缓存中的值
     *
     * @param cacheName 缓存名称
     * @param key       键
     * @param <T>       返回值类型
     * @return
     */
    <T> T get(String cacheName, Object key);

    /**
     * 获取缓存中的所有键
     *
     * @param cacheName 缓存名称
     * @return
     */
    List<String> getAllKeys(String cacheName);

    /**
     * 更新缓存数据
     *
     * @param cacheName 缓存名称
     * @param key       键
     * @param val       值
     */
    void update(String cacheName, Object key, Object val);

    /**
     * 根据键删除缓存的数据
     *
     * @param cacheName 缓存名称
     * @param key       键
     */
    void remove(String cacheName, Object key);

    /**
     * 根据缓存名称删除该缓存下面的所有数据
     *
     * @param cacheName 缓存名称
     */
    void removeAll(String cacheName);

    /**
     * 重新加载缓存获取数据
     *
     * @param cacheName   缓存名称
     * @param key         键
     * @param reloadCache 重载对象
     * @param <T>         返回值类型
     * @return
     */
    <T> T reloadGet(String cacheName, Object key, ReloadCache reloadCache);

    /**
     * 重新加载缓存获取数据
     *
     * @param cacheName   缓存名称
     * @param key         键
     * @param reloadCache 重载对象
     * @param <T>         返回值类型
     * @return
     */
    <T> T reloadGet(String cacheName, Object key, Class<? extends ReloadCache> reloadCache);

    /**
     * 关闭缓存
     */
    void shutDownCache();
}
