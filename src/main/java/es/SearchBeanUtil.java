package es;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
 
 
public class SearchBeanUtil {
     
    /**
     * 根据filedName获取get方法
     * 
     * @param fildeName
     * @return
     * @throws Exception
     */
    private static String getMethodName(String fildeName) throws Exception {
        byte[] items = fildeName.getBytes();
        if (((char) items[0]) >= 'a' && ((char) items[0]) <= 'z') {
            items[0] = (byte) ((char) items[0] - 32);
        }
        return new String(items);
    }
     
    public static Map<String, Object> toUpdateMap(SearchBean bean) {
        Class<?> type = bean.getClass();
        Map<String, Object> returnMap = new HashMap<String, Object>();
        try {
            Field[] fields = type.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                Field filed = fields[i];
                String filedName = filed.getName();
                if (!filedName.equals("serialVersionUID")) {
                    Method m = type.getMethod("get" + getMethodName(filedName));
                    Object val = m.invoke(bean);
                    if (val != null) {
                        returnMap.put(filedName, val);
                    }
                }
            }
        } catch (Exception e) {
        }
        return returnMap;
    }
 
    public static Map<String,Object> toInsertMap(SearchBean bean){
        Map<String, Object> returnMap = new HashMap<String, Object>();
        try {
            Class<?> type = bean.getClass();
            BeanInfo beanInfo = Introspector.getBeanInfo(type);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (int i = 0; i < propertyDescriptors.length; i++) {
                PropertyDescriptor descriptor = propertyDescriptors[i];
                String propertyName = descriptor.getName();
                if (!propertyName.equals("class")) {
                    Method readMethod = descriptor.getReadMethod();
                    Object result = readMethod.invoke(bean);
                    returnMap.put(propertyName, result);
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return returnMap;
    }
     
    public static List buildSearchSource(SearchHits result){
        List<Map<String, Object>> lists= new ArrayList();
        for(SearchHit hit:result.getHits()){
            lists.add(hit.getSource());
        }
        return lists;
    }
     
    public static List buildSearchFields(SearchHits result){
        List<Map<String, Object>> lists= new ArrayList();
        for(SearchHit hit:result.getHits()){
            Map<String, Object> map=new HashMap();
            for(String key:hit.getFields().keySet()){
                map.put(key, hit.getFields().get(key));
            }
            lists.add(map);
        }
        return lists;
    }
     
    public static void main(String[] args){
        SearchBean bean =new SearchBean("index", "user", "sss");
        Map<String, Object> returnMap = toUpdateMap(bean);
        System.out.println(returnMap);
    }
}