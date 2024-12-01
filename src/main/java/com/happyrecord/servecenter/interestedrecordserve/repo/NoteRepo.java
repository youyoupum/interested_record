package com.happyrecord.servecenter.interestedrecordserve.repo;

import com.happyrecord.servecenter.interestedrecordserve.pojo.enity.Note;

import java.util.List;

public interface NoteRepo {
  void add(Note note);

  List<Note> listNote();

  List<Note> page(Integer page, int size);

  Note getNote(Integer id);

  List<Note> userListNode();

  List<Note> searchNote(String search);
}
