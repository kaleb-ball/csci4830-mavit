package uno.csci4830.mavitapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uno.csci4830.mavitapi.controller.*;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MavitApiApplicationTests {

	@Autowired
	private AuthenticationController authController;

	@Autowired
	private CommentController commentController;

	@Autowired
	private CommonController commonController;

	@Autowired
	private HomeController homeController;

	@Autowired
	private PageController pageController;

	@Autowired
	private TestController testController;

	@Autowired
	private ThreadController threadController;

	@Test
	void contextLoadsAuth() {
		assertThat(authController).isNotNull();
	}

	@Test
	void contextLoadsComment() {
		assertThat(commentController).isNotNull();
	}

	@Test
	void contextLoadsCommon() {
		assertThat(commonController).isNotNull();
	}

	@Test
	void contextLoadsHome() {
		assertThat(homeController).isNotNull();
	}

	@Test
	void contextLoadsPage() {
		assertThat(pageController).isNotNull();
	}

	@Test
	void contextLoadsTest() {
		assertThat(testController).isNotNull();
	}

	@Test
	void contextLoadsThread() {
		assertThat(threadController).isNotNull();
	}
}
