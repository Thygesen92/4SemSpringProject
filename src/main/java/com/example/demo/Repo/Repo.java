package com.example.demo.Repo;

import com.example.demo.Service.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface Repo {

    public void insert(Member member);
    public List<String> login(String uname, String pword);
    public boolean checkBeforeAddingMember(Member member);
    public List<Integer> findMemberById(Member member);

    List<String> findByUsername(String uname);
}
