package com.example.demo.Service;

import org.springframework.stereotype.Service;


public interface ModelService {

    boolean addAMember(Member member);

    boolean memberLogin(Member member);

    boolean beforeRegister(Member member);

    void deleteAMember();
}
