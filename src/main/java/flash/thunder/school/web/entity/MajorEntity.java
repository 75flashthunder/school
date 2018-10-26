package flash.thunder.school.web.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

/**
 * Created by Administrator on 2018/9/28.
 */
@ApiModel
@Entity
@Table(name="t_ssyy_major")
public class MajorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "major_id")
    private int majorId;
    @ApiModelProperty(value = "专业名字")
    @Column(name = "major_name")
    private String majorName;
    @ApiModelProperty(value = "院系id")
    @Column(name = "department_id")
    private String departmentId;

    public int getMajorId() {
        return majorId;
    }

    public void setMajorId(int majorId) {
        this.majorId = majorId;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }
}
