package com.example.demo.Service;

import org.springframework.stereotype.Service;

import java.util.List;


public interface ModelService {

    boolean addAMember(Member member);

    boolean memberLogin(Member member);

    boolean beforeRegister(Member member);

    void deleteAMember();

    boolean isLoggedIn();

    List<Member> findmemberById();
}
