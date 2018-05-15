package com.example.demo.Service;

public class Tour {

    private String tourDescription;
    private int tourId;
    private Member member;

    public String getTourDescription() {
        return tourDescription;
    }

    public void setTourDescription(String tourDescription) {
        this.tourDescription = tourDescription;
    }

    public int getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Tour(String tourDescription, int tourId, Member member) {
        this.tourDescription = tourDescription;
        this.tourId = tourId;
        this.member = member;
    }
}
