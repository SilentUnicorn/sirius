package daily;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wurunhao
 * @date: 2018/4/20
 */
public class IndustryVO {

    private Long id;
    private String name;
    private List<IndustryVO> subIndustry;
    private Integer members;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<IndustryVO> getSubIndustry() {
        return subIndustry;
    }

    public void setSubIndustry(List<IndustryVO> subIndustry) {
        this.subIndustry = subIndustry;
    }

    public Integer getMembers() {
        return members;
    }

    public void setMembers(Integer members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "IndustryVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subIndustry=" + subIndustry +
                ", members=" + members +
                '}';
    }
}
