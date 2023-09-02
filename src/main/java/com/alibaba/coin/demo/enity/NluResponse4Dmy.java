package com.alibaba.coin.demo.enity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class NluResponse4Dmy {

    private String coinResponse;

    private String dmProcessContext;

    private String nluType;

    private String nluResponseData;

    private String sceneStatusContext;
}