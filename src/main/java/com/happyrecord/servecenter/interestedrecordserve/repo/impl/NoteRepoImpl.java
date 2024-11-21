package com.happyrecord.servecenter.interestedrecordserve.repo.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.happyrecord.servecenter.interestedrecordserve.mapper.NoteMapper;
import com.happyrecord.servecenter.interestedrecordserve.pojo.enity.Note;
import com.happyrecord.servecenter.interestedrecordserve.repo.NoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NoteRepoImpl implements NoteRepo {
  @Autowired
  NoteMapper noteMapper;

  public void add(Note note) {
    noteMapper.insert(note);
  }


  public List<Note> listNote() {
    return noteMapper.selectList(null);
  }


  public List<Note> page(Integer page, int size) {
    // 创建 Page 对象，注意页码是从 1 开始的
    Page<Note> notePage = new Page<>(page, size);
    // 使用 noteMapper 的 selectPage 方法进行分页查询
    noteMapper.selectPage(notePage, null);
    // 返回分页查询的结果
    System.out.println(notePage.getTotal());
    return notePage.getRecords();
  }
}
