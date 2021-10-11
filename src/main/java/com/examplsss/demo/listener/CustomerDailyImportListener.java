package com.examplsss.demo.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.examplsss.demo.entity.DTO.TestExcelDTO;
import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: ljt
 * @time: 2021/9/28 0028 11:42
 */
@Slf4j
public class CustomerDailyImportListener extends AnalysisEventListener<TestExcelDTO> {
    @Override
    public void invoke(TestExcelDTO testExcelDTO, AnalysisContext analysisContext) {
        log.info("当前获取到一条数据！{}",testExcelDTO);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
