package com.happyrecord.servecenter.interestedrecordserve.repo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.happyrecord.servecenter.interestedrecordserve.mapper.NoteMapper;
import com.happyrecord.servecenter.interestedrecordserve.pojo.enity.Note;
import com.happyrecord.servecenter.interestedrecordserve.repo.NoteRepo;
import com.happyrecord.servecenter.interestedrecordserve.utils.BaseContext;
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
    Page<Note> notePage = new Page<>(page, size );

    // 使用 noteMapper 的 selectPage 方法进行分页查询
    noteMapper.selectPage(notePage, null);
    // 返回分页查询的结果1
//    for (Note note : notePage.getRecords()) {
//      System.out.println("Tags: " + note.getTags());
//    }
    // 创建 QueryWrapper 并设置排序条件
    QueryWrapper<Note> queryWrapper = new QueryWrapper<>();
    queryWrapper.orderByDesc("create_at"); // 假设 'create_time' 是你的创建时间字段

    // 使用 noteMapper 的 selectPage 方法进行分页查询，并传入排序条件
    noteMapper.selectPage(notePage, queryWrapper);
    return notePage.getRecords();
  }


  public Note getNote(Integer id) {
    return noteMapper.selectById(id);
  }

  public List<Note> userListNode() {
    QueryWrapper<Note> queryWrapper = new QueryWrapper<>();
    queryWrapper.eq("author_id", BaseContext.getCurrentId());
    queryWrapper.orderByDesc("create_at");
    return noteMapper.selectList(queryWrapper);
  }

  public List<Note> searchNote(String search) {
    QueryWrapper<Note> queryWrapper = new QueryWrapper<>();
    queryWrapper.like("title", search).or().like("content", search);
    queryWrapper.orderByDesc("create_at");
    return noteMapper.selectList(queryWrapper);
  }
}
