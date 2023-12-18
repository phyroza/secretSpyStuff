package com.tomslabs.exercises.javaImpatnient.chapter2;

import java.util.ArrayList;
import java.util.List;

public class Exercise15 {

    private static class Network {
        List<Member> members = new ArrayList<>();

        public Member enroll(String name) {
            Member newMember = this.new Member(name);
            members.add(newMember);
            return newMember;
        }

        public void unenroll(Member member) {
            members.remove(member);
        }

        private class Member {
            String name;
            List<Member> friends;

            public Member(String name) {
                this.name = name;
                this.friends = new ArrayList<>();
            }

            public void deactivate() {
                Network.this.members.remove(this);
            }
        }
    }

    public static void main(String[] args) {
        var myNetwork = new Network();
        Network.Member john = myNetwork.enroll("John");
        john.deactivate();
        Network.Member jane = myNetwork.enroll("Jane");
        myNetwork.unenroll(jane);
    }
}
