package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberSeriviceImpl;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationConfigApplicationContext {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);
       // System.out.println("memberService = " + memberService);
       // System.out.println("memberService " + memberService.getClass());

        assertThat(memberService).isInstanceOf(MemberSeriviceImpl.class);
    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType(){
        MemberService memberService = ac.getBean(MemberService.class);
        // System.out.println("memberService = " + memberService);
        // System.out.println("memberService " + memberService.getClass());

        assertThat(memberService).isInstanceOf(MemberSeriviceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2() {
        MemberSeriviceImpl memberService = ac.getBean("memberService",
                MemberSeriviceImpl.class);
        assertThat(memberService).isInstanceOf(MemberSeriviceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회 x")
    void findBeanByNameX()
    {
        //MemberService xxxxx = ac.getBean("xxxxx", MemberService.class);
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxxx", MemberService.class));
    }
}
