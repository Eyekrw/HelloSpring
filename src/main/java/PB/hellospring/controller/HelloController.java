package PB.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller  // HelloController 클래스가 Controller임을 어노테이션
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){  // MVC(model, view, controller)에서의 model임
        model.addAttribute("data", "hello!!");  // 모델의 특성 추가. data(key) --> hello!!(value)
        return "hello";  // templates/hello.html을 찾아가라. 만약에 templates/world.html을 만들고 return "world"하면 world.html페이지로 넘어감
        // 뷰 리졸버(viewResolver)가 /hello를 찾아 처리하는 것.
    }

    @GetMapping("hello-mvc")  // hello-mvc는 동적 컨텐츠를 위한 링크고, 결과로 웹 브라우저에 띄워지는 것은 변환을 모두 거친 hello-template.html이다.
    public String helloMvc(@RequestParam("name") String name, Model model){
                            // RequestParam은 외부에서 인자를 받을 거라는거
                            // RequestParam(value="name", required=false)로 하면 required는 반드시 받아야 하냐. false면 안받아도 된다. 따라서 name을 안받아도 페이지 오류 없이 뜸. null로 뜬다.
                            // required=false를 안하면 페이지 띄울 때 localhost:8080/hello-mvc?name=spring <-- GET방식으로 인자 넘겨주면 오류 안남.
        model.addAttribute("name", name);
        return "hello-template";  // hello-template.html을 찾아가라.
    }

    @GetMapping("hello-string")
    @ResponseBody  // HTTP response message(서버 -> 클라이언트)의 body부에 데이터를 직접 넣겠다.
    public String helloString(@RequestParam("name") String name){
        return "hello "+name;  // 만약에 worldy이라고 name에 GET방식이든 뭐든 써서 넣으면 hello worldy을 리턴하게 됨.
                               // 그러면 이 hello worldy가 HTTP 요청한 클라이언트에게 그대로 전달됨.
                               // 따라서 localhost:8080/hello-string?name=worldy라고 치면 대뜸 화면에 hello worldy가 뜸
    }

    // API의 진가는 클라이언트가 데이터를 요청할 때 드러난다. --> view가 꼭 필요하지 않다는 것.
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;  // 객체를 넘김.
    }

    static class Hello{
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private String name;

    }
}
