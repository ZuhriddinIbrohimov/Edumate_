package zuhriddinscode.courses.courseDTO;

import java.util.Date;
import java.util.Objects;

public class Course {
    private Integer id;
    private String name;
    private Integer typeId;
    private String profile;
    private Date starttime;
    private Date endtime;
    private Float price;
    private Integer period;
    private Integer teacherId;
    private Integer detailId;
    private String img;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(id, course.id) && Objects.equals(name, course.name) && Objects.equals(typeId, course.typeId) && Objects.equals(profile, course.profile) && Objects.equals(starttime, course.starttime) && Objects.equals(endtime, course.endtime) && Objects.equals(price, course.price) && Objects.equals(period, course.period) && Objects.equals(teacherId, course.teacherId) && Objects.equals(detailId, course.detailId) && Objects.equals(img, course.img);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, typeId, profile, starttime, endtime, price, period, teacherId, detailId, img);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", typeId=" + typeId +
                ", profile='" + profile + '\'' +
                ", starttime=" + starttime +
                ", endtime=" + endtime +
                ", price=" + price +
                ", period=" + period +
                ", teacherId=" + teacherId +
                ", detailId=" + detailId +
                ", img='" + img + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}