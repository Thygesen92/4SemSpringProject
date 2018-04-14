package com.example.demo.Service;


import com.example.demo.Repo.Repo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelImp implements ModelService {

    @Autowired
    Repo repoImp;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void addAMember(Member member) {

        repoImp.insert(member);
        System.out.println(member.toString());

    }

    @Override
    public void deleteAMember() {

    }
}
