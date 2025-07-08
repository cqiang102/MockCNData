package cn.lacia.mockcndata.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author caoq
 * @since 2025-07-08 10:37
 * 中文资源加载器
 */
public class ResourceLoader {

    /**
     * 从类路径加载文本文件为字符串列表
     *
     * @param path 资源路径
     * @return 字符串列表
     */
    public static List<String> loadLines(String path) {
        List<String> lines = new ArrayList<>();
        try (InputStream is = ResourceLoader.class.getClassLoader().getResourceAsStream(path);
             BufferedReader reader = new BufferedReader(new InputStreamReader(
                     Objects.requireNonNull(is), StandardCharsets.UTF_8))) {

            String line;
            while ((line = reader.readLine()) != null) {
                // 跳过空行和注释
                if (!line.trim().isEmpty() && !line.trim().startsWith("#")) {
                    lines.add(line.trim());
                }
            }
        } catch (IOException | NullPointerException e) {
            throw new RuntimeException("无法加载资源文件: " + path, e);
        }
        return lines;
    }

    /**
     * 从类路径加载文本文件为字符串数组
     *
     * @param path 资源路径
     * @return 字符串数组
     */
    public static String[] loadArray(String path) {
        List<String> lines = loadLines(path);
        return lines.toArray(new String[0]);
    }
}
