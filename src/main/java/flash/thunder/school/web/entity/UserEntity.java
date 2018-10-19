package flash.thunder.school.web.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2018/10/19.
 */
@ApiModel
@Entity
@Table(name="t_ssyy_user")
public class UserEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long userId;
    @ApiModelProperty(value = "用户姓名")
    @Column(name = "user_name")
    private String name;
    @ApiModelProperty(value = "密码")
    @Column(name = "password")
    private String password;
    @ApiModelProperty(value = "邮件")
    @Column(name = "email")
    private String email;
    @ApiModelProperty(value = "手机号")
    @Column(name = "phone")
    private Integer phone;
    @ApiModelProperty(value = "学校id")
    @Column(name = "school_id")
    private Integer schoolId;
    @ApiModelProperty(value = "院系id")
    @Column(name = "department_id")
    private Integer departmentId;
    @ApiModelProperty(value = "专业id")
    @Column(name = "major_id")
    private Integer majorId;
    @ApiModelProperty(value = "工作地区")
    @Column(name = "local")
    private String local;
    @ApiModelProperty(value = "创建时间")
    @Column(name = "create_time")
    private Date createTime;
    @ApiModelProperty(value = "更新时间")
    @Column(name = "update_time")
    private Date updateTime;
    @ApiModelProperty(value = "更新用户id")
    @Column(name = "update_user_id")
    private Long updateUserId;
    @ApiModelProperty(value = "逻辑删除")
    @Column(name = "id_delete")
    private Short isDelete;
    @ApiModelProperty(value = "性别")
    @Column(name = "gender")
    private Short gender;
    @ApiModelProperty(value = "毕业日期")
    @Column(name = "graduate_date")
    private String graduateDate;
    @ApiModelProperty(value = "公司名称")
    @Column(name = "company_name")
    private String companyName;
    @ApiModelProperty(value = "qq")
    @Column(name = "qq")
    private Long qq;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Short getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Short isDelete) {
        this.isDelete = isDelete;
    }

    public Short getGender() {
        return gender;
    }

    public void setGender(Short gender) {
        this.gender = gender;
    }

    public String getGraduateDate() {
        return graduateDate;
    }

    public void setGraduateDate(String graduateDate) {
        this.graduateDate = graduateDate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Long getQq() {
        return qq;
    }

    public void setQq(Long qq) {
        this.qq = qq;
    }
}
