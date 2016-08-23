package TestRunner;


import SeleniumTests.ExampleTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class);
@Suite.SuiteClasses({
        ExampleTest.class
})


public class RunAllTests {}
