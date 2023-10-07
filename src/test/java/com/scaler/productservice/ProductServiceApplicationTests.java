package com.scaler.productservice;

import com.scaler.productservice.inheritanceexamples.joinedclass.JTMentorRepository;
import com.scaler.productservice.inheritanceexamples.joinedclass.JTUserRepository;
import com.scaler.productservice.inheritanceexamples.mappedsuperclass.MSMentorRepository;
import com.scaler.productservice.inheritanceexamples.singleclass.*;
import com.scaler.productservice.inheritanceexamples.tableperclass.Mentor;
import com.scaler.productservice.inheritanceexamples.tableperclass.TBCMentorRepository;
import com.scaler.productservice.inheritanceexamples.tableperclass.TBCUserRepository;
import com.scaler.productservice.inheritanceexamples.tableperclass.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductServiceApplicationTests {
//    @Autowired
//    private JTUserRepository userRepository;
//
//    @Autowired
//    private JTMentorRepository mentorRepository;
//
//    @Autowired
//    private STMentorRepository stMentorRepository;
//
//
//    @Autowired
//    private STUserRepository stUserRepository;
//
//
//    @Autowired
//    private STInstructorRepository stInstructorRepository;

    @Autowired
    private TBCMentorRepository tbcMentorRepository;

    @Autowired
    private TBCUserRepository tbcUserRepository;


//    @Autowired
//    private MSMentorRepository msMentorRepository;

    @Test
    void contextLoads() {
    }

    /*@Test
    void testJoinedtableInheritances(){
        User user= new User();
        user.setEmail("shivakantsharma33@gmail.com");
        user.setPassword("password");
        userRepository.save(user);

        Mentor mentor= new Mentor();
        mentor.setEmail("mentor@scaler.com");
        mentor.setPassword("mentpwd");
        mentor.setNumberofMentees(5);
        mentor.setNumberOfSession(50);
        mentorRepository.save(mentor);
    }*/

/*    @Test
    void testSingletableinheritance(){
        User user= new User();
        user.setEmail("shivakantsharma33@gmail.com");
        user.setPassword("password");
        stUserRepository.save(user);

        Mentor mentor= new Mentor();
        mentor.setEmail("mentor@gmail.com");
        mentor.setNumberofMentees(5);
        mentor.setNumberOfSession(25);
        mentor.setPassword("kyubatau");
        stMentorRepository.save(mentor);

        Instructor instructor= new Instructor();
        instructor.setHandsome(true);
        instructor.setEmail("ins@scaler.com");
        instructor.setPassword("ins@321");
        stInstructorRepository.save(instructor);
    }

 */


    @Test
    void testtableperclassinheritance(){
        User user= new User();
        user.setEmail("shivakantsharma33@gmail.com");
        user.setPassword("password");
        tbcUserRepository.save(user);


        Mentor mentor= new Mentor();
        mentor.setEmail("mentor@gmail.com");
        mentor.setNumberofMentees(5);
        mentor.setNumberOfSession(25);
        mentor.setPassword("kyubatau");
        tbcMentorRepository.save(mentor);

    }


     /*@Test
    void testmappedsuperclassinheritance(){


        Mentor mentor= new Mentor();
        mentor.setEmail("mentor@gmail.com");
        mentor.setNumberofMentees(5);
        mentor.setNumberOfSession(25);
        mentor.setPassword("kyubatau");
        msMentorRepository.save(mentor);

    }*/


}
