package com.mettre.account.base;
import lombok.Data;

import java.util.List;

@Data
public class ResultList<T> {

    private List<T> list;
}
