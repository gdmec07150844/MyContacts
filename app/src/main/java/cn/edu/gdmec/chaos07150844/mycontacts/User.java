package cn.edu.gdmec.chaos07150844.mycontacts;

/**
 * Created by Chaos丶 on 2016/10/18.
 */
public class User {
    public final static String NAME = "name";
    public final static String PHONE = "phone";
    public final static String DANWEI = "danwei";
    public final static String QQ = "qq";
    public final static String ADDRESS = "address";
    private String name;
    private String phone;
    private String danwei;
    private String qq;
    private String address;
    private int id_DB = -1;

    public User(){
        super();
    }
    public User(String name,String phone,String danwei,String qq,String address){
        super();
        this.name = name;
        this.phone = phone;
        this.danwei = danwei;
        this.qq = qq;
        this.address = address;
    }
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getDanwei(){
        return danwei;
    }

    public void setDanwei(String danwei){
        this.danwei = danwei;
    }

    public String getQq(){
        return qq;
    }

    public void setQq(String qq){
        this.qq = qq;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }
}
