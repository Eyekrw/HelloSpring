package PB.hellospring.domain;

public class Member {
    private Long id;  // 데베 등등의 시스템이 정하는 고객 번호
    private String name;  // 고객 이름

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
