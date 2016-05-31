package test.zwj.Bean;

/**
 * Created by Administrator on 2016/1/3 0003.
 */
public class Info {
    private String telphone;
    private String birthday;

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "telphone:"+telphone+",birthday:"+birthday;
//        return super.toString();
    }
}
