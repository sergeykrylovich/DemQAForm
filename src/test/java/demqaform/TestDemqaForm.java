package demqaform;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.*;

public class TestDemqaForm {

    @BeforeAll
    void beforeAll () {
        browser = "chrome";
    }

    @Test
    void testForm() {

    }
}
