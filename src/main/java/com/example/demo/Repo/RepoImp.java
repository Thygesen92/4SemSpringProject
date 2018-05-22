package com.example.demo.Repo;

import com.example.demo.Service.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RepoImp implements Repo {

    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void insert(Member member) {

        log.info("Insert guide method entered");

        String sql = "INSERT INTO members " + "(firstname, lastname, username, password, age, role, country, zipcode,address) VALUES (?, ?,?,?,?,?,?,?,?)";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        log.info("Ready to enter update method");
        jdbcTemplate.update(sql, new Object[] {

                member.getFirstname(),
                member.getLastname(),
                member.getUsername(),
                member.getPassword(),
                member.getAge(),
                member.getRole(),
                member.getCountry(),
                member.getZipcode(),
                member.getAddress()
        });
    }

    public List<String> login(String uname, String pword){

        String sql = "SELECT * FROM members Where username = '" + uname +"' And password = '" + pword+"'";;
        List<String> memberInfo = new ArrayList<String>();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.query(sql, new ResultSetExtractor<List>() {
                    public List extractData(ResultSet rs) throws SQLException {

                        while (rs.next()) {
                            String name = rs.getString("username");
                            memberInfo.add(name);
                            String password = rs.getString("password");
                            memberInfo.add(password);
                        }
                        System.out.println(memberInfo.toString());
                        return memberInfo;
                    }
                }
        );

        return memberInfo;
    }

    @Override
    public boolean checkBeforeAddingMember(Member member) {

        String uname = member.getUsername();
        String pword = member.getPassword();

        String sql = "SELECT * FROM members Where username = '" + uname +"' And password = '" + pword+"'";;
        List<String> memberInfo = new ArrayList<String>();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.query(sql, new ResultSetExtractor<List>() {
                    public List extractData(ResultSet rs) throws SQLException {

                        while (rs.next()) {
                            String name = rs.getString("username");
                            memberInfo.add(name);
                            String password = rs.getString("password");
                            memberInfo.add(password);
                        }
                        System.out.println(memberInfo.toString());
                        return memberInfo;
                    }
                }
        );
        if (memberInfo.isEmpty())
        {
            return false;
        }
        return true;
    }

    @Override
    public List<Integer> findMemberById(Member member) {

        String uname = member.getUsername();

        String sql = "SELECT member_id FROM members Where username = " + uname;
        List<Integer> memberID = new ArrayList<Integer>();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.query(sql, new ResultSetExtractor<List>()
                {
                    public List extractData(ResultSet rs) throws SQLException
                    {
                        while (rs.next()) {
                            int id = rs.getInt("member_id");
                            memberID.add(id);
                        }
                        System.out.println(memberID.toString());
                        return memberID;
                    }
                });
        return memberID;
    }

    @Override
    public List<String> findByUsername(String uname) {
        String sql = "SELECT * FROM members Where username = '" + uname +"'";
        List<String> mem = new ArrayList<String>();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.query(sql, new ResultSetExtractor<List>() {
                    public List extractData(ResultSet rs) throws SQLException {
                        while (rs.next()) {
                            String id = rs.getString("id");
                            String fName = rs.getString("firstname");
                            String lName = rs.getString("lastname");
                            String uname = rs.getString("username");
                            String country = rs.getString("country");
                            String zCode = rs.getString("zipcode");
                            String address = rs.getString("address");
                            mem.add(id);
                            mem.add(fName);
                            mem.add(lName);
                            mem.add(uname);
                            mem.add(country);
                            mem.add(zCode);
                            mem.add(address);
                        }
                        return mem;
                    }

                }
        );
        return mem;
    }


}
