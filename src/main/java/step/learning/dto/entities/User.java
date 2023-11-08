package step.learning.dto.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class User {

    private String id;
    private String login;


    private String name;
    private String salt;
    private String passDK;
    private String email;
    private String emailCode;
    private Date birthdate;
    private String avatarUrl;
    private Date deleteAt;
    private Date registerAt;


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    public String getEmailCode() {
        return emailCode;
    }

    public void setEmailCode(String emailCode) {
        this.emailCode = emailCode;
    }
    public Date getDeleteAt() {
        return deleteAt;
    }

    public void setDeleteAt(Date deleteAt) {
        this.deleteAt = deleteAt;
    }

    public Date getRegisterAt() {
        return registerAt;
    }

    public void setRegisterAt(Date registerAt) {
        this.registerAt = registerAt;
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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassDK() {
        return passDK;
    }

    public void setPassDK(String passDK) {
        this.passDK = passDK;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public User(ResultSet resultSet) throws SQLException {
        this.setId( resultSet.getString("id"));
        this.setLogin( resultSet.getString("login"));
        this.setName( resultSet.getString("name"));
        this.setEmail( resultSet.getString("email"));
        this.setSalt( resultSet.getString("salt"));
        this.setPassDK( resultSet.getString("pass_dk"));
        this.setBirthdate( resultSet.getDate("birthdate"));
        this.setAvatarUrl( resultSet.getString("avatar_url"));
        this.setEmailCode( resultSet.getString("email_code"));

        Timestamp moment = resultSet.getTimestamp("reg_at");
        this.setRegisterAt( moment == null ? null : new Date( moment.getTime() ));
        moment = resultSet.getTimestamp("del_at");
        this.setDeleteAt( moment == null ? null : new Date( moment.getTime() ));
    }
}
