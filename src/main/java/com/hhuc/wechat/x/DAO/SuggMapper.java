package com.hhuc.wechat.x.DAO;

import com.hhuc.wechat.x.Models.Suggestion;

import java.util.List;

public interface SuggMapper {

    public void commit(Suggestion suggestion);

    public List<Suggestion> queryAll();

    public List<Suggestion> queryCm(String towho);
}
