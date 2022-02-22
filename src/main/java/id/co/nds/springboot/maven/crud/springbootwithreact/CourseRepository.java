package id.co.nds.springboot.maven.crud.springbootwithreact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<NewCourse, Long>,JpaSpecificationExecutor<NewCourse>{

}
