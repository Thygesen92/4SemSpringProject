package com.example.demo.Repo;

import com.example.demo.Service.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;

@Repository
public class RepoImp implements Repo {

    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void insert(Member member) {

        log.info("Insert guide method entered");

        String sql = "INSERT INTO members " + "(firstname, lastname, username, password, age) VALUES (?, ?,?,?,?)";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        log.info("Ready to enter update method");
        jdbcTemplate.update(sql, new Object[] {

                member.getFirstname(),
                member.getLastname(),
                member.getUsername(),
                member.getPassword(),
                member.getAge()
        });
    }
}
