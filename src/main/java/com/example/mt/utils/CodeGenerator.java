package com.example.mt.utils;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.sql.Types;
import java.util.Collections;

public class CodeGenerator {

    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/tycrm_uat?useSSL=false&serverTimezone=UTC", "root", "root")
                .globalConfig(builder -> {
                    builder.author("hl") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .outputDir("/Users/dabaoshi/IdeaProjects/MyTest/src/main/java"); // 指定输出目录
                })
                .dataSourceConfig(builder -> builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                    int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                    if (typeCode == Types.SMALLINT) {
                        // 自定义类型转换
                        return DbColumnType.INTEGER;
                    }
                    return typeRegistry.getColumnType(metaInfo);

                }))
                .packageConfig(builder -> {
                    builder.parent("com.example.mt") // 设置父包名
                            .moduleName("tenant") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "/Users/dabaoshi/IdeaProjects/MyTest/src/main/resources/mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.entityBuilder().enableLombok(); // add -> @@Getter and @Setter
                    builder.controllerBuilder().enableRestStyle(); // @Controller -> @RestController
//                    builder.entityBuilder().fileOverride(); //覆盖已生成实体
//                    builder.mapperBuilder().enableFileOverride(); //覆盖已生成mapper.xml
                    builder.addInclude("crm_tenant,crm_tenant_function") // 设置需要生成的表名
                            .addTablePrefix("crm_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
