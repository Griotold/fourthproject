package com.example.fourthproject.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    // Mybatis에서는 DAO라고 불리는 DB Layer 접근자를 사용하는 반면,
    // JPA에선 Repository 인터페이스를 사용
    // JpaRepository<Entity클래스명, PK타입>
    // 곧바로, CRUD 가능!
}
