package com.mettre.account.base;

import com.mettre.account.pojo.Friends;
import lombok.Data;

import java.util.List;

@Data
public class ResultList {

    private List<Friends> list;
}
