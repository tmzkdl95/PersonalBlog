package dan.web.wiki.vo;

public class homeVo {
    String userId;
    String userNm;

    public homeVo(String userId, String userNm) {
        this.userId = userId;
        this.userNm = userNm;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserNm() {
        return userNm;
    }

    public void setUserNm(String userNm) {
        this.userNm = userNm;
    }

    @Override
    public String toString() {
        return "homeVo{" +
                "userId='" + userId + '\'' +
                ", userNm='" + userNm + '\'' +
                '}';
    }


}
