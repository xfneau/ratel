package es;


public class SearchBean {
 
    public SearchBean(String indexName, String type, String id) {
        super();
        this.indexName = indexName;
        this.type = type;
        this.id = id;
    }
    private String indexName;//索引名称
    private String type;//索引类型
    private String id;//索引ID
 
    private String name;
    private String password;
     
    public String getIndexName() {
        return indexName;
    }
    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
     
}