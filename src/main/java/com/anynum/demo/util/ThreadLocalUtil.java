package com.anynum.demo.util;

import java.util.HashMap;
import java.util.Map;

public final class ThreadLocalUtil {

    public static ThreadLocal<Map<String, Object>> threadLocal = ThreadLocal.withInitial(HashMap::new);

    @SuppressWarnings("unchecked")
    public static <T> T get(final String key) {
        Map<String, Object> map = threadLocal.get();
        return (T) map.get(key);
    }

    public static Map<String, Object> get() {
        return threadLocal.get();
    }

    public static Map<String, Object> removeThreadLocalMap() {
        Map<String, Object> map = threadLocal.get();
        threadLocal.remove();
        return map;
    }

    public static void set(final String key, final Object value) {
        Map<String, Object> map = threadLocal.get();
        map.put(key, value);
    }

    public static void remove() {
        threadLocal.get().clear();
    }

    @SuppressWarnings("unchecked")
    public static <T> T remove(final String key) {
        Map<String, Object> map = threadLocal.get();
        return (T) map.remove(key);
    }
}
