package com.coffee.demo.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
//@TableName("tb_user") //匹配数据库表名
public class User {

    //配置主键
    // value 当数据库字段与实体类属性名不一致时使用
    // type 设置主键的策略,默认使用雪花算法,可以选择自动自增
    @TableId(value = "id",type = IdType.AUTO )
    private Long uid;

    private String name;

    private int age;

    private String email;

    @TableLogic //注释 逻辑删除字段
    @TableField("isDeleted") //配置字段
    private Long isDeleted;
}
