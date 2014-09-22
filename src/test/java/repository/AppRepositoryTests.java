package repository;

import app.repository.AppRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/app-context.xml")
public class AppRepositoryTests {

    @Autowired
    private AppRepository repository;

    @Test
    public void testSetup() throws Exception {
        assertThat(repository,is(notNullValue()));
    }

    @Test
    public void testFindOnPrimary() throws Exception {
        assertThat(repository.findOnPrimary(), is(empty()));
    }

    @Test
    public void testFindOnSecondary() throws Exception {
        assertThat(repository.findOnSecondary(), is(empty()));
    }
}