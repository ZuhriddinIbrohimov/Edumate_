package zuhriddinscode.courses.courseEntity;

import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class TypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "type_id")
    private Integer typeId;

    @Column(name = "price")
    private Float price;

    @Column(name = "period")
    private Integer period;

    @Column(name = "description")
    private String description;


//    @Column(name = "profile")
//    private Integer profileId;

//    @Column(name= "start_time")
//    private Date starttime;

//    @Column(name= "end_time")
//    private Date endtime;

//    @Column(name = "teacher_id")
//    private Integer teacherId;

//    @Column(name ="detail_id")
//    private Integer detailId;

//    @Column(name = "img")
//    private String img;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

//    public Date getStarttime() {
//        return starttime;
//    }
//
//    public void setStarttime(Date starttime) {
//        this.starttime = starttime;
//    }
//
//    public Date getEndtime() {
//        return endtime;
//    }
//
//    public void setEndtime(Date endtime) {
//        this.endtime = endtime;
//    }

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

    //    public Integer getTeacherId() {
//        return teacherId;
//    }
//
//    public void setTeacherId(Integer teacherId) {
//        this.teacherId = teacherId;
//    }
//
//    public Integer getDetailId() {
//        return detailId;
//    }
//
//    public void setDetailId(Integer detailId) {
//        this.detailId = detailId;
//    }
//
//    public String getImg() {
//        return img;
//    }
//
//    public void setImg(String img) {
//        this.img = img;
//    }
//    public Integer getProfileId() {
//        return profileId;
//    }
//
//    public void setProfileId(Integer profileId) {
//        this.profileId = profileId;
//    }
}