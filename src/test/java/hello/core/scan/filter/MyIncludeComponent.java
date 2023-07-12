package hello.core.scan.filter;


import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {  // 이게 붙으면 컴포넌트 스캔에 추가할 예정

}
