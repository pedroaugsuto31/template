package com.pedroaugusto.escola.core.swagger.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PageableResponseSwagger {

    private int page;
    private int size;
    private List<String> sort;
}