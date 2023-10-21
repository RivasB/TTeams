package cloud.tteams.comment;
import cloud.tteams.comment.comment.domain.service.ProjectDomainServiceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ProjectDomainServiceTest.class})
@SpringBootTest
public class ProjectManagementApplicationTests {
}
