package com.example.demo.Service;


import com.example.demo.Repo.Repo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ModelImp implements ModelService {

    @Autowired
    Repo repoImp;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean addAMember(Member member) {

        if (beforeRegister(member) == false)
        {
            repoImp.insert(member);
            System.out.println(member.toString());
            return false;
        }
        return true;
    }

    @Override
    public boolean memberLogin(Member member) {

        String u = member.getUsername();
        String p = member.getPassword();
        List<String> userCredential = repoImp.login(u,p);
        System.out.println(userCredential.toString());

        String userCredentialUsername = userCredential.get(0);
        String userCredentialPassword = userCredential.get(1);

        if (u.equals(userCredentialUsername))
        {
            if (p.equals(userCredentialPassword))
            {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean beforeRegister(Member member) {

        if (repoImp.checkBeforeAddingMember(member) == false)
        {
            log.info("Member didn't allready exist");
            return false;
        }
        log.info("Member allready exist!");
        return true;
    }

    @Override
    public void deleteAMember() {

    }
}
