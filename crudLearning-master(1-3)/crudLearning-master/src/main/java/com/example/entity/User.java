package com.example.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ExcelIgnore
    private Long id;

    @ExcelProperty("姓名")
    private String name;

    @ExcelProperty("年龄")
    private Integer age;

    @ExcelProperty("性别")
    private String sex;

    @ExcelProperty("地址")
    private String address;

    @ExcelProperty("手机号")
    private String phone;

    @ExcelProperty("邮箱")
    private String email;

    @Column(name = "create_time")
    @ExcelProperty("创建时间")
    private String createTime;

    @Column(name = "is_collect")
    @ExcelIgnore
    private Integer isCollect;

    @ExcelIgnore
    private String image;

    @Column(name = "contact_meiti")
    @ExcelProperty("社交媒体")
    private String contactMeiti;

    @Column(name = "corporation_phone")
    @ExcelProperty("公司电话")
    private String corporationPhone;

    @ExcelIgnore
    @Transient
    private MultipartFile file;


}
