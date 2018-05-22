package com.example.demo.Service;


import com.example.demo.Repo.Repo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ModelImp implements ModelService {

    @Autowired
    Repo repoImp;

    private boolean loggedIn;

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
                loggedIn = true;
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

    @Override
    public boolean isLoggedIn() {

        if (loggedIn == true)
        {
            return true;
        }
        return false;
    }

    @Override
    public List<Member> findmemberById() {
        return null;
    }

    public Member findByUsername(Member member) {
        String uname = member.getUsername();
        List<String> memberInfo;
        memberInfo = repoImp.findByUsername(uname);
        int id = 0;
        String firstname = null;
        String lastname = null;
        String username = null;
        String country = null;
        String address = null;



        for (int i = 0; i < memberInfo.size() ; i++) {
            switch (i){
                case 0: id = Integer.parseInt(memberInfo.get(i));
                    break;
                case 1: firstname = memberInfo.get(i);
                    break;
                case 2: lastname = memberInfo.get(i);
                    break;
                case 3: username = memberInfo.get(i);
                    break;
                case 4: country = memberInfo.get(i);
                    break;
                case 5: address = memberInfo.get(i);
            }
        }

        Member mem1 = new Member(id,firstname,lastname,username,country, address);
        return mem1 ;
    }
}
