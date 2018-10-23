package flash.thunder.school.test.spilder.Entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Administrator on 2018/10/23.
 */
@ApiModel
@Entity
@Table(name="t_ssyy_school")
public class School implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "school_id")
    private Integer schoolId;
    @ApiModelProperty(value = "211flag")
    @Column(name = "211_flag")
    private Integer flag211;
    @ApiModelProperty(value = "官网")
    @Column(name = "official_network")
    private String officialNetwork;
    @ApiModelProperty(value = "所属")
    @Column(name = "membership")
    private String membership;
    @ApiModelProperty(value = "简介")
    @Column(name = "brief")
    private String brief;
    @ApiModelProperty(value = "省份")
    @Column(name = "province")
    private String province;
    @ApiModelProperty(value = "费用")
    @Column(name = "charge")
    private String charge;
    @ApiModelProperty(value = "排行")
    @Column(name = "ranking")
    private Integer ranking;
    @ApiModelProperty(value = "性质")
    @Column(name = "schoolnature")
    private String schoolNature;
    @ApiModelProperty(value = "曾用名")
    @Column(name = "old_name")
    private String oldName;
    @ApiModelProperty(value = "学位")
    @Column(name = "level")
    private String level;
    @ApiModelProperty(value = "autonomyrs")
    @Column(name = "autonomyrs")
    private Integer autonomyrs;
    @ApiModelProperty(value = "描述")
    @Column(name = "firsyrate")
    private String firsyrate;
    @ApiModelProperty(value = "学校名")
    @Column(name = "school_name")
    private String schoolName;
    @ApiModelProperty(value = "类别")
    @Column(name = "school_property")
    private String schoolProperty;
    @ApiModelProperty(value = "学校type")
    @Column(name = "school_type")
    private String schoolType;
    @ApiModelProperty(value = "985flag")
    @Column(name = "985_flag")
    private Integer flag985;

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public Integer getFlag211() {
        return flag211;
    }

    public void setFlag211(Integer flag211) {
        this.flag211 = flag211;
    }

    public String getOfficialNetwork() {
        return officialNetwork;
    }

    public void setOfficialNetwork(String officialNetwork) {
        this.officialNetwork = officialNetwork;
    }

    public String getMembership() {
        return membership;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public String getSchoolNature() {
        return schoolNature;
    }

    public void setSchoolNature(String schoolNature) {
        this.schoolNature = schoolNature;
    }

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getAutonomyrs() {
        return autonomyrs;
    }

    public void setAutonomyrs(Integer autonomyrs) {
        this.autonomyrs = autonomyrs;
    }

    public String getFirsyrate() {
        return firsyrate;
    }

    public void setFirsyrate(String firsyrate) {
        this.firsyrate = firsyrate;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolProperty() {
        return schoolProperty;
    }

    public void setSchoolProperty(String schoolProperty) {
        this.schoolProperty = schoolProperty;
    }

    public String getSchoolType() {
        return schoolType;
    }

    public void setSchoolType(String schoolType) {
        this.schoolType = schoolType;
    }

    public Integer getFlag985() {
        return flag985;
    }

    public void setFlag985(Integer flag985) {
        this.flag985 = flag985;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }
}
