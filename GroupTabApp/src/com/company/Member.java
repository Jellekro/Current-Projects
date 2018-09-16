package com.company;

import java.util.Iterator;

public class Member {

    private String name;

    public Member(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Member)) return false;

        Member member = (Member) o;

        return getName().equals(member.getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }
}