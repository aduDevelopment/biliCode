package com.waterdrop.baselibrary.utils;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;

import com.getkeepsafe.relinker.ReLinker;
import com.tencent.mmkv.MMKV;

import java.util.Map;
import java.util.Set;

/**
 * 作者：Created by chen1 on 2020/3/30.
 * TODO：
 */

/**
 * @Description:主要功能:Mkv数据存储工具类
 * @version: 1.0.0
 */

public class MmkvTools {
    private MMKV mmkv = null;

    private MmkvTools(){

    }

    private static class Singleton{
        private static final MmkvTools mmkv = new MmkvTools();
    }

    /**
     * TODO：获取操作对象
     * @return
     */
    public static MmkvTools getInstance() {
        return Singleton.mmkv;
    }

    /**
     * TODO：初始化MMKV
     * @param app
     * @return
     */
    public String initMmkv(final Application app) {
        // if判断用于解决以下问题：一些 Android 设备（API level 19）在安装/更新 APK 时可能出错,导致 libmmkv.so 找不到。
        // 然后就会遇到 java.lang.UnsatisfiedLinkError 之类的 crash。 开源库 ReLinker 专门解决这个问题
        String rootDir = "";
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT){
            String dir = filePath(app);
            rootDir = MMKV.initialize(dir, new MMKV.LibLoader() {
                @Override
                public void loadLibrary(String libName) {
                    ReLinker.loadLibrary(app, libName);
                }
            });
            getMmkv();
            return rootDir;
        }
        rootDir = MMKV.initialize(app);
        getMmkv();
        return rootDir;
    }

    /**
     *
     * @param app
     * @return
     */
    private String filePath(Application app){
        return app.getFilesDir().getAbsolutePath() + "/" + app.getPackageName();
    }

    /**
     * TODO：可以自己定制数据存储的位置
     * @param filePath
     */
    public String initMMKVMyself(Application app, String filePath){
        if (TextUtils.isEmpty(filePath)){
            filePath = filePath(app);
        }
        return MMKV.initialize(filePath);
    }

    /**
     * TODO：根据业务区别存储, 附带一个自己的 ID
     * @param id
     * @return
     */
    public MmkvTools setStorageWithID(String id) {
        mmkv = MMKV.mmkvWithID(id);
        return this;
    }

    /**
     * TODO：获取MMKV的操作对象
     * @return
     */
    private MmkvTools getMmkv() {
        if (null == mmkv) {
            synchronized (MMKV.class){
                mmkv = MMKV.defaultMMKV();
            }
        }
        return this;
    }

    /**
     * TODO：保存boolean
     * @param key
     * @param value
     * @return
     */
    public boolean setBoolean(String key, boolean value){
        getMmkv();
        return mmkv.encode(key, value);
    }

    public boolean setInteger(String key, int value){
        getMmkv();
        return mmkv.encode(key, value);
    }

    public boolean setLong(String key, Long value){
        getMmkv();
        return mmkv.encode(key, value);
    }

    public boolean setFloat(String key, Float value){
        getMmkv();
        return mmkv.encode(key, value);
    }

    public boolean setDouble(String key, Double value){
        getMmkv();
        return mmkv.encode(key, value);
    }

    public boolean setString(String key, String value){
        getMmkv();
        return mmkv.encode(key, value);
    }

    public boolean setSet(String key, Set value){
        getMmkv();
        return mmkv.encode(key, value);
    }

    public boolean setParcelable(String key, Parcelable value){
        getMmkv();
        return mmkv.encode(key, value);
    }

    public boolean setShort(String key, short value){
        getMmkv();
        return mmkv.encode(key, value);
    }

    public String getString(String key, String defaultValue){
        getMmkv();
        return mmkv.decodeString(key, defaultValue);
    }

    public int getInteger(String key, Integer defaultValue){
        getMmkv();
        return mmkv.decodeInt(key, defaultValue);
    }

    public Long getLong(String key, Long defaultValue){
        getMmkv();
        return mmkv.decodeLong(key, defaultValue);
    }

    public Double getDouble(String key, Double defaultValue){
        getMmkv();
        return mmkv.decodeDouble(key, defaultValue);
    }

    public Float getFloat(String key, Float defaultValue){
        getMmkv();
        return mmkv.decodeFloat(key, defaultValue);
    }

    public boolean getBoolean(String key){
        getMmkv();
        return mmkv.decodeBool(key, false);
    }

    public byte[] getByte(String key){
        getMmkv();
        return mmkv.decodeBytes(key);
    }

    public Set getSet(String key){
        getMmkv();
        return mmkv.decodeStringSet(key);
    }

    public <T extends Parcelable> Parcelable getParcelable(String key, Class<T> classes){
        getMmkv();
        return mmkv.decodeParcelable(key, classes);
    }

    public String[] getAllKey(){
        getMmkv();
        return mmkv.allKeys();
    }

    public long getTotalSize(){
        getMmkv();
        return mmkv.totalSize();
    }

    public void clearMmkv(){
        getMmkv();
        mmkv.clear();
    }

    public void clearAllMmkv(){
        getMmkv();
        mmkv.clearAll();
    }

    public void clearMemoryCache(){
        getMmkv();
        mmkv.clearMemoryCache();
    }

    public Map<String, Object> getAll(){
        getMmkv();
        return (Map<String, Object>) mmkv.getAll();
    }

    public boolean isContains(String key){
        getMmkv();
        return mmkv.contains(key);
    }

    /**
     * TODO：查询是否包含 key 的存储数据
     * @param key
     * @return
     */
    public boolean querryWithKey(String key){
        getMmkv();
        return mmkv.containsKey(key);
    }

    /**
     * TODO：以key删除数据
     * @param key
     */
    public void deleteDataWithKey(String key){
        getMmkv();
        if (mmkv.containsKey(key)){
            mmkv.removeValueForKey(key);
        }
    }

    /**
     * TODO：以String型数组的item作为key删除数据
     * @param sArray
     */
    public void deleteDataWithArray(String[] sArray){
        getMmkv();
        mmkv.removeValuesForKeys(sArray);
    }

    /**
     * TODO：把SharedPreferences的数据迁移到MMKV
     * @param context
     * @param tableName：SharedPreferences初始化的时候，用到的表名
     */
    public void migrationDataFromSharedPreferences(Context context, String tableName){
        setStorageWithID(tableName);
        SharedPreferences sharedPreferences = context.getSharedPreferences(tableName, Context.MODE_PRIVATE);
        mmkv.importFromSharedPreferences(sharedPreferences);
        sharedPreferences.edit().clear().commit();
    }
}