package com.alibaba.coin.demo.duotai;

import com.alibaba.fastjson.JSON;

/**
 * @author guopeng.Zgp 2022.08.31
 */
public class DuoTaiTest {
    public static void main(String[] args) {

        NewProductQaRecord newProductQaRecord = new NewProductQaRecord(6592L,"niohbfa");
        newProductQaRecord.setSkillId("7498");
        newProductQaRecord.setQuestions("nihcma");
        newProductQaRecord.setAnswers("wohcde");

        OpensearchRecord record = (OpensearchRecord)newProductQaRecord;
        String id = record.getId();
        System.out.println("id = " + id);
        System.out.println(JSON.toJSONString(record));

    }

}
