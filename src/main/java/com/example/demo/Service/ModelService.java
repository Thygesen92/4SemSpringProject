package com.example.demo.Service;

import org.springframework.stereotype.Service;


public interface ModelService {

    void addAMember(Member member);

    boolean memberLogin(Member member);

    void deleteAMember();
}
