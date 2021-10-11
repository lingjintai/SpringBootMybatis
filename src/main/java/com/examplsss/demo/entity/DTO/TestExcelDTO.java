package com.examplsss.demo.entity.DTO;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @description:
 * @author: ljt
 * @time: 2021/9/28 0028 11:36
 */
@Data
public class TestExcelDTO {

      @ExcelProperty(value = "id",index = 0)
      private String id;

      @ExcelProperty(value = "name",index = 1)
      private String name;

}
