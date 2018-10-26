package flash.thunder.school.web.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

/**
 * Created by Administrator on 2018/9/28.
 */
@ApiModel
@Entity
@Table(name="t_ssyy_department")
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "department_id")
    private int departmentId;
    @ApiModelProperty(value = "院系名字")
    @Column(name = "department_name")
    private String departmentName;
    @ApiModelProperty(value = "院系简称")
    @Column(name = "spell_name")
    private String spellName;

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getSpellName() {
        return spellName;
    }

    public void setSpellName(String spellName) {
        this.spellName = spellName;
    }
}
